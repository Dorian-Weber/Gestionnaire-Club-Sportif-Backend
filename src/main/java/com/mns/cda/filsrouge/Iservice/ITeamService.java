package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.dto.TeamDTO;
import com.mns.cda.filsrouge.model.Team;

import java.util.List;
import java.util.Optional;

public interface ITeamService {

    public static class TeamNotFoundException extends Exception {}

    //GetAll
    List<Team> findAll();

    //GetByID
    Optional<Team> findById(int id);

    List<Team> findByEventId(int idEvent);

    public TeamDTO getTeamDTO(int idTeam);

    //Post
    void create(Team Team);

    //Delete
    void delete(int id);

    //Put
    void update(int id, Team Team) throws TeamNotFoundException;

}
