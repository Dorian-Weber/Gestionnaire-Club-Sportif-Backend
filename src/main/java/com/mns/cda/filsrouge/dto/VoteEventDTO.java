package com.mns.cda.filsrouge.dto;


import java.util.List;

public record VoteEventDTO(
        VoteDTO voteDTO,
        List<AthleteDTO> athletes,
        List<TeamDTO> teams
) {
}
