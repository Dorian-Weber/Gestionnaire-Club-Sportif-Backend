package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.IDisciplineService;
import com.mns.cda.filsrouge.model.Athlete;
import com.mns.cda.filsrouge.model.Discipline;
import com.mns.cda.filsrouge.model.Sport;

import java.util.List;
import java.util.Optional;

public class MockDisciplineService implements IDisciplineService {
    @Override
    public List<Discipline> findAll() {
        return List.of(new Discipline(1,
                "Saut en hauteur",
                "2.45m",
                "2.45 m",
                new Sport(),
                List.of(new Athlete())));
    }

    @Override
    public Optional<Discipline> findById(int id) {
        if (id == 1) {
            return Optional.of(new Discipline(1,
                    "Saut en hauteur",
                    "2.45m",
                    "2.45 m",
                    new Sport(),
                    List.of(new Athlete())));
        }
        return Optional.empty();
    }

    @Override
    public void create(Discipline Discipline) {
        Discipline.setIdDiscipline(null);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Discipline Discipline) throws DisciplineNotFoundException {
        if (id != 1) {
            throw new DisciplineNotFoundException();
        }
        Discipline.setIdDiscipline(id);

    }
}
