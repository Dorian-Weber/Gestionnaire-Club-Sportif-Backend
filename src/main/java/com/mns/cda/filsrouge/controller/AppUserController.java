package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.dao.AppUserDAO;
import com.mns.cda.filsrouge.model.AppUser;
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


    protected final AppUserDAO appUserDAO;

    @GetMapping("/list")
    @Operation(summary = "Récupère la liste des différents utilisateurs",
            description = "Cette méthode permet de récupérer la liste de tous les utilisateurs présents dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des utilisateurs récupérée avec succès")
    })
    public List<AppUser> getAppUserList() {
        return appUserDAO.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un utilisateur par son ID",
            description = "Cette méthode permet de récupérer les informations d'un utilisateur spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateur récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé")
    })
    public ResponseEntity<AppUser> getAppUserById(@PathVariable int id) {

        Optional<AppUser> optionalAppUser = appUserDAO.findById(id);

        if(optionalAppUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalAppUser.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Ajoute un utilisateur à la base de données",
            description = "Cette méthode permet de d'ajouter un nouveau utilisateur en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Utilisateur ajoutée avec succès")
    })
    public ResponseEntity<AppUser> create(@RequestBody AppUser appUserToInsert) {

        appUserToInsert.setIdAppUser(null);
        appUserDAO.save(appUserToInsert);

        return new ResponseEntity<>(appUserToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un utilisateur par son ID",
            description = "Cette méthode permet de supprimer un utilisateur spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Utilisateur supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé")
    })
    public ResponseEntity<AppUser> delete(@PathVariable int id) {

        Optional<AppUser> optionalAppUser = appUserDAO.findById(id);

        if(optionalAppUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        appUserDAO.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie un utilisateur par son ID",
            description = "Cette méthode permet de modifier les informations d'un utilisateur spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateur modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé")
    })
    public ResponseEntity<AppUser> update(
            @PathVariable int id,
            @RequestBody AppUser appUserToUpdate) {

        Optional<AppUser> optionalAppUser = appUserDAO.findById(id);

        if(optionalAppUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        appUserToUpdate.setIdAppUser(id);
        appUserDAO.save(appUserToUpdate);

        return new ResponseEntity<>(appUserToUpdate,HttpStatus.OK);
    }

}
