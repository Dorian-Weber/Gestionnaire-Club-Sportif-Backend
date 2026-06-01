package com.mns.cda.filsrouge.dto;

public record VoteLight(
        int eventId,
        String eventName,
        int rating,
        String AthleteName,
        String AthleteFirstName
) {}