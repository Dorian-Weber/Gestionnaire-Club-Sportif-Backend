package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.model.Team;

import java.util.List;
import java.util.Optional;

public interface ITeamService {

    public static class TeamNotFoundException extends Exception {}

    //GetAll
    List<Team> findAll();

    //GetByID
    Optional<Team> findById(int id);

    //GetTeamsByEvent
    List<Team> findByEventId(int idEvent);

    //Post
    void create(Team Team);

    //Delete
    void delete(int id);

    //Put
    void update(int id, Team Team) throws TeamNotFoundException;

}
