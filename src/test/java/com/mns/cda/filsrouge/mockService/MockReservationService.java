package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.IReservationService;
import com.mns.cda.filsrouge.dto.CanReserveDTO;
import com.mns.cda.filsrouge.dto.CreateReservation;
import com.mns.cda.filsrouge.dto.ReservationConfirmation;
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
                new AppUser(1),
                List.of(new Seat()),
                "qr-token-123"));
    }

    @Override
    public Optional<Reservation> findById(int id) {
        if (id == 1) {
            return Optional.of(new Reservation(1,
                    LocalDateTime.now(),
                    new StatusPresence(),
                    new Event(),
                    new AppUser(1),
                    List.of(new Seat()),
                    "qr-token-123"));
        }
        return Optional.empty();
    }


    @Override
    public CanReserveDTO canReserve(int eventId, int userId) {
        return new CanReserveDTO(false, false, false);
    }

    @Override
    public ReservationConfirmation createReservation(CreateReservation dto, int userId) {
        List<String> seatNames = dto.seatIds().stream()
                .map(Object::toString)
                .toList();
        return new ReservationConfirmation(99, "Event Test", seatNames);
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
