package com.mns.cda.filsrouge.dto;

public record VoteInfo(
        int eventId,
        String eventName,
        int eventRating,
        int athleteId,
        String athleteName,
        String athleteFirstName
) {}