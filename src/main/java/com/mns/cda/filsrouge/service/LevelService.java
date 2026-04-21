package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.ILevelService;
import com.mns.cda.filsrouge.dao.LevelDAO;
import com.mns.cda.filsrouge.model.Level;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LevelService implements ILevelService{

    protected final LevelDAO levelDAO;

    //GetAll
    @Override
    public List<Level> findAll() { return levelDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Level> findById(int id) {
        return levelDAO.findById(id);
    }

    //Post
    @Override
    public void create(Level level) {
        level.setIdLevel(null);
        levelDAO.save(level);
    }

    //Delete
    @Override
    public void delete(int id) {
        levelDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(int id, Level level) throws LevelNotFoundException {
        Optional<Level> levelOptional = levelDAO.findById(id);

        if(levelOptional.isEmpty()) {
            throw new LevelNotFoundException();
        }
        level.setIdLevel(id);
        levelDAO.save(level);
    }

}
