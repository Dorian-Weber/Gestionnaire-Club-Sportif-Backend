package com.mns.cda.filsrouge.aggregation;

import com.mns.cda.filsrouge.Iservice.ISeatService;
import com.mns.cda.filsrouge.dao.RelationDAO;
import com.mns.cda.filsrouge.dao.ReservationDAO;
import com.mns.cda.filsrouge.dao.SeatDAO;
import com.mns.cda.filsrouge.dto.FriendDTO;
import com.mns.cda.filsrouge.dto.SeatDTO;
import com.mns.cda.filsrouge.model.Reservation;
import com.mns.cda.filsrouge.model.Seat;
import com.mns.cda.filsrouge.service.RelationService;
import com.mns.cda.filsrouge.service.ReservationService;
import com.mns.cda.filsrouge.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class SeatAggregationService {
    private final SeatDAO seatDAO;
    private final ReservationDAO reservationDAO;
    private final RelationDAO relationDAO;

    public List<SeatDTO> getSeatsForEvent(int eventId,
                                          int currentUserId,
                                          String platform,
                                          String level
    ){
        // Récupère séparément toutes les données utiles dans l'aggregation
        List<Seat> seats = seatDAO.findByPlatformAndLevel(platform, level);
        List<Reservation> reservations = reservationDAO.findReservationByIdEvent(eventId);
        List<FriendDTO> friends = relationDAO.findListFriendsByIdUser(currentUserId);

        // Récupère les ids liées à la liste d'amis, utilisation de set sécurisé et éviter les doublons.
        Set<Integer> friendIds = friends.stream()
                .map(FriendDTO::idAppUser)
                .collect(Collectors.toSet());

        return seats.stream()
            .map(seat -> {
                Reservation reservation = reservations.stream()
                .filter(r ->r.getSeats().contains(seat))
                .findFirst().orElse(null);

                boolean reserved = reservation != null;
                boolean reservedByFriend = false;

                if (reserved){
                    Integer reserverId = reservation.getUser().getIdAppUser();

                    FriendDTO friend = friends.stream()
                            .filter(f -> f.idAppUser().equals(reserverId))
                            .findFirst()
                            .orElse(null);

                    boolean isFriend = friend != null;
                    boolean canSee = false;

                    if (isFriend){
                        String accountTypeName = friend.accountTypeName();

                        if (accountTypeName.equals("User public") || accountTypeName.equals("User private")){
                            canSee = true;
                        }
                    }

                reservedByFriend = isFriend && canSee;
                }

                return new SeatDTO(
                        seat.getIdSeat(),
                        seat.getSeatNumber(),
                        reserved,
                        reservedByFriend
                );
            }).toList();
    }
}
