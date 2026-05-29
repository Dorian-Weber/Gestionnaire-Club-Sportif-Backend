package com.mns.cda.filsrouge.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CreateReservation(
        @Min(1)
        int eventId,

        @NotNull
        @Size(min = 1, max = 2, message = "Le nombre de sièges doit être compris entre 1 et 2")
        List<@Min(1) Integer> seatIds
) {
}
