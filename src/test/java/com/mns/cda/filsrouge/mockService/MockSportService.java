package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.ISportService;
import com.mns.cda.filsrouge.dto.SportField;
import com.mns.cda.filsrouge.model.*;

import java.util.List;
import java.util.Optional;

public class MockSportService implements ISportService {
    @Override
    public List<Sport> findAll() {
        return List.of(new Sport(1,
                "Athlétisme",
                List.of(new Discipline()),
                List.of(new Event())));
    }

    //TODO
    @Override
    public List<SportField> findAllSportField() {
        return List.of(
                new SportField(1, "Football"),
                new SportField(2, "Basketball")
        );
    }
    @Override
    public Optional<Sport> findById(int id) {
        if (id == 1) {
            return Optional.of(new Sport(1,
                    "Athlétisme",
                    List.of(new Discipline()),
                    List.of(new Event())));
        }
        return Optional.empty();
    }

    @Override
    public void create(Sport Sport) {
        Sport.setIdSport(null);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Sport Sport) throws SportNotFoundException {
        if (id != 1) {
            throw new SportNotFoundException();
        }
        Sport.setIdSport(id);

    }
}
