package com.mns.cda.filsrouge.dto;

import com.mns.cda.filsrouge.model.Vote;

import java.util.List;

public record UserPublicProfil(
        String appUserPseudo,
        List<EventLight> lastEvents,
        List<Vote> lastVotes
) {
}
