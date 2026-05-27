package com.mns.cda.filsrouge.controller;

import com.mns.cda.filsrouge.Iservice.IAppUserService;
import com.mns.cda.filsrouge.model.AppUser;
import com.mns.cda.filsrouge.security.AppUserDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final IAppUserService appUserService;
    private final AuthenticationProvider authenticationProvider;

    @PostMapping("/sign-in")
    @Operation(summary = "Permet de d'enregistrer un utilisateur en base de données",
            description = "Cette route permet à l'utilisateur de crée un compte utilisateur.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Utilisateur enregistré avec succès")
    })
    public ResponseEntity<AppUser> SignIn(
            @RequestBody @Validated(AppUser.OnCreate.class) AppUser userToInsert) {

        appUserService.create(userToInsert);

        return new ResponseEntity<>(userToInsert, HttpStatus.CREATED);
    }


    @PostMapping("/log-in")
    @Operation(summary = "Permet aux Utilisateur de se connecter",
            description = "Cette route permet à l'utilisateur de se connecter.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateur connecté avec succès"),
            @ApiResponse(responseCode = "403", description = "Connexion non autorisé")
    })
    public ResponseEntity<String> logIn(
            @RequestBody  AppUser user) {
        try {
          AppUserDetails appUser =  (AppUserDetails) authenticationProvider
                  .authenticate(new UsernamePasswordAuthenticationToken(
                    user.getAppUserEmail(),
                    user.getAppUserPassword())
                  ).getPrincipal();

            String jwt = Jwts.builder()
                    .setSubject(user.getAppUserEmail())
                    .addClaims(Map.of("role",appUser.getUser().getAccountType().getAccountTypeName()))
                    .signWith(SignatureAlgorithm.HS256, "azerty")
                    .compact();

            return new ResponseEntity<>(jwt, HttpStatus.OK);

        } catch (AuthenticationException e) {

            return new ResponseEntity<>( HttpStatus.UNAUTHORIZED);
        }
    }

}
