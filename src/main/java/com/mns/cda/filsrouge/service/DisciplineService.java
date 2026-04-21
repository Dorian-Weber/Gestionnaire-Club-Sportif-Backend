package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IDisciplineService;
import com.mns.cda.filsrouge.dao.DisciplineDAO;
import com.mns.cda.filsrouge.model.Discipline;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DisciplineService implements IDisciplineService{

    protected final DisciplineDAO disciplineDAO;

    //GetAll
    @Override
    public List<Discipline> findAll() { return disciplineDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Discipline> findById(int id) {
        return disciplineDAO.findById(id);
    }

    //Post
    @Override
    public void create(Discipline discipline) {
        discipline.setIdDiscipline(null);
        disciplineDAO.save(discipline);
    }

    //Delete
    @Override
    public void delete(int id) {
        disciplineDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(int id, Discipline discipline) throws DisciplineNotFoundException {
        Optional<Discipline> disciplineOptional = disciplineDAO.findById(id);

        if(disciplineOptional.isEmpty()) {
            throw new DisciplineNotFoundException();
        }
        discipline.setIdDiscipline(id);
        disciplineDAO.save(discipline);
    }

}
