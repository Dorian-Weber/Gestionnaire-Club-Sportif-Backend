package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IRelationService;
import com.mns.cda.filsrouge.dao.RelationDAO;
import com.mns.cda.filsrouge.dto.FriendDTO;
import com.mns.cda.filsrouge.model.Relation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelationService implements IRelationService {

    protected final RelationDAO relationDAO;

    //GetAll
    @Override
    public List<Relation> findAll() { return relationDAO.findAll(); }

    //GetFriendsById
    @Override
    public List<FriendDTO> getFriends(int idUser) {
        return relationDAO.findListFriendsByIdUser(idUser);
    }

    //GetRelation Between 2 ID
    public Optional<Relation> findRelationBetween(int id1, int id2) {
        return relationDAO.findRelationBetween(id1, id2);
    }
    //Get liste demande en attente de l'utilisateur
    public List<FriendDTO> findRequestReceived(int idUser){
        return relationDAO.findPendingReceived(idUser);
    }

    //get liste des demandes envoyées en attente de l'utilisateur
    public List<FriendDTO> findRequestSend(int idUser){
        return relationDAO.findPendingSend(idUser);
    }

    //GetByID
    @Override
    public Optional<Relation> findById(Relation.Key id) {
        return relationDAO.findById(id);
    }

    //Post
    @Override
    public void create(Relation Relation) {
        Relation.setKey(null);
        relationDAO.save(Relation);
    }

    //Delete
    @Override
    public void delete(Relation.Key id) {
        relationDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(Relation.Key id, Relation Relation) throws RelationNotFoundException {
        Optional<Relation> RelationOptional = relationDAO.findById(id);

        if(RelationOptional.isEmpty()) {
            throw new RelationNotFoundException();
        }
        Relation.setKey(id);
        relationDAO.save(Relation);
    }

}
