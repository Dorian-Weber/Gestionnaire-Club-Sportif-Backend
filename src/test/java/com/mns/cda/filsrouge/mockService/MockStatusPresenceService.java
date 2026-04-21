package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.IStatusPresenceService;
import com.mns.cda.filsrouge.model.Discipline;
import com.mns.cda.filsrouge.model.Event;
import com.mns.cda.filsrouge.model.StatusPresence;

import java.util.List;
import java.util.Optional;

public class MockStatusPresenceService implements IStatusPresenceService {
    @Override
    public List<StatusPresence> findAll() {
        return List.of(new StatusPresence(1,
                "Test"));
    }

    @Override
    public Optional<StatusPresence> findById(int id) {
        if (id == 1) {
            return Optional.of(new StatusPresence(1,
                    "Test"));
        }
        return Optional.empty();
    }

    @Override
    public void create(StatusPresence StatusPresence) {
        StatusPresence.setIdStatusPresence(null);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, StatusPresence StatusPresence) throws StatusPresenceNotFoundException {
        if (id != 1) {
            throw new StatusPresenceNotFoundException();
        }
        StatusPresence.setIdStatusPresence(id);

    }
}
