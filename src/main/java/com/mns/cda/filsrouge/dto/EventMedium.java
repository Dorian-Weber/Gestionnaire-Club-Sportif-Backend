package com.mns.cda.filsrouge.dto;

import java.time.LocalDateTime;

public record EventMedium(long idEvent,
                          String eventName,
                          String eventDescription,
                          LocalDateTime eventDate,
                          String sportName,
                          long totalSeatTaken,
                          long maxSeat) {}
