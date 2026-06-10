package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IVoteService;
import com.mns.cda.filsrouge.dao.AthleteDAO;
import com.mns.cda.filsrouge.dao.EventDAO;
import com.mns.cda.filsrouge.dao.TeamDAO;
import com.mns.cda.filsrouge.dao.VoteDAO;
import com.mns.cda.filsrouge.dto.TeamDTO;
import com.mns.cda.filsrouge.dto.VoteDTO;
import com.mns.cda.filsrouge.dto.VoteEventDTO;
import com.mns.cda.filsrouge.model.Vote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoteService implements IVoteService {

    protected final VoteDAO VoteDAO;
    private final AthleteDAO athleteDAO;
    private final TeamService teamService;

    //GetAll
    @Override
    public List<Vote> findAll() { return VoteDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Vote> findById(Vote.VoteKey id) {
        return VoteDAO.findById(id);
    }

    //Get ALl vote ou l'utilisateur n'a pas encore vote mais à participer à l'événement
    @Override
    public List<VoteEventDTO> getPendingVotes(Integer userId) {

        List<VoteDTO> raw = VoteDAO.findPendingVotes(userId);

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

        List<VoteDTO> raw = VoteDAO.findCompletedVotes(userId);


        return raw.stream()
                .map(v -> new VoteEventDTO(
                        v,
                        athleteDAO.findAthleteByEvent(v.eventId()),
                        teamService.getTeamsForEvent(v.eventId())
                ))
                .toList();
    }




    //Post
    @Override
    public void create(Vote Vote) {
        Vote.setVoteKey(null);
        VoteDAO.save(Vote);
    }

    //Delete
    @Override
    public void delete(Vote.VoteKey id) {
        VoteDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(Vote.VoteKey id, Vote Vote) throws VoteNotFoundException {
        Optional<Vote> VoteOptional = VoteDAO.findById(id);

        if(VoteOptional.isEmpty()) {
            throw new VoteNotFoundException();
        }
        Vote.setVoteKey(id);
        VoteDAO.save(Vote);
    }

}
