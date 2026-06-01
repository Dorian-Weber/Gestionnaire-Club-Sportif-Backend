package com.mns.cda.filsrouge.dto;

import java.time.LocalDateTime;
import java.util.List;

public record VoteEventDTO(
        int eventId,
        String eventName,
        LocalDateTime eventDate,
        List<AthleteDTO> athletes,
        Integer eventRating,
        String userMvp
) {
}
