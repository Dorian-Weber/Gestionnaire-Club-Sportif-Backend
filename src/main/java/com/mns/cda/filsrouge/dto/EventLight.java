package com.mns.cda.filsrouge.dto;

import java.time.LocalDateTime;

public record EventLight(long idEvent,
                         String eventName,
                         LocalDateTime eventDate,
                         String sportName) {
}
