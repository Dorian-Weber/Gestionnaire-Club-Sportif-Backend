package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.IVoteService;
import com.mns.cda.filsrouge.model.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MockVoteService implements IVoteService {

    @Override
    public List<Vote> findAll() {
        Vote.VoteKey MockVoteKey = new Vote.VoteKey();
        return List.of(new Vote(MockVoteKey,
                new AppUser(),
                new Event(),
                new Athlete()));
    }

    @Override
    public Optional<Vote> findById(Vote.VoteKey voteKey) {
        Vote.VoteKey MockVoteKey = new Vote.VoteKey(1,2);
        if (voteKey.equals(MockVoteKey) ) {
            return Optional.of(new Vote(MockVoteKey,
                    new AppUser(),
                    new Event(),
                    new Athlete()));
        }
        return Optional.empty();
    }

    @Override
    public void create(Vote Vote) {
        Vote.setVoteKey(null);
    }

    @Override
    public void delete(Vote.VoteKey voteKey) {

    }

    @Override
    public void update(Vote.VoteKey voteKey, Vote Vote) throws VoteNotFoundException {
        Vote.VoteKey MockVoteKey = new Vote.VoteKey(1,2);
        if (!Objects.equals(voteKey, MockVoteKey)) {
            throw new VoteNotFoundException();
        }
        Vote.setVoteKey(voteKey);

    }
}
