package com.mns.cda.filsrouge.dto;

import java.time.LocalDateTime;

public record EventMedium(long idEvent,
                          String eventName,
                          String eventDescription,
                          LocalDateTime eventDate,
                          long idEventType,
                          long idSport,
                          String sportName,
                          long totalSeatTaken,
                          long maxSeat) {}
