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

    protected final SeatDAO seatDAO;

    //GetAll
    @Override
    public List<Seat> findAll() { return seatDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Seat> findById(int id) {
        return seatDAO.findById(id);
    }

    //GetSeatBy IdPlatform et IdLevel
    public List<Seat> findByPlatformAndLevel(String platform, String level) {
        return seatDAO.findByPlatformAndLevel(platform, level);
    }

    //Post
    @Override
    public void create(Seat Seat) {
        Seat.setIdSeat(null);
        seatDAO.save(Seat);
    }

    //Delete
    @Override
    public void delete(int id) {
        seatDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(int id, Seat Seat) throws SeatNotFoundException {
        Optional<Seat> SeatOptional = seatDAO.findById(id);

        if(SeatOptional.isEmpty()) {
            throw new SeatNotFoundException();
        }
        Seat.setIdSeat(id);
        seatDAO.save(Seat);
    }

}
