package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IReservationService;
import com.mns.cda.filsrouge.dao.ReservationDAO;
import com.mns.cda.filsrouge.model.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService implements IReservationService {

    protected final ReservationDAO ReservationDAO;

    //GetAll
    @Override
    public List<Reservation> findAll() { return ReservationDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Reservation> findById(int id) {
        return ReservationDAO.findById(id);
    }

    //Post
    @Override
    public void create(Reservation Reservation) {
        Reservation.setIdReservation(null);
        ReservationDAO.save(Reservation);
    }

    //Delete
    @Override
    public void delete(int id) {
        ReservationDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(int id, Reservation Reservation) throws ReservationNotFoundException {
        Optional<Reservation> ReservationOptional = ReservationDAO.findById(id);

        if(ReservationOptional.isEmpty()) {
            throw new ReservationNotFoundException();
        }
        Reservation.setIdReservation(id);
        ReservationDAO.save(Reservation);
    }

}
