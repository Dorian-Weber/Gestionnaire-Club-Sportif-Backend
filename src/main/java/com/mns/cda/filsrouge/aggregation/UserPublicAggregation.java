package com.mns.cda.filsrouge.aggregation;

import com.mns.cda.filsrouge.controller.AuthController;
import com.mns.cda.filsrouge.dao.AppUserDAO;
import com.mns.cda.filsrouge.dao.EventDAO;
import com.mns.cda.filsrouge.dao.VoteDAO;
import com.mns.cda.filsrouge.dto.UserPublicProfil;
import com.mns.cda.filsrouge.model.AppUser;
import com.mns.cda.filsrouge.service.AppUserService;
import com.mns.cda.filsrouge.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPublicAggregation {
    private final AppUserDAO appUserDAO;
    private final EventDAO eventDAO;
    private final VoteDAO voteDAO;


    public UserPublicProfil getMyPublicProfile(int userId) {

        AppUser user = appUserDAO.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserPublicProfil dto = new UserPublicProfil(
                user.getAppUserPseudo(),
                eventDAO.getLastParticipatedEventWithUserId(user.getIdAppUser())
                ,voteDAO.getLastVoteWithUserId(user.getIdAppUser()));

        return dto;
    }
}
