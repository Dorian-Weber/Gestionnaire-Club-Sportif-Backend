package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.Iservice.IAppUserService;
import com.mns.cda.filsrouge.aggregation.UserPublicAggregation;
import com.mns.cda.filsrouge.dto.UpdatePseudo;
import com.mns.cda.filsrouge.dto.UpdateVisibility;
import com.mns.cda.filsrouge.dto.UserInfoDTO;
import com.mns.cda.filsrouge.dto.UserPublicProfil;
import com.mns.cda.filsrouge.model.AppUser;
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
@RequestMapping("/appUser")
@Tag(name = "Utilisateur", description = "API de gestion des différents utilisateur")
@CrossOrigin
public class AppUserController {

    public class OnCreate {}

    protected final UserPublicAggregation userPublicAggregation;
    protected final IAppUserService appUserService;

    @GetMapping("/list")
    @Operation(summary = "Récupère la liste des différents utilisateurs",
            description = "Cette route permet de récupérer la liste de tous les utilisateurs présents dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des utilisateurs récupérée avec succès")
    })
    @isAdmin
    public List<AppUser> getAppUserList() {
        return appUserService.findAll();
    }


    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un utilisateur par son ID",
            description = "Cette route permet de récupérer les informations d'un utilisateur spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateur récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé")
    })
    @isAdmin
    public ResponseEntity<AppUser> getAppUserById(@PathVariable int id) {

        Optional<AppUser> optionalAppUser = appUserService.findById(id);

        if(optionalAppUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalAppUser.get(), HttpStatus.OK);
    }

    @GetMapping("/info")
    @Operation(summary = "Récupérer les informations d'utilisateur par son ID",
            description = "Cette route permet de récupérer les informations d'un utilisateur spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateur récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé"),
            @ApiResponse(responseCode = "403", description = "Accès refusé, l'utilisateur n'est pas autorisé à effectuer cette action")
    })
    @isUser
    public ResponseEntity<UserInfoDTO> getAppUserInfoById(
            @AuthenticationPrincipal AppUserDetails userDetails) {


        return new ResponseEntity<>(appUserService.getMyInfo(userDetails.getUser().getIdAppUser()), HttpStatus.OK);
    }

    @GetMapping("/public")
    @Operation(summary = "Récupère les infos du profil qui sont public",
            description = "Cette route permet de récupérer les informations public de l'utilisateur.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informations du profil public récupérées avec succès"),
            @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé"),
            @ApiResponse(responseCode = "403", description = "Accès refusé, l'utilisateur n'est pas autorisé à effectuer cette action")
    })
    @isUser
    public UserPublicProfil getMyPublicProfile(
            @AuthenticationPrincipal AppUserDetails userDetails) {
        return userPublicAggregation.getMyPublicProfile(userDetails.getUser().getIdAppUser());
    }

    @GetMapping("/public/{idUser}")
    @isUser
    public UserPublicProfil getPublicProfileOfUser(
            @PathVariable Integer idUser,
            @AuthenticationPrincipal AppUserDetails userDetails) {

        Integer visitorId = userDetails.getUser().getIdAppUser();
        return userPublicAggregation.getPublicProfileOfUser(idUser, visitorId);
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un utilisateur par son ID",
            description = "Cette route permet de supprimer un utilisateur spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Utilisateur supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé")
    })
    @isAdmin
    public ResponseEntity<AppUser> delete(@PathVariable int id) {

        Optional<AppUser> optionalAppUser = appUserService.findById(id);

        if(optionalAppUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        appUserService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/info")
    @Operation(summary = "Changement de visibilité",
            description = "Permet la modification de la visibilité de l'utilisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Visibilité modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé"),
            @ApiResponse(responseCode = "403", description = "Accès refusé, l'utilisateur n'est pas autorisé à effectuer cette action")
    })
    @isUser
    public void updateVisibility(@RequestBody UpdateVisibility newVisibility,
                                 @AuthenticationPrincipal AppUserDetails userDetails) {
        appUserService.updateVisibility(newVisibility.visibility(), userDetails.getUser().getIdAppUser());
    }

    @PatchMapping("/pseudo")
    @Operation(summary = "Changement de pseudo",
            description = "Permet la modification du pseudo de l'utilisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pseudo modifié avec succès"),
            @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé"),
            @ApiResponse(responseCode = "403", description = "Accès refusé, l'utilisateur n'est pas autorisé à effectuer cette action")
    })
    @isUser
    public void updatePseudo(@RequestBody UpdatePseudo pseudo,
                             @AuthenticationPrincipal AppUserDetails userDetails) {
        appUserService.updatePseudo(pseudo.appUserPseudo(), userDetails.getUser().getIdAppUser());
    }



    @PutMapping("/{id}")
    @Operation(summary = "Modifie un utilisateur par son ID",
            description = "Cette route permet de modifier les informations d'un utilisateur spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateur modifié avec succès"),
            @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé")
    })
    @isAdmin
    public ResponseEntity<AppUser> update(
            @PathVariable int id,
            @RequestBody AppUser appUserToUpdate) {

        try {
            appUserService.update(id, appUserToUpdate);
            return new ResponseEntity<>(appUserToUpdate, HttpStatus.OK);
        } catch (IAppUserService.UserNotFoundException e) {
            return new ResponseEntity<>(appUserToUpdate, HttpStatus.NOT_FOUND);
        }

    }
}
