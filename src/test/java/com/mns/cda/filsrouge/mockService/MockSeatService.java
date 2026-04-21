package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.ISeatService;
import com.mns.cda.filsrouge.model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MockSeatService implements ISeatService {
    @Override
    public List<Seat> findAll() {
        return List.of(new Seat(1,
                "Test",
                new Level(),
                new Reservation()));
    }

    @Override
    public Optional<Seat> findById(int id) {
        if (id == 1) {
            return Optional.of(new Seat(1,
                    "Test",
                    new Level(),
                    new Reservation()));
        }
        return Optional.empty();
    }

    @Override
    public void create(Seat Seat) {
        Seat.setIdSeat(null);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Seat Seat) throws SeatNotFoundException {
        if (id != 1) {
            throw new SeatNotFoundException();
        }
        Seat.setIdSeat(id);

    }
}
