package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.ILevelService;
import com.mns.cda.filsrouge.model.Event;
import com.mns.cda.filsrouge.model.Level;
import com.mns.cda.filsrouge.model.Platform;
import com.mns.cda.filsrouge.model.Seat;

import java.util.List;
import java.util.Optional;

public class MockLevelService implements ILevelService {
    @Override
    public List<Level> findAll() {
        return List.of(new Level(1,
                "Test",
                List.of(new Seat()),
                new Platform()));
    }

    @Override
    public Optional<Level> findById(int id) {
        if (id == 1) {
            return Optional.of(new Level(1,
                    "Test",
                    List.of(new Seat()),
                    new Platform()));
        }
        return Optional.empty();
    }

    @Override
    public void create(Level Level) {
        Level.setIdLevel(null);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Level Level) throws LevelNotFoundException {
        if (id != 1) {
            throw new LevelNotFoundException();
        }
        Level.setIdLevel(id);

    }
}
