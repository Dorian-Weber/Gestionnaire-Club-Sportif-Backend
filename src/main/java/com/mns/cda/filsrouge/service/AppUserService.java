package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IAppUserService;
import com.mns.cda.filsrouge.dao.AccountTypeDAO;
import com.mns.cda.filsrouge.dao.AppUserDAO;
import com.mns.cda.filsrouge.dto.AppUserLight;
import com.mns.cda.filsrouge.dto.UserInfoDTO;
import com.mns.cda.filsrouge.enumerate.UserVisibility;
import com.mns.cda.filsrouge.model.AccountType;
import com.mns.cda.filsrouge.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppUserService implements IAppUserService{

    protected final AppUserDAO appUserDAO;
    private final PasswordEncoder encoder;
    protected final AccountTypeDAO accountTypeDAO;

    //GetAll
    @Override
    public List<AppUser> findAll() { return appUserDAO.findAll(); }

    //GetByID
    @Override
    public Optional<AppUser> findById(int id) {
        return appUserDAO.findById(id);
    }
    //GetUserInfo
    @Override
    public UserInfoDTO getMyInfo(int idUser) {
        return appUserDAO.getUserInfo(idUser);
    }

    //Post
    @Override
    public void create(AppUser appUser) {
        //On affecte le type de compte à utilisateur par défaut
        AccountType user = accountTypeDAO.findById(3)
                .orElseThrow(() -> new RuntimeException("Type de compte introuvable"));

        // Si aucun pseudo n'a été donnée, on en génère un à partir du prénom et du nom de l'utilisateur
        if (appUser.getAppUserPseudo() == null || appUser.getAppUserPseudo().isBlank()) {
            String base = (appUser.getAppUserFirstName() + "." + appUser.getAppUserName()).toLowerCase();
            base = base.replaceAll("[^a-z0-9_]", "_");

            String pseudo = base;
            int counter = 1;

            // Vérifier unicité du pseudo crée et on incrémente si besoin
            while (appUserDAO.existsByAppUserPseudo(pseudo)) {
                pseudo = base + counter;
                counter++;
            }

            appUser.setAppUserPseudo(pseudo);
        }

        appUser.setIdAppUser(null);
        appUser.setAppUserVisibility(UserVisibility.PRIVATE);
        appUser.setAccountType(user);
        appUser.setAppUserPassword(encoder.encode(appUser.getAppUserPassword()));
        appUserDAO.save(appUser);
    }

    //Delete
    @Override
    public void delete(int id) {
        appUserDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(int id, AppUser appUser) throws UserNotFoundException {
        Optional<AppUser> appUserOptional = appUserDAO.findById(id);

        if(appUserOptional.isEmpty()) {
            throw new UserNotFoundException();
        }
        appUser.setIdAppUser(id);
        appUserDAO.save(appUser);
    }

    //Patch
    @Override
    public void updateVisibility(UserVisibility visibility, int userId) {
        AppUser user = appUserDAO.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setAppUserVisibility(visibility);

        appUserDAO.save(user);

    }

    @Override
    public void updatePseudo(String newPseudo, int userId) {

        AppUser user = appUserDAO.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));;
        user.setAppUserPseudo(newPseudo);

        appUserDAO.save(user);
    }

}
