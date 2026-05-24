package com.mns.cda.filsrouge.dto;

public record CanReserveDTO(
        boolean alreadyReserved,
        boolean isFull,
        boolean isPast
) {}
