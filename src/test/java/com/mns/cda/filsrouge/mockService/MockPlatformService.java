package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.IPlatformService;
import com.mns.cda.filsrouge.model.Level;
import com.mns.cda.filsrouge.model.Platform;
import com.mns.cda.filsrouge.model.Platform;
import com.mns.cda.filsrouge.model.Seat;

import java.util.List;
import java.util.Optional;

public class MockPlatformService implements IPlatformService {
    @Override
    public List<Platform> findAll() {
        return List.of(new Platform(1,
                "Test",List.of(new Level())));
    }

    @Override
    public Optional<Platform> findById(int id) {
        if (id == 1) {
            return Optional.of(new Platform(1,
                    "Test",List.of(new Level())));
        }
        return Optional.empty();
    }

    @Override
    public void create(Platform Platform) {
        Platform.setIdPlatform(null);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Platform Platform) throws PlatformNotFoundException {
        if (id != 1) {
            throw new PlatformNotFoundException();
        }
        Platform.setIdPlatform(id);

    }
}
