package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.Iservice.IAccountTypeService;
import com.mns.cda.filsrouge.model.AccountType;
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
@RequestMapping("/account-type")
@Tag(name = "Type de compte", description = "API de gestion des différents types de compte")
@CrossOrigin
public class AccountTypeController {

    private final IAccountTypeService accountTypeService;

    @GetMapping("/list")
    @Operation(summary = "Récupère la liste des différents types de comptes",
            description = "Cette méthode permet de récupérer la liste de tous les types de comptes présents dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des types de comptes récupérée avec succès")
    })
    public List<AccountType> getAccountTypeList() {
        return accountTypeService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un type de compte par son ID",
            description = "Cette méthode permet de récupérer les informations d'un type de compte spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Type de compte récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Type de compte non trouvé")
    })
    public ResponseEntity<AccountType> getAccountTypeById(@PathVariable int id) {

        Optional<AccountType> optionalAccountType = accountTypeService.findById(id);
        if(optionalAccountType.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalAccountType.get(), HttpStatus.OK);
    }


    @PostMapping
    @Operation(summary = "Ajoute un type de compte à la base de données",
            description = "Cette méthode permet de d'ajouter un nouveau type de compte en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Type de compte ajoutée avec succès")
    })
    public ResponseEntity<AccountType> create(@RequestBody AccountType accountTypeToInsert) {

        accountTypeService.create(accountTypeToInsert);

        return new ResponseEntity<>(accountTypeToInsert, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un type de compte par son ID",
            description = "Cette méthode permet de supprimer un type de compte spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Type de compte supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Type de compte non trouvé")
    })
    public ResponseEntity<AccountType> delete(@PathVariable int id) {

        Optional<AccountType> optionalAccountType = accountTypeService.findById(id);

        if(optionalAccountType.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accountTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie un type de compte par son ID",
            description = "Cette méthode permet de modifier les informations d'un type de compte spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Type de compte modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Type de compte non trouvé")
    })
    public ResponseEntity<AccountType> update(
            @PathVariable int id,
            @RequestBody AccountType accountTypeToUpdate) {

        try {
            accountTypeService.update(id, accountTypeToUpdate);
            return new ResponseEntity<>(accountTypeToUpdate, HttpStatus.OK);
        }catch(IAccountTypeService.AccountTypeNotFoundException e) {
            return new ResponseEntity<>(accountTypeToUpdate, HttpStatus.NOT_FOUND);
        }
    }

}
