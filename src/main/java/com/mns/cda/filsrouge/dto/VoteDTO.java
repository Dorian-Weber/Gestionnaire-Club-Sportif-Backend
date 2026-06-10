package com.mns.cda.filsrouge.dto;

import java.time.LocalDateTime;

public record VoteDTO(
        int eventId,
        String eventName,
        LocalDateTime eventDate,
        Integer eventRating,
        Integer userMvp
) {
}
