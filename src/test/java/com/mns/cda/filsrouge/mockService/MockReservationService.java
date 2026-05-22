package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.IReservationService;
import com.mns.cda.filsrouge.model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MockReservationService implements IReservationService {
    @Override
    public List<Reservation> findAll() {
        return List.of(new Reservation(1,
                LocalDateTime.now(),
                new StatusPresence(),
                new Event(),
                new AppUser(),
                List.of(new Seat())));
    }

    @Override
    public Optional<Reservation> findById(int id) {
        if (id == 1) {
            return Optional.of(new Reservation(1,
                    LocalDateTime.now(),
                    new StatusPresence(),
                    new Event(),
                    new AppUser(),
                    List.of(new Seat())));
        }
        return Optional.empty();
    }

    //TODO
    @Override
    public boolean userHasReservation(int eventId, int userId) {
        return false;
    }

    @Override
    public void create(Reservation Reservation) {
        Reservation.setIdReservation(null);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Reservation Reservation) throws ReservationNotFoundException {
        if (id != 1) {
            throw new ReservationNotFoundException();
        }
        Reservation.setIdReservation(id);

    }
}
