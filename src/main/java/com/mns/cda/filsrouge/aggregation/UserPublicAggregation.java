package com.mns.cda.filsrouge.aggregation;

import com.google.zxing.NotFoundException;
import com.mns.cda.filsrouge.Iservice.IAppUserService;
import com.mns.cda.filsrouge.controller.AuthController;
import com.mns.cda.filsrouge.dao.AppUserDAO;
import com.mns.cda.filsrouge.dao.EventDAO;
import com.mns.cda.filsrouge.dao.RelationDAO;
import com.mns.cda.filsrouge.dao.VoteDAO;
import com.mns.cda.filsrouge.dto.EventLight;
import com.mns.cda.filsrouge.dto.UserPublicProfil;
import com.mns.cda.filsrouge.dto.VoteInfo;
import com.mns.cda.filsrouge.model.AppUser;
import com.mns.cda.filsrouge.service.AppUserService;
import com.mns.cda.filsrouge.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPublicAggregation {
    private final AppUserDAO appUserDAO;
    private final EventDAO eventDAO;
    private final VoteDAO voteDAO;
    private final RelationDAO relationDAO;


    public UserPublicProfil getMyPublicProfile(int userId) {

        AppUser user = appUserDAO.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserPublicProfil dto = new UserPublicProfil(
                user.getAppUserPseudo(),
                eventDAO.getLastParticipatedEventWithUserId(user.getIdAppUser())
                ,voteDAO.getLastVoteWithUserId(user.getIdAppUser()));

        return dto;
    }

    public UserPublicProfil getPublicProfileOfUser(Integer targetId, Integer visitorId) {

        AppUser target = appUserDAO.findById(targetId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        String visibility = target.getAppUserVisibility().toString(); // PUBLIC / PRIVATE / CLOSED
        boolean isFriend = relationDAO.findRelationBetween(targetId, visitorId).isPresent();

        boolean canSeeData = switch (visibility) {
            case "PUBLIC" -> true;
            case "PRIVATE" -> isFriend;
            case "CLOSED" -> false;
            default -> false;
        };

        List<EventLight> events = canSeeData ? eventDAO.getLastParticipatedEventWithUserId(targetId) : null;
        List<VoteInfo> votes = canSeeData ? voteDAO.getLastVoteWithUserId(targetId) : null;

        return new UserPublicProfil(
                target.getAppUserPseudo(),
                events,
                votes
        );
    }

}
