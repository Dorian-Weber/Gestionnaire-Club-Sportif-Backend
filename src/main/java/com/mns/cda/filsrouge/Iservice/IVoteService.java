package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.dto.VoteEventDTO;
import com.mns.cda.filsrouge.model.Vote;

import java.util.List;
import java.util.Optional;

public interface IVoteService {

    public static class VoteNotFoundException extends Exception {}

    //GetAll
    List<Vote> findAll();

    //GetByID
    Optional<Vote> findById(Vote.VoteKey id);

    //Récupère la liste des votes pas encore émis par l'utilisateur
    public List<VoteEventDTO> getPendingVotes(Integer userId);

    //Récupère la liste des votes déjà émis par l'utilisateur
    public List<VoteEventDTO> getCompletedVotes(Integer userId);

    //Post
    void create(Vote Vote);

    //Delete
    void delete(Vote.VoteKey id);

    //Put
    void update(Vote.VoteKey id , Vote vote) throws VoteNotFoundException;

}
