package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IStatusPresenceService;
import com.mns.cda.filsrouge.dao.StatusPresenceDAO;
import com.mns.cda.filsrouge.model.StatusPresence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StatusPresenceService implements IStatusPresenceService {

    protected final StatusPresenceDAO StatusPresenceDAO;

    //GetAll
    @Override
    public List<StatusPresence> findAll() { return StatusPresenceDAO.findAll(); }

    //GetByID
    @Override
    public Optional<StatusPresence> findById(int id) {
        return StatusPresenceDAO.findById(id);
    }

    //Post
    @Override
    public void create(StatusPresence StatusPresence) {
        StatusPresence.setIdStatusPresence(null);
        StatusPresenceDAO.save(StatusPresence);
    }

    //Delete
    @Override
    public void delete(int id) {
        StatusPresenceDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(int id, StatusPresence StatusPresence) throws StatusPresenceNotFoundException {
        Optional<StatusPresence> StatusPresenceOptional = StatusPresenceDAO.findById(id);

        if(StatusPresenceOptional.isEmpty()) {
            throw new StatusPresenceNotFoundException();
        }
        StatusPresence.setIdStatusPresence(id);
        StatusPresenceDAO.save(StatusPresence);
    }

}
