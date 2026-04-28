package com.mns.cda.filsrouge.dto;

import java.time.LocalDateTime;

public record EventMedium(long idEvent,
                          String eventName,
                          String eventDescription,
                          LocalDateTime eventDate,
                          String eventTypeName,
                          String sportName,
                          long totalSeatTaken,
                          long maxSeat) {}
