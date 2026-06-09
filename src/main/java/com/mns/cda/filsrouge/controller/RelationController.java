package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.Iservice.IRelationService;
import com.mns.cda.filsrouge.dto.AppUserLight;
import com.mns.cda.filsrouge.dto.FriendDTO;
import com.mns.cda.filsrouge.dto.RelationDTO;
import com.mns.cda.filsrouge.dto.UpdateRelationStatus;
import com.mns.cda.filsrouge.model.Relation;
import com.mns.cda.filsrouge.security.AppUserDetails;
import com.mns.cda.filsrouge.security.isAdmin;
import com.mns.cda.filsrouge.security.isUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/relation")
@Tag(name = "Relation", description = "API de gestion des différentes relations")
@CrossOrigin
public class RelationController {


    protected final IRelationService relationService;

    @GetMapping("/user")
    @Operation(summary = "Récupérer la liste d'amis d'un utilisateur.",
            description = "Cette route permet de récupérer la liste d'amis d'un utilisateur.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relation récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Relation non trouvée"),
            @ApiResponse(responseCode = "403", description = "Accès interdit")
    })
    @isUser
    public List<FriendDTO> getFriends(@AuthenticationPrincipal AppUserDetails appUserDetails) {
        return relationService.getFriends(appUserDetails.getUser().getIdAppUser());
    }

    //Get liste des requêtes
    @GetMapping("/user/request-received")
    @Operation(summary = "Récupérer la liste des demande en attente d'un utilisateur.",
            description = "Cette route permet de récupérer la liste des demandes en attente d'un utilisateur.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relation récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Relation non trouvée"),
            @ApiResponse(responseCode = "403", description = "Accès interdit")
    })
    @isUser
    public List<FriendDTO> getPendingReceived(@AuthenticationPrincipal AppUserDetails appUserDetails) {
        return relationService.findRequestReceived(appUserDetails.getUser().getIdAppUser());
    }

    @GetMapping("/user/request-send")
    @Operation(summary = "Récupérer la liste des demandes envoyé en attente d'un utilisateur.",
            description = "Cette route permet de récupérer la liste des demandes envoyé en attente  d'un utilisateur.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relation récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Relation non trouvée"),
            @ApiResponse(responseCode = "403", description = "Accès interdit")
    })
    @isUser
    public List<FriendDTO> getPendingSend(@AuthenticationPrincipal AppUserDetails appUserDetails) {
        return relationService.findRequestSend(appUserDetails.getUser().getIdAppUser());
    }


    @GetMapping("/search")
    @Operation(summary = "Récupérer la liste des utilisateur qui ne sont actuellement pas en lien avec le principal.",
            description = "Cette route permet de récupérer la liste des utilisateurs dont la demande d'amitié est possible.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateurs récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Utilisateurs non trouvée"),
            @ApiResponse(responseCode = "403", description = "Accès interdit")
    })
    @isUser
    public Page<AppUserLight> searchUsers(
            @AuthenticationPrincipal AppUserDetails user,
            @RequestParam String query,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return relationService.searchUsers(
                user.getUser().getIdAppUser(),
                query,
                PageRequest.of(page, size)
        );
    }


    @PostMapping("/request")
    @Operation(summary = "Crée une relations entre des utilisateur.",
            description = "Cette route permet de crée une relation entre des utilisateurs dont la demande d'amitié est possible.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateurs récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Utilisateurs non trouvée"),
            @ApiResponse(responseCode = "403", description = "Accès interdit")
    })
    @isUser
    public ResponseEntity<RelationDTO> sendRequest(
            @AuthenticationPrincipal AppUserDetails user,
            @RequestBody Map<String, Integer> body) {

        int firstId = user.getUser().getIdAppUser();
        int secondId = body.get("secondId");
        System.out.println("firstId = " + firstId + ", secondId = " + secondId);

        RelationDTO relation = relationService.createFriendRequest(firstId, secondId);

        return new ResponseEntity<>(relation, HttpStatus.CREATED);
    }


    @DeleteMapping("/{secondId}")
    @Operation(summary = "Supprime une relation entre deux utilisateur par leurs ID",
            description = "Cette route permet de supprimer une relation spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Relation supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Relation non trouvée")
    })
    @isUser
    public ResponseEntity<Relation> delete(@AuthenticationPrincipal AppUserDetails appUserDetails,
                                           @PathVariable int secondId) {

        Optional<Relation> optionalRelation = relationService.findRelationBetween(
                appUserDetails.getUser().getIdAppUser(),
                secondId);

        if(optionalRelation.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        relationService.delete(optionalRelation.get().getKey());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/request/{secondId}")
    @Operation(summary = "Modifie le status  d'une relation ",
            description = "Cette route permet de modifier une relation spécifique entre un utilisateur connecter et l'id de l'autre utilisateur.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relation modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Relation non trouvée"),
            @ApiResponse(responseCode = "403", description = "Accès interdit")
    })
    @isUser
    public void updateRelationStatus(
            @AuthenticationPrincipal AppUserDetails appUserDetails,
            @PathVariable int secondId,
            @RequestBody UpdateRelationStatus newRelationStatus) throws IRelationService.RelationNotFoundException {

            relationService.updateRelationStatus(appUserDetails.getUser().getIdAppUser(), secondId, newRelationStatus.relationStatus());
    }

}
