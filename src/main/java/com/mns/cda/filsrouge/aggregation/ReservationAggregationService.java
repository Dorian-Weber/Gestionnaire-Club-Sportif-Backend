package com.mns.cda.filsrouge.aggregation;

import com.mns.cda.filsrouge.Iservice.IQRCodeService;
import com.mns.cda.filsrouge.dao.ReservationDAO;
import com.mns.cda.filsrouge.dto.EventLight;
import com.mns.cda.filsrouge.dto.ReservationQRCodeDTO;
import com.mns.cda.filsrouge.dto.SeatFull;
import com.mns.cda.filsrouge.model.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationAggregationService {

    private final ReservationDAO reservationDAO;
    private final IQRCodeService qrCodeService;

    //Crée un ReservationQRCodeDTO à partir d'une réservation, en incluant les infos de l'événement, des sièges, du statut de présence et du QR code
    public ReservationQRCodeDTO getReservationQRCode(Integer reservationId) {

        Reservation reservation = reservationDAO.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found!"));

        EventLight event = reservationDAO.getEventLightByReservationId(reservationId);
        List<SeatFull> seats = reservationDAO.getSeatsFullByReservationId(reservationId);

        String statusPresence = reservation.getStatusPresence().getStatusPresenceName();

        String qrContent = "RES:" + reservationId + "|TOKEN:" + reservation.getQrToken();
        String qrBase64 = qrCodeService.generateQRCodeBase64(qrContent);

        return new ReservationQRCodeDTO(
                reservation.getIdReservation(),
                event,
                seats,
                statusPresence,
                qrBase64
        );
    }

    //Crée une liste de ReservationQRCode pour un utilisateur.
    public List<ReservationQRCodeDTO> getReservationsForUser(Integer userId) {

        List<Reservation> reservations = reservationDAO.findByUserId(userId);

        return reservations.stream()
                .map(r -> getReservationQRCode(r.getIdReservation()))
                .toList();
    }

}

