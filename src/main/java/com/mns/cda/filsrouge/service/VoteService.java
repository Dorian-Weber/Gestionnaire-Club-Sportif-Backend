package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IVoteService;
import com.mns.cda.filsrouge.dao.*;
import com.mns.cda.filsrouge.dto.VoteDTO;
import com.mns.cda.filsrouge.dto.VoteEventDTO;
import com.mns.cda.filsrouge.dto.VoteSubmitDTO;
import com.mns.cda.filsrouge.model.Vote;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoteService implements IVoteService {

    protected final VoteDAO voteDAO;
    private final AthleteDAO athleteDAO;
    private final TeamService teamService;
    private final AppUserDAO appUserDAO;
    private final EventDAO eventDAO;

    //GetAll
    @Override
    public List<Vote> findAll() { return voteDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Vote> findById(Vote.VoteKey id) {
        return voteDAO.findById(id);
    }

    //Get ALl vote ou l'utilisateur n'a pas encore vote mais à participer à l'événement
    @Override
    public List<VoteEventDTO> getPendingVotes(Integer userId) {

        List<VoteDTO> raw = voteDAO.findPendingVotes(userId);

        return raw.stream()
                .map(v -> new VoteEventDTO(
                        v,
                        athleteDAO.findAthleteByEvent(v.eventId()),
                        teamService.getTeamsForEvent(v.eventId())
                ))
                .toList();
    }

    @Override
    public List<VoteEventDTO> getCompletedVotes(Integer userId) {

        List<VoteDTO> raw = voteDAO.findCompletedVotes(userId);


        return raw.stream()
                .map(v -> new VoteEventDTO(
                        v,
                        athleteDAO.findAthleteByEvent(v.eventId()),
                        teamService.getTeamsForEvent(v.eventId())
                ))
                .toList();
    }

    @Transactional
    public void create(VoteSubmitDTO dto, int userId) {
        Vote.VoteKey voteKey = new Vote.VoteKey(userId, dto.eventId());

        // Vérifier si un vote existe déjà
        if (voteDAO.findById(voteKey).isPresent()) {
            throw new RuntimeException("Vote déjà existant — utiliser update()");
        }

        Vote vote = new Vote();
        vote.setVoteKey(voteKey);
        //Vérifie si l'événement, l'athlète et l'utilisateur existe déjà
        vote.setUser(
                appUserDAO.findById(userId)
                        .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"))
        );
        vote.setEvent(
                eventDAO.findById(dto.eventId())
                        .orElseThrow(() -> new RuntimeException("Événement introuvable"))
        );
        vote.setEventRating(dto.rating());
        vote.setAthlete(
                athleteDAO.findById(dto.mvpAthleteId())
                        .orElseThrow(() -> new RuntimeException("Athlète introuvable"))
        );
        voteDAO.save(vote);
    }

    //Delete
    @Override
    public void delete(Vote.VoteKey id) {
        voteDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(Vote.VoteKey id, Vote Vote) throws VoteNotFoundException {
        Optional<Vote> VoteOptional = voteDAO.findById(id);

        if(VoteOptional.isEmpty()) {
            throw new VoteNotFoundException();
        }
        Vote.setVoteKey(id);
        voteDAO.save(Vote);
    }

}
