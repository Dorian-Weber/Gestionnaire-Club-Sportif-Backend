package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.IRelationService;
import com.mns.cda.filsrouge.dto.AppUserLight;
import com.mns.cda.filsrouge.dto.FriendDTO;
import com.mns.cda.filsrouge.dto.RelationDTO;
import com.mns.cda.filsrouge.enumerate.RelationStatus;
import com.mns.cda.filsrouge.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MockRelationService implements IRelationService {

    @Override
    public List<Relation> findAll() {
        Relation.Key MockKey = new Relation.Key();
        return List.of(new Relation(MockKey,
                new AppUser(),
                new AppUser(),
                RelationStatus.PENDING));
    }

    //TODO
    @Override
    public List<FriendDTO> getFriends(int idUser) {
        return List.of();
    }

    @Override
    public Optional<Relation> findById(Relation.Key key) {
        Relation.Key MockKey = new Relation.Key(1,2);
        if (key.equals(MockKey) ) {
            return Optional.of(new Relation(MockKey,
                    new AppUser(),
                    new AppUser(),
                    RelationStatus.PENDING));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Relation> findRelationBetween(int id1, int id2) {
        if ((id1 == 1 && id2 == 2) || (id1 == 2 && id2 == 1)) {
            return Optional.of(new Relation(new Relation.Key(id1, id2),
                    new AppUser(),
                    new AppUser(),
                    RelationStatus.PENDING));
        }
        return Optional.empty();
    }

    //TODO
    @Override
    public List<FriendDTO> findRequestReceived(int idUser) {
        return List.of();
    }

    //TODO
    @Override
    public List<FriendDTO> findRequestSend(int idUser) {
        return List.of();
    }

    //TODO
    @Override
    public Page<AppUserLight> searchUsers(int idUser, String query, Pageable pageable) {
        return null;
    }

    //TODO
    @Override
    public RelationDTO createFriendRequest(int firstId, int secondId) {
        return null;
    }

    @Override
    public void delete(Relation.Key key) {

    }

    //TODO
    @Override
    public void updateRelationStatus(int firstId, int secondId, RelationStatus relationStatus) throws RelationNotFoundException {

    }

}
