package com.mns.cda.filsrouge.dto;

import java.util.List;

public record EventFull( EventMedium eventMedium,
                        List<TeamDTO> teams,
                        List<AthleteDTO> athletes
                        ) {}
