package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.ISeatService;
import com.mns.cda.filsrouge.dao.SeatDAO;
import com.mns.cda.filsrouge.model.Seat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatService implements ISeatService {

    protected final SeatDAO SeatDAO;

    //GetAll
    @Override
    public List<Seat> findAll() { return SeatDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Seat> findById(int id) {
        return SeatDAO.findById(id);
    }

    //Post
    @Override
    public void create(Seat Seat) {
        Seat.setIdSeat(null);
        SeatDAO.save(Seat);
    }

    //Delete
    @Override
    public void delete(int id) {
        SeatDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(int id, Seat Seat) throws SeatNotFoundException {
        Optional<Seat> SeatOptional = SeatDAO.findById(id);

        if(SeatOptional.isEmpty()) {
            throw new SeatNotFoundException();
        }
        Seat.setIdSeat(id);
        SeatDAO.save(Seat);
    }

}
