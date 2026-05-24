package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IReservationService;
import com.mns.cda.filsrouge.dao.EventDAO;
import com.mns.cda.filsrouge.dao.ReservationDAO;
import com.mns.cda.filsrouge.dao.SeatDAO;
import com.mns.cda.filsrouge.dto.CanReserveDTO;
import com.mns.cda.filsrouge.model.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService implements IReservationService {

    protected final ReservationDAO reservationDAO;
    protected final SeatDAO seatDAO;
    protected final EventDAO eventDAO;

    //GetAll
    @Override
    public List<Reservation> findAll() { return reservationDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Reservation> findById(int id) {
        return reservationDAO.findById(id);
    }

    //GetById Event and User
    public boolean userHasReservation(int eventId, int userId) {
        return reservationDAO.userHasReservation(eventId, userId);
    }

    public CanReserveDTO canReserve(int eventId, int userId) {

        boolean alreadyReserved = reservationDAO.userHasReservation(eventId, userId);

        boolean isFull = seatDAO.isFull(eventId);

        boolean isPast = eventDAO.findById(eventId)
                .map(e -> e.getEventDate().isBefore(LocalDateTime.now()))
                .orElse(true);

        return new CanReserveDTO(alreadyReserved, isFull, isPast);
    }



    //Post
    @Override
    public void create(Reservation Reservation) {
        Reservation.setIdReservation(null);
        reservationDAO.save(Reservation);
    }

    //Delete
    @Override
    public void delete(int id) {
        reservationDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(int id, Reservation Reservation) throws ReservationNotFoundException {
        Optional<Reservation> ReservationOptional = reservationDAO.findById(id);

        if(ReservationOptional.isEmpty()) {
            throw new ReservationNotFoundException();
        }
        Reservation.setIdReservation(id);
        reservationDAO.save(Reservation);
    }

}
