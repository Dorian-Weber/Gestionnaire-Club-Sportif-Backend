package com.mns.cda.filsrouge.aggregation;

import com.mns.cda.filsrouge.dao.RelationDAO;
import com.mns.cda.filsrouge.dao.ReservationDAO;
import com.mns.cda.filsrouge.dao.SeatDAO;
import com.mns.cda.filsrouge.dto.FriendDTO;
import com.mns.cda.filsrouge.dto.SeatDTO;
import com.mns.cda.filsrouge.enumerate.UserVisibility;
import com.mns.cda.filsrouge.model.Reservation;
import com.mns.cda.filsrouge.model.Seat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeatAggregationService implements ISeatAggregationService {

    private final SeatDAO seatDAO;
    private final ReservationDAO reservationDAO;
    private final RelationDAO relationDAO;

    @Override
    public List<SeatDTO> getSeatsForEvent(int eventId,
                                          int currentUserId,
                                          String platform,
                                          String level) {

        List<Seat> seats = seatDAO.findByPlatformAndLevel(platform, level);
        List<Reservation> reservations = reservationDAO.findReservationByIdEvent(eventId);
        List<FriendDTO> friends = relationDAO.findListFriendsByIdUser(currentUserId);

        // Set des IDs amis
        Set<Integer> friendIds = friends.stream()
                .map(FriendDTO::idAppUser)
                .collect(Collectors.toSet());

        return seats.stream().map(seat -> {

            Reservation reservation = reservations.stream()
                    .filter(r -> r.getSeats().contains(seat))
                    .findFirst()
                    .orElse(null);

            boolean reserved = reservation != null;
            boolean reservedByFriend = isReservedByFriend(reserved, reservation, friendIds);

            return new SeatDTO(
                    seat.getIdSeat(),
                    seat.getSeatNumber(),
                    reserved,
                    reservedByFriend
            );
        }).toList();
    }


    private static boolean isReservedByFriend(boolean reserved, Reservation reservation, Set<Integer> friendIds) {
        boolean reservedByFriend = false;

        if (reserved) {
            Integer reserverId = reservation.getUser().getIdAppUser();

            boolean isFriend = friendIds.contains(reserverId);

            if (isFriend) {
                UserVisibility visibility = reservation.getUser().getAppUserVisibility();

                reservedByFriend = switch (visibility) {
                    case PUBLIC, PRIVATE -> true;
                    case CLOSE -> false;
                };
            }
        }
        return reservedByFriend;
    }
}
