package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonView;
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

    public interface OnUpdate {};
    public interface OnCreate {};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(AppUserView.class)
    protected Integer idAppUser;

    @NotBlank
    @Size(min = 1, max = 50)
    @JsonView({AppUserView.class,
            EventView.class,
            ReservationView.class,
            SeatView.class})
    protected String AppUserName;

    @NotBlank
    @Size(min = 1, max = 50)
    @JsonView({AppUserView.class,
            EventView.class,
            ReservationView.class,
            SeatView.class})
    protected String AppUserFirstName;

    @NotBlank
    @Size(min = 5, max = 30)
    @Column(unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Le pseudo ne doit contenir que lettres, chiffres ou _")
    @JsonView({AppUserView.class,
            EventView.class,
            ReservationView.class,
            SeatView.class})
    protected String AppUserPseudo;

    @NotBlank( message = "L'email ne peut pas être vide")
    @Email( message = "L'email est incorrect")
    @Size(max = 100, message = "L'email ne doit pas dépasser 100 caractères")
    @Column(unique = true, nullable = false)
    @JsonView(AppUserView.class)
    protected String AppUserEmail;

    @NotBlank(message = "Le mot de passe ne peut pas être vide")
    @Size(min = 8, max = 50, message = "Le mot de passe doit contenir entre 8 et 50 caractères")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
             message = "Le mot de passe doit contenir au moins 8 caractères, une majuscule, une minuscule, un chiffre et un caractère spécial")
    @Column(nullable = false)
    protected String AppUserPassword;

    @NotBlank(message = "Le numéro de téléphone ne peut pas être vide")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$",
            message = "Le numéro de téléphone doit être composé de 10 à 15 chiffres et peut commencer par +")
    @Column(nullable = false)
    @JsonView(AppUserView.class)
    protected String AppUserPhone;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdDate;

    @LastModifiedDate
    protected LocalDateTime lastModifiedDate;


    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, name = "account_type_id")
    @JsonView(AppUserView.class)
    protected AccountType AccountType;


    @OneToMany(mappedBy = "firstUser")
    protected List<Relation> relationsUser;
    @OneToMany(mappedBy = "secondUser")
    protected List<Relation> relationsSecondUser;


    @OneToMany(mappedBy = "user")
    protected List<Vote> votes;

    @OneToMany(mappedBy = "user")
    @JsonView(AppUserView.class)
    protected List<Reservation> reservations;
}
