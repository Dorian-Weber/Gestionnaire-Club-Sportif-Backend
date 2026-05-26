package com.mns.cda.filsrouge.dto;

import java.util.List;

public record ReservationConfirmation(
        int reservationId,
        String eventName,
        List<String> seats
) {
}
