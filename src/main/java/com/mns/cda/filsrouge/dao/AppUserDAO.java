package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.dto.UserInfoDTO;
import com.mns.cda.filsrouge.model.AccountType;
import com.mns.cda.filsrouge.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserDAO extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findByAppUserEmail(String email);

    boolean existsByAppUserPseudo(String appUserPseudo);

    @Query("SELECT new com.mns.cda.filsrouge.dto.UserInfoDTO( " +
            "u.appUserName , " +
            "u.appUserFirstName, " +
            "u.appUserEmail , " +
            "u.appUserPhone , " +
            "u.appUserVisibility ) " +
            "FROM AppUser u " +
            "WHERE u.idAppUser = :idUser " )
    UserInfoDTO getUserInfo(@Param("idUser") int idUser);



}
