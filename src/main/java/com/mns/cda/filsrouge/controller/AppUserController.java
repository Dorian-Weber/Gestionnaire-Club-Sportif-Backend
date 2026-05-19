package com.mns.cda.filsrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.Iservice.IAppUserService;
import com.mns.cda.filsrouge.model.AppUser;
import com.mns.cda.filsrouge.security.isAdmin;
import com.mns.cda.filsrouge.view.AppUserView;
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
@RequestMapping("/appUser")
@Tag(name = "Utilisateur", description = "API de gestion des différents utilisateur")
@CrossOrigin
public class AppUserController {

    public class OnCreate {}

    protected final IAppUserService appUserService;

    @GetMapping("/list")
    @JsonView(AppUserView.class)
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
    @JsonView(AppUserView.class)
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

    @PostMapping
    @Operation(summary = "Ajoute un utilisateur à la base de données",
            description = "Cette route permet de d'ajouter un nouvel utilisateur en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Utilisateur ajouté avec succès")
    })
    @isAdmin
    public ResponseEntity<AppUser> create(@RequestBody AppUser appUserToInsert) {

        appUserService.create(appUserToInsert);

        return new ResponseEntity<>(appUserToInsert, HttpStatus.CREATED);

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
