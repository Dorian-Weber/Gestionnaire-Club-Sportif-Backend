package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.IAthleteService;
import com.mns.cda.filsrouge.dto.AthleteDTO;
import com.mns.cda.filsrouge.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MockAthleteService implements IAthleteService {
    @Override
    public List<Athlete> findAll() {
        return List.of(new Athlete(1,
                "Dupont","Jean",
                LocalDate.now().minusDays(1),
                List.of(new Event()),
                List.of(new Team()),
                List.of(new Discipline()),
                new Country(),
                List.of(new Vote())));
    }

    @Override
    public Optional<Athlete> findById(int id) {
        if (id == 1) {
            return Optional.of(new Athlete(1,
                    "Dupont","Jean",
                    LocalDate.now().minusDays(1),
                    List.of(new Event()),
                    List.of(new Team()),
                    List.of(new Discipline()),
                    new Country(),
                    List.of(new Vote())));
        }
        return Optional.empty();
    }

    //TODO
    @Override
    public List<AthleteDTO> findAthleteByEvent(int idEvent) {
        return List.of();
    }

    //TODO
    @Override
    public List<AthleteDTO> findAthleteByTeam(int idTeam) {
        return List.of();
    }

    @Override
    public void create(Athlete athlete) {
        athlete.setIdAthlete(null);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Athlete athlete) throws AthleteNotFoundException {
        if (id != 1) {
            throw new AthleteNotFoundException();
        }
        athlete.setIdAthlete(id);

    }
}
