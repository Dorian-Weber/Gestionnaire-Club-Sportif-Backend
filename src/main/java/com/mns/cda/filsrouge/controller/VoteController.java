package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.Iservice.IVoteService;
import com.mns.cda.filsrouge.model.Vote;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vote")
@Tag(name = "Vote", description = "API de gestion des différents votes")
@CrossOrigin
public class VoteController {


    protected final IVoteService voteService;

    @GetMapping("/list")
    @Operation(summary = "Récupère la liste des différents votes",
            description = "Cette méthode permet de récupérer la liste de tous les votes dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des votes récupéré avec succès")
    })
    public List<Vote> getVoteList() {
        return voteService.findAll();
    }

    @GetMapping("/{userId}/{eventId}")
    @Operation(summary = "Récupérer un vote par son ID",
            description = "Cette méthode permet de récupérer les informations d'un vote spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vote récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Vote non trouvé")
    })
    public ResponseEntity<Vote> getVoteById(@PathVariable int userId,
                                                    @PathVariable int eventId) {

        Vote.VoteKey voteKey = new Vote.VoteKey(userId, eventId);
        Optional<Vote> optionalVote = voteService.findById(voteKey);

        if(optionalVote.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalVote.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Ajoute un vote à la base de données",
            description = "Cette méthode permet de d'ajouter un nouveau vote en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vote ajouté avec succès")
    })
    public ResponseEntity<Vote> create(@RequestBody Vote voteToInsert) {

        voteService.create(voteToInsert);

        return new ResponseEntity<>(voteToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{userId}/[{eventId}")
    @Operation(summary = "Supprime un vote par son ID",
            description = "Cette méthode permet de supprimer un vote spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Vote supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Vote non trouvé")
    })
    public ResponseEntity<Vote> delete(@PathVariable int userId,
                                           @PathVariable int eventId) {

        Vote.VoteKey voteKey = new Vote.VoteKey(userId, eventId);
        Optional<Vote> optionalVote = voteService.findById(voteKey);

        if(optionalVote.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        voteService.delete(voteKey);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{userId}/{eventId}")
    @Operation(summary = "Modifie un vote par son ID",
            description = "Cette méthode permet de modifier les informations d'un vote spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vote modifié avec succès"),
            @ApiResponse(responseCode = "404", description = "Vote non trouvé")
    })
    public ResponseEntity<Vote> update(
            @PathVariable int userId,
            @PathVariable int eventId,
            @RequestBody Vote voteToUpdate) {
        Vote.VoteKey voteKey = new Vote.VoteKey(userId, eventId);
        try {
            voteService.update(voteKey, voteToUpdate);
            return new ResponseEntity<>(voteToUpdate, HttpStatus.OK);
        } catch (IVoteService.VoteNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
