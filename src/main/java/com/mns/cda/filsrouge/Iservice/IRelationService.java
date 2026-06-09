package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.dto.AppUserLight;
import com.mns.cda.filsrouge.dto.FriendDTO;
import com.mns.cda.filsrouge.dto.RelationDTO;
import com.mns.cda.filsrouge.enumerate.RelationStatus;
import com.mns.cda.filsrouge.model.Relation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    //Get AppUser pour recherche d'ami
    public Page<AppUserLight> searchUsers(int idUser, String query, Pageable pageable);

    //Post
    public RelationDTO createFriendRequest(int firstId, int secondId);

    //Delete
    void delete(Relation.Key id);

    //Put
    void updateRelationStatus(int firstId, int secondId , RelationStatus relationStatus) throws RelationNotFoundException;

}
