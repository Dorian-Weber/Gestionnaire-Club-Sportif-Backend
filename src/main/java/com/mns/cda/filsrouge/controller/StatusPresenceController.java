package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.Iservice.ISportService;
import com.mns.cda.filsrouge.Iservice.IStatusPresenceService;
import com.mns.cda.filsrouge.model.StatusPresence;
import com.mns.cda.filsrouge.security.isAdmin;
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
@RequestMapping("/status-presence")
@Tag(name = "Status de présence", description = "API de gestion des différents status de présence")
@CrossOrigin
public class StatusPresenceController {


    protected final IStatusPresenceService statusPresenceService;

    @GetMapping("/list")
    @Operation(summary = "Récupère la liste des différents status de présence",
            description = "Cette route permet de récupérer la liste de tous les status de présence dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des status de présence récupérée avec succès")
    })
    @isAdmin
    public List<StatusPresence> getStatusPresenceList() {
        return statusPresenceService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un status de présence par son ID",
            description = "Cette route permet de récupérer les informations d'un status de présence spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Status de présence récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Status de présence non trouvé")
    })
    @isAdmin
    public ResponseEntity<StatusPresence> getStatusPresenceById(@PathVariable int id) {

        Optional<StatusPresence> optionalStatusPresence = statusPresenceService.findById(id);

        if(optionalStatusPresence.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalStatusPresence.get(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Ajoute un status de présence à la base de données",
            description = "Cette route permet d'ajouter un nouveau status de présence en base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Status de présence ajouté avec succès")
    })
    @isAdmin
    public ResponseEntity<StatusPresence> create(@RequestBody StatusPresence statusPresenceToInsert) {

        statusPresenceService.create(statusPresenceToInsert);

        return new ResponseEntity<>(statusPresenceToInsert, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un status de présence par son ID",
            description = "Cette route permet de supprimer un status de présence spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Status de présence supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Status de présence non trouvé")
    })
    @isAdmin
    public ResponseEntity<StatusPresence> delete(@PathVariable int id) {

        Optional<StatusPresence> optionalStatusPresence = statusPresenceService.findById(id);

        if(optionalStatusPresence.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        statusPresenceService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifie un status de présence par son ID",
            description = "Cette route permet de modifier les informations d'un status de présence spécifique en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Status de présence modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Status de présence non trouvé")
    })
    @isAdmin
    public ResponseEntity<StatusPresence> update(
            @PathVariable int id,
            @RequestBody StatusPresence statusPresenceToUpdate) {

        try {
            statusPresenceService.update(id, statusPresenceToUpdate);
            return new ResponseEntity<>(statusPresenceToUpdate, HttpStatus.OK);
        } catch (IStatusPresenceService.StatusPresenceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
