package com.mns.cda.filsrouge.dto;

import java.util.List;

public record UserPublicProfil(
        String appUserPseudo,
        List<EventLight> lastEvents,
        List<VoteInfo> lastVotes
) {
}
