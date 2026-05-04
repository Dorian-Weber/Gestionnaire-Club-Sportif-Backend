package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.ITeamService;
import com.mns.cda.filsrouge.dao.AthleteDAO;
import com.mns.cda.filsrouge.dao.TeamDAO;
import com.mns.cda.filsrouge.dto.AthleteDTO;
import com.mns.cda.filsrouge.dto.TeamDTO;
import com.mns.cda.filsrouge.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService implements ITeamService {

    protected final TeamDAO TeamDAO;
    private final AthleteDAO athleteDAO;

    //GetAll
    @Override
    public List<Team> findAll() { return TeamDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Team> findById(int id) {
        return TeamDAO.findById(id);
    }

    @Override
    public List<Team> findTeamByEventId(int idEvent) {
        return TeamDAO.findTeamByEventId(idEvent);
    }

    //Aggregation de TeamDTO
    public TeamDTO getTeamDTO(int idTeam) {

        Team team = TeamDAO.findById(idTeam)
                .orElseThrow(() -> new RuntimeException("Team non trouvée"));

        List<AthleteDTO> athletes = athleteDAO.findAthleteByTeam(idTeam);

        return new TeamDTO(
                team.getIdTeam(),
                team.getTeamName(),
                athletes
        );
    }

    @Override
    public List<Team> findByEventId(int idEvent) {
        return TeamDAO.findTeamByEventId(idEvent);
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
