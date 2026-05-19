package com.mns.cda.filsrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.model.AppUser;
import com.mns.cda.filsrouge.security.AppUserDetails;
import com.mns.cda.filsrouge.security.isUser;
import com.mns.cda.filsrouge.service.AppUserService;
import com.mns.cda.filsrouge.view.AppUserView;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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

    private final AppUserService appUserService;
    private final AuthenticationProvider authenticationProvider;

    @PostMapping("/sign-in")
    @JsonView({AppUserView.class})
    public ResponseEntity<AppUser> SignIn(
            @RequestBody @Validated(AppUser.OnCreate.class) AppUser userToInsert) {

        appUserService.create(userToInsert);

        return new ResponseEntity<>(userToInsert, HttpStatus.CREATED);
    }


    @PostMapping("/log-in")
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
