package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IAppUserService;
import com.mns.cda.filsrouge.Iservice.IRelationService;
import com.mns.cda.filsrouge.dao.RelationDAO;
import com.mns.cda.filsrouge.dto.AppUserLight;
import com.mns.cda.filsrouge.dto.FriendDTO;
import com.mns.cda.filsrouge.dto.RelationDTO;
import com.mns.cda.filsrouge.enumerate.RelationStatus;
import com.mns.cda.filsrouge.model.Relation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelationService implements IRelationService {

    protected final RelationDAO relationDAO;
    protected final AppUserService appUserService;

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

    //Get AppUser pour recherche d'ami
    @Override
    public Page<AppUserLight> searchUsers(int idUser, String query, Pageable pageable) {
        return relationDAO.searchUsers(idUser, "%" + query.toLowerCase() + "%", pageable);
    }

    //Post
    @Override
    public RelationDTO createFriendRequest(int firstId, int secondId) {

        Relation relation = new Relation();

        Relation.Key key = new Relation.Key(firstId, secondId);
        relation.setKey(key);

        relation.setFirstUser(appUserService.findById(firstId).orElseThrow());
        relation.setSecondUser(appUserService.findById(secondId).orElseThrow());
        relation.setRelationStatus(RelationStatus.PENDING);
        relationDAO.save(relation);
        return new RelationDTO(firstId,secondId, RelationStatus.PENDING);
    }



    //Delete
    @Override
    public void delete(Relation.Key id) {
        relationDAO.deleteById(id);
    }

    //Patch
    @Override
    public void updateRelationStatus(int firstId, int secondId, RelationStatus updateRelationStatus) throws RelationNotFoundException {
        Relation relationBetween = relationDAO.findRelationBetween(firstId, secondId).orElseThrow(RelationNotFoundException::new);

        relationBetween.setRelationStatus(updateRelationStatus);
        relationDAO.save(relationBetween);
    }

}
