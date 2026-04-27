package com.mns.cda.filsrouge.dto;

import java.time.LocalDateTime;

public record EventLight(Integer idEvent,
                         String eventName,
                         LocalDateTime eventDate,
                         String sportName) {}
