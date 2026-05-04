package com.mns.cda.filsrouge.dto;

import java.time.LocalDateTime;
import java.util.List;

public record EventFull(long idEvent,
                        String eventName,
                        String eventDescription,
                        LocalDateTime eventDate,
                        String eventTypeName,
                        String sportName,
                        String teamName,
                        List<String> teamAthlete,
                        List<String> athlete,
                        long totalSeatTaken,
                        long maxSeat) {}
