package com.mns.cda.filsrouge.dto;

public record ReservationFuture(
        int reservationId,
        EventLight eventLight,
        SeatFull seatFull
) {
}
