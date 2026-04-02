package com.mns.cda.filsrouge.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idAppUser;

    @NotBlank
    @Size(min = 1, max = 50)
    protected String AppUserName;

    @NotBlank
    @Size(min = 1, max = 50)
    protected String AppUserFirstName;

    @NotBlank
    @Size(min = 5, max = 30)
    @Column(unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Le pseudo ne doit contenir que lettres, chiffres ou _")
    protected String AppUserPseudo;

    @NotBlank
    @Email
    @Size(min = 5, max = 100)
    @Column(unique = true)
    protected String AppUserEmail;

    @NotBlank
    @Size(min = 8, max = 100)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
             message = "Le mot de passe doit contenir au moins 8 caractères, une majuscule, une minuscule, un chiffre et un caractère spécial")
    protected String AppUserPassword;

    @NotBlank
    @Pattern(regexp = "^\\+?[0-9]{10,15}$",
            message = "Le numéro de téléphone doit être composé de 10 à 15 chiffres et peut commencer par +")
    protected String AppUserPhone;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdDate;

    @LastModifiedDate
    protected LocalDateTime lastModifiedDate;


}
