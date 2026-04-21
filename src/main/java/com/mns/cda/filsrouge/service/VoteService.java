package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IVoteService;
import com.mns.cda.filsrouge.dao.VoteDAO;
import com.mns.cda.filsrouge.model.Vote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoteService implements IVoteService {

    protected final VoteDAO VoteDAO;

    //GetAll
    @Override
    public List<Vote> findAll() { return VoteDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Vote> findById(Vote.VoteKey id) {
        return VoteDAO.findById(id);
    }

    //Post
    @Override
    public void create(Vote Vote) {
        Vote.setVoteKey(null);
        VoteDAO.save(Vote);
    }

    //Delete
    @Override
    public void delete(Vote.VoteKey id) {
        VoteDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(Vote.VoteKey id, Vote Vote) throws VoteNotFoundException {
        Optional<Vote> VoteOptional = VoteDAO.findById(id);

        if(VoteOptional.isEmpty()) {
            throw new VoteNotFoundException();
        }
        Vote.setVoteKey(id);
        VoteDAO.save(Vote);
    }

}
