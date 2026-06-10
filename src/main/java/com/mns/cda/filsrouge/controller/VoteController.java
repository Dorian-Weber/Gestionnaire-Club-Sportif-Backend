package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.Iservice.IVoteService;
import com.mns.cda.filsrouge.dto.VoteEventDTO;
import com.mns.cda.filsrouge.dto.VoteSubmitDTO;
import com.mns.cda.filsrouge.model.Vote;
import com.mns.cda.filsrouge.security.AppUserDetails;
import com.mns.cda.filsrouge.security.isAdmin;
import com.mns.cda.filsrouge.security.isUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
            description = "Cette route permet de récupérer la liste de tous les votes dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des votes récupéré avec succès")
    })
    @isAdmin
    public List<Vote> getVoteList() {
        return voteService.findAll();
    }

    @GetMapping("/{userId}/{eventId}")
    @Operation(summary = "Récupérer un vote fait par un utilisateur a un événement.",
            description = "Cette route permet de récupérer les informations d'un vote en utilisant les ID d'un utilisateur et d'un événement.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vote récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Vote non trouvé")
    })
    @isAdmin
    public ResponseEntity<Vote> getVoteById(@PathVariable int userId,
                                                    @PathVariable int eventId) {

        Vote.VoteKey voteKey = new Vote.VoteKey(userId, eventId);
        Optional<Vote> optionalVote = voteService.findById(voteKey);

        if(optionalVote.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalVote.get(), HttpStatus.OK);
    }

    @GetMapping("/pending")
    @Operation(summary = "Récupère la liste des différents votes non émis par l'utilisateur",
            description = "Cette route permet de récupérer la liste de tous les votes pas encore fait par l'utilisateur dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des votes récupéré avec succès"),
            @ApiResponse(responseCode = "403", description = "Accès refusé, l'utilisateur n'est pas authentifié ou n'a pas les autorisations nécessaires")
    })
    @isUser
    public List<VoteEventDTO> getPendingVotes(@AuthenticationPrincipal AppUserDetails user) {
        return voteService.getPendingVotes(user.getUser().getIdAppUser());
    }

    @GetMapping("/completed")
    @Operation(summary = "Récupère la liste des différents votes émis par l'utilisateur",
            description = "Cette route permet de récupérer la liste de tous les votes déjà fait par l'utilisateur dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des votes récupéré avec succès"),
            @ApiResponse(responseCode = "403", description = "Accès refusé, l'utilisateur n'est pas authentifié ou n'a pas les autorisations nécessaires")
    })
    @isUser
    public List<VoteEventDTO> getCompletedVotes(@AuthenticationPrincipal AppUserDetails user) {
        return voteService.getCompletedVotes(user.getUser().getIdAppUser());
    }

    @PostMapping
    @Operation(summary = "Ajoute un vote à la base de données",
            description = "Cette route permet de d'ajouter un nouveau vote en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vote ajouté avec succès")
    })
    @isUser
    public ResponseEntity<VoteSubmitDTO> create(@AuthenticationPrincipal AppUserDetails userDetails,
                                                @RequestBody VoteSubmitDTO voteToInsert) {

        voteService.create(voteToInsert,userDetails.getUser().getIdAppUser());

        return new ResponseEntity<>(voteToInsert, HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}/{eventId}")
    @Operation(summary = "Supprime un vote par son ID",
            description = "Cette route permet de supprimer un vote spécifique en utilisant les ID de utilisateur et d'événement.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Vote supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Vote non trouvé")
    })
    @isUser
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
    @Operation(summary = "Modifie un vote par les ID de l'utilisateur et de l'événement",
            description = "Cette route permet de modifier les informations d'un vote spécifique en utilisant les ID de l'utilisateur et l'événement.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vote modifié avec succès"),
            @ApiResponse(responseCode = "404", description = "Vote non trouvé")
    })
    @isUser
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
