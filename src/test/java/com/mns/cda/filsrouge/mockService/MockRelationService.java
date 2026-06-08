package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.IRelationService;
import com.mns.cda.filsrouge.dto.FriendDTO;
import com.mns.cda.filsrouge.enumerate.RelationStatus;
import com.mns.cda.filsrouge.model.*;

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

    //TODO
    @Override
    public Optional<Relation> findRelationBetween(int id1, int id2) {
        return Optional.empty();
    }

    @Override
    public void create(Relation Relation) {
        Relation.setKey(null);
    }

    @Override
    public void delete(Relation.Key key) {

    }

    @Override
    public void update(Relation.Key key, Relation Relation) throws RelationNotFoundException {
        Relation.Key MockKey = new Relation.Key(1,2);
        if (!Objects.equals(key, MockKey)) {
            throw new RelationNotFoundException();
        }
        Relation.setKey(key);

    }
}
