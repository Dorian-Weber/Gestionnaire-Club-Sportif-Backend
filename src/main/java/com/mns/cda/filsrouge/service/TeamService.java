package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.ITeamService;
import com.mns.cda.filsrouge.dao.TeamDAO;
import com.mns.cda.filsrouge.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService implements ITeamService {

    protected final TeamDAO TeamDAO;

    //GetAll
    @Override
    public List<Team> findAll() { return TeamDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Team> findById(int id) {
        return TeamDAO.findById(id);
    }

    @Override
    public List<Team> findByEventId(int idEvent) {
        return List.of();
    }

    //Post
    @Override
    public void create(Team Team) {
        Team.setIdTeam(null);
        TeamDAO.save(Team);
    }

    //Delete
    @Override
    public void delete(int id) {
        TeamDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(int id, Team Team) throws TeamNotFoundException {
        Optional<Team> TeamOptional = TeamDAO.findById(id);

        if(TeamOptional.isEmpty()) {
            throw new TeamNotFoundException();
        }
        Team.setIdTeam(id);
        TeamDAO.save(Team);
    }

}
