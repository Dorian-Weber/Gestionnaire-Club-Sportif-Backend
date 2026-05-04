package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IAthleteService;
import com.mns.cda.filsrouge.dao.AthleteDAO;
import com.mns.cda.filsrouge.dto.AthleteDTO;
import com.mns.cda.filsrouge.model.Athlete;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AthleteService implements IAthleteService{

    protected final AthleteDAO athleteDAO;

    //GetAll
    @Override
    public List<Athlete> findAll() { return athleteDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Athlete> findById(int id) {
        return athleteDAO.findById(id);
    }

    @Override
    public List<AthleteDTO> findAthleteByEvent(int idEvent) {
        return athleteDAO.findAthleteByEvent(idEvent);
    }

    @Override
    public List<AthleteDTO> findAthleteByTeam(int idTeam) {
        return athleteDAO.findAthleteByTeam(idTeam);
    }

    //Post
    @Override
    public void create(Athlete athlete) {
        athlete.setIdAthlete(null);
        athleteDAO.save(athlete);
    }

    //Delete
    @Override
    public void delete(int id) {
        athleteDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(int id, Athlete athlete) throws AthleteNotFoundException {
        Optional<Athlete> athleteOptional = athleteDAO.findById(id);

        if(athleteOptional.isEmpty()) {
            throw new AthleteNotFoundException();
        }
        athlete.setIdAthlete(id);
        athleteDAO.save(athlete);
    }

}
