package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.VoteController;
import com.mns.cda.filsrouge.mockService.MockVoteService;
import com.mns.cda.filsrouge.model.AppUser;
import com.mns.cda.filsrouge.model.Athlete;
import com.mns.cda.filsrouge.model.Event;
import com.mns.cda.filsrouge.model.Vote;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class VoteControllerUnitTest {

    //Test de GetAll
    @Test
    public void getVoteAll_MustReturnList() {
        VoteController voteController = new VoteController(new MockVoteService());

        List<Vote> response = voteController.getVoteList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getVoteByIdExist_MustReturnCode200() {

        VoteController voteController = new VoteController(new MockVoteService());
        ResponseEntity<Vote> response = voteController.getVoteById(1,2);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getVoteByIdNotExist_MustReturnCode404() {

        VoteController voteController = new VoteController(new MockVoteService());
        ResponseEntity<Vote> response = voteController.getVoteById(2,1);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createVote_MustReturnCode201() {
        VoteController voteController = new VoteController(new MockVoteService());
        Vote vote = new Vote(new Vote.VoteKey(1,2),
                new AppUser(),
                new Event(),
                new Athlete());

        ResponseEntity<Vote> response = voteController.create(vote);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getVoteKey());
    }

    // Test de Delete
    @Test
    public void deleteVoteExist_MustReturnCode204() {
        VoteController voteController = new VoteController(new MockVoteService());

        ResponseEntity<Vote> response = voteController.delete(1,2);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteVoteNotExist_MustReturnCode404() {
        VoteController voteController = new VoteController(new MockVoteService());

        ResponseEntity<Vote> response = voteController.delete(2,1);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Update

    @Test
    public void updateVote_MustReturnCode200() {
        VoteController voteController = new VoteController(new MockVoteService());
        Vote vote = new Vote(new Vote.VoteKey(1,2),
                new AppUser(),
                new Event(),
                new Athlete());

        ResponseEntity<Vote> response = voteController.update(1,2, vote);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(new Vote.VoteKey(1,2), response.getBody().getVoteKey());
    }

    @Test
    public void updateVoteNotExist_MustReturnCode404() {
        VoteController voteController = new VoteController(new MockVoteService());
        Vote vote = new Vote(new Vote.VoteKey(1,2),
                new AppUser(),
                new Event(),
                new Athlete());

        ResponseEntity<Vote> reponse = voteController.update(2,1, vote);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
