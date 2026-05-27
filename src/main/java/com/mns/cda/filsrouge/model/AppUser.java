package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.enumerate.UserVisibility;
import com.mns.cda.filsrouge.view.AppUserView;
import com.mns.cda.filsrouge.view.EventView;
import com.mns.cda.filsrouge.view.ReservationView;
import com.mns.cda.filsrouge.view.SeatView;
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
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class AppUser {

    public AppUser(Integer userId) {
        this.idAppUser = userId;
    }

    public interface OnUpdate {};
    public interface OnCreate {};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idAppUser;

    @NotBlank(groups = {OnCreate.class})
    @Size(min = 1, max = 50, groups = {OnCreate.class})
    protected String appUserName;

    @NotBlank(groups = {OnCreate.class})
    @Size(min = 1, max = 50, groups = {OnCreate.class})
    protected String appUserFirstName;

    @NotBlank(groups = {OnCreate.class})
    @Size(min = 5, max = 30, groups = {OnCreate.class})
    @Column(unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Le pseudo ne doit contenir que lettres, chiffres ou _", groups = {OnCreate.class})
    protected String appUserPseudo;

    @NotBlank( message = "L'email ne peut pas être vide", groups = {OnCreate.class})
    @Email( message = "L'email est incorrect", groups = {OnCreate.class})
    @Size(max = 100, message = "L'email ne doit pas dépasser 100 caractères", groups = {OnCreate.class})
    @Column(unique = true, nullable = false)
    protected String appUserEmail;

    @NotBlank(message = "Le mot de passe ne peut pas être vide",groups = {OnCreate.class})
    // @Size(min = 8, max = 50, message = "Le mot de passe doit contenir entre 8 et 50 caractères", groups = {OnCreate.class})
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
             message = "Le mot de passe doit contenir au moins 8 caractères, une majuscule, une minuscule, un chiffre et un caractère spécial", groups = {OnCreate.class})
    @Column(nullable = false)
    protected String appUserPassword;

    @NotBlank(message = "Le numéro de téléphone ne peut pas être vide",groups = {OnCreate.class})
    @Pattern(regexp = "^\\+?[0-9]{10,15}$",
            message = "Le numéro de téléphone doit être composé de 10 à 15 chiffres et peut commencer par +", groups = {OnCreate.class})
    @Column(nullable = false)
    protected String appUserPhone;

    @NotNull
    @Enumerated(EnumType.STRING)
    protected UserVisibility appUserVisibility;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdDate;

    @LastModifiedDate
    protected LocalDateTime lastModifiedDate;


    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, name = "account_type_id")
    @NotNull
    protected AccountType accountType;


    @OneToMany(mappedBy = "firstUser")
    protected List<Relation> relationsUser;

    @OneToMany(mappedBy = "secondUser")
    protected List<Relation> relationsSecondUser;


    @OneToMany(mappedBy = "user")
    protected List<Vote> votes;

    @OneToMany(mappedBy = "user")
    protected List<Reservation> reservations;
}
