package com.mns.cda.filsrouge.dto;

import java.util.List;

public record CreateReservation(
        int eventId,
        List<Integer> seatIds
) {
}
