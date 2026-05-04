package com.mns.cda.filsrouge.dto;

import java.util.List;

public record TeamEvent(long idTeam,
                        String teamName,
                        List<AthleteEvent> athletes) {
}
