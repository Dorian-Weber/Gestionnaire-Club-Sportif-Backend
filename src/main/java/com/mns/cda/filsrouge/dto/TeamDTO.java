package com.mns.cda.filsrouge.dto;

import java.util.List;

public record TeamDTO(long idTeam,
                      String teamName,
                      List<AthleteDTO> athletes) {
}
