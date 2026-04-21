package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.model.Vote;

import java.util.List;
import java.util.Optional;

public interface IVoteService {

    public static class VoteNotFoundException extends Exception {}

    //GetAll
    List<Vote> findAll();

    //GetByID
    Optional<Vote> findById(Vote.VoteKey id);

    //Post
    void create(Vote Vote);

    //Delete
    void delete(Vote.VoteKey id);

    //Put
    void update(Vote.VoteKey id , Vote vote) throws VoteNotFoundException;

}
