package com.mns.cda.filsrouge.dto;

public record VoteSubmitDTO(
        Integer eventId,
        Integer rating,
        Integer mvpAthleteId
) {}

