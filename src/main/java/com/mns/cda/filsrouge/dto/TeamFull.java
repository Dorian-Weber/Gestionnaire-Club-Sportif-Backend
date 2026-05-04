package com.mns.cda.filsrouge.dto;

import java.util.List;

public record TeamFull(long idTeam,
                       String teamName,
                       List<AthleteDTO> athletes) {
}
