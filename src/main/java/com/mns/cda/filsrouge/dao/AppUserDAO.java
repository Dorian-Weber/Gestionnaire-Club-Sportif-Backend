package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.AccountType;
import com.mns.cda.filsrouge.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserDAO extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findByAppUserEmail(String email);

    boolean existsByAppUserPseudo(String appUserPseudo);

}
