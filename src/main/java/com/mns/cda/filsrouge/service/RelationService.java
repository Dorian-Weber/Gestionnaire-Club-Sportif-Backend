package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IRelationService;
import com.mns.cda.filsrouge.dao.RelationDAO;
import com.mns.cda.filsrouge.model.Relation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelationService implements IRelationService {

    protected final RelationDAO RelationDAO;

    //GetAll
    @Override
    public List<Relation> findAll() { return RelationDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Relation> findById(Relation.Key id) {
        return RelationDAO.findById(id);
    }

    //Post
    @Override
    public void create(Relation Relation) {
        Relation.setKey(null);
        RelationDAO.save(Relation);
    }

    //Delete
    @Override
    public void delete(Relation.Key id) {
        RelationDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(Relation.Key id, Relation Relation) throws RelationNotFoundException {
        Optional<Relation> RelationOptional = RelationDAO.findById(id);

        if(RelationOptional.isEmpty()) {
            throw new RelationNotFoundException();
        }
        Relation.setKey(id);
        RelationDAO.save(Relation);
    }

}
