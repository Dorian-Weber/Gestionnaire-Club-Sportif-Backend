package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.model.Relation;

import java.util.List;
import java.util.Optional;

public interface IRelationService {

    public static class RelationNotFoundException extends Exception {}

    //GetAll
    List<Relation> findAll();

    //GetByID
    Optional<Relation> findById(Relation.Key id);

    //Post
    void create(Relation Relation);

    //Delete
    void delete(Relation.Key id);

    //Put
    void update(Relation.Key id , Relation relation) throws RelationNotFoundException;

}
