package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.VoteController;
import com.mns.cda.filsrouge.mockService.MockVoteService;
import com.mns.cda.filsrouge.model.Vote;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class VoteControllerUnitTest {

    // GET ALL
    @Test
    public void getVoteList_MustReturnList() {
        VoteController controller = new VoteController(new MockVoteService());

        List<Vote> response = controller.getVoteList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
    }

    // GET BY ID
    @Test
    public void getVoteByIdExist_MustReturnCode200() {
        VoteController controller = new VoteController(new MockVoteService());

        ResponseEntity<Vote> response = controller.getVoteById(10, 100);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void getVoteByIdNotExist_MustReturnCode404() {
        VoteController controller = new VoteController(new MockVoteService());

        ResponseEntity<Vote> response = controller.getVoteById(99, 999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // CREATE
    @Test
    public void createVote_MustReturnCode201() {
        VoteController controller = new VoteController(new MockVoteService());

        Vote vote = new Vote();
        vote.setVoteKey(new Vote.VoteKey(20, 200));

        ResponseEntity<Vote> response = controller.create(vote);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    // DELETE
    @Test
    public void deleteVoteExist_MustReturnCode204() {
        VoteController controller = new VoteController(new MockVoteService());

        ResponseEntity<Vote> response = controller.delete(10, 100);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void deleteVoteNotExist_MustReturnCode404() {
        VoteController controller = new VoteController(new MockVoteService());

        ResponseEntity<Vote> response = controller.delete(99, 999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // UPDATE
    @Test
    public void updateVoteExist_MustReturnCode200() {
        VoteController controller = new VoteController(new MockVoteService());

        Vote vote = new Vote();
        vote.setVoteKey(new Vote.VoteKey(10, 100));

        ResponseEntity<Vote> response = controller.update(10, 100, vote);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void updateVoteNotExist_MustReturnCode404() {
        VoteController controller = new VoteController(new MockVoteService());

        Vote vote = new Vote();
        vote.setVoteKey(new Vote.VoteKey(99, 999));

        ResponseEntity<Vote> response = controller.update(99, 999, vote);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
