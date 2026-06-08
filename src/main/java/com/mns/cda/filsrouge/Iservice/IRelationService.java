package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.dto.FriendDTO;
import com.mns.cda.filsrouge.enumerate.RelationStatus;
import com.mns.cda.filsrouge.model.Relation;

import java.util.List;
import java.util.Optional;

public interface IRelationService {

    public static class RelationNotFoundException extends Exception {}

    //GetAll
    List<Relation> findAll();

    //GetFriendsById
    public List<FriendDTO> getFriends(int idUser);

    //GetByID
    Optional<Relation> findById(Relation.Key id);

    //GetRelation Between 2 id
    public Optional<Relation> findRelationBetween(int id1, int id2);

    //Get liste demande en attente de l'utilisateur
    public List<FriendDTO> findRequestReceived(int idUser);

    //get liste des demandes envoyées en attente de l'utilisateur
    public List<FriendDTO> findRequestSend(int idUser);

    //Post
    void create(Relation Relation);

    //Delete
    void delete(Relation.Key id);

    //Put
    void update(int firstId, int secondId , RelationStatus relationStatus) throws RelationNotFoundException;

}
