package com.mns.cda.filsrouge.dto;

public record VoteLight(
        int eventId,
        String eventName,
        int eventRating,
        int athleteId,
        String athleteName,
        String athleteFirstName
) {}