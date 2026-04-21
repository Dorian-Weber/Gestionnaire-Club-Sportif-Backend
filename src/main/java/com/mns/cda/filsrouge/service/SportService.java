package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.ISportService;
import com.mns.cda.filsrouge.dao.SportDAO;
import com.mns.cda.filsrouge.model.Sport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SportService implements ISportService {

    protected final SportDAO SportDAO;

    //GetAll
    @Override
    public List<Sport> findAll() { return SportDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Sport> findById(int id) {
        return SportDAO.findById(id);
    }

    //Post
    @Override
    public void create(Sport Sport) {
        Sport.setIdSport(null);
        SportDAO.save(Sport);
    }

    //Delete
    @Override
    public void delete(int id) {
        SportDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(int id, Sport Sport) throws SportNotFoundException {
        Optional<Sport> SportOptional = SportDAO.findById(id);

        if(SportOptional.isEmpty()) {
            throw new SportNotFoundException();
        }
        Sport.setIdSport(id);
        SportDAO.save(Sport);
    }

}
