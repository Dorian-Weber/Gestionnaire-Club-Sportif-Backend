package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.ITeamService;
import com.mns.cda.filsrouge.dto.TeamDTO;
import com.mns.cda.filsrouge.model.Athlete;
import com.mns.cda.filsrouge.model.Event;
import com.mns.cda.filsrouge.model.Team;

import java.util.List;
import java.util.Optional;

public class MockTeamService implements ITeamService {
    @Override
    public List<Team> findAll() {
        return List.of(new Team(1,
                "Test",
                List.of(new Event()),
                List.of(new Athlete())));
    }

    @Override
    public Optional<Team> findById(int id) {
        if (id == 1) {
            return Optional.of(new Team(1,
                    "Test",
                    List.of(new Event()),
                    List.of(new Athlete())));
        }
        return Optional.empty();
    }

    //TODO
    @Override
    public List<Team> findTeamByEventId(int idEvent) {
        return List.of();
    }

    //TODO
    @Override
    public List<Team> findByEventId(int idEvent) {
        return List.of();
    }

    //TODO
    @Override
    public TeamDTO getTeamDTO(int idTeam) {
        return null;
    }

    @Override
    public void create(Team Team) {
        Team.setIdTeam(null);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Team Team) throws TeamNotFoundException {
        if (id != 1) {
            throw new TeamNotFoundException();
        }
        Team.setIdTeam(id);

    }
}
