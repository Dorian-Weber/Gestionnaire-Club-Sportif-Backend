package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IAppUserService;
import com.mns.cda.filsrouge.dao.AppUserDAO;
import com.mns.cda.filsrouge.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppUserService implements IAppUserService{

    protected final AppUserDAO appUserDAO;
    private final PasswordEncoder encoder;

    //GetAll
    @Override
    public List<AppUser> findAll() { return appUserDAO.findAll(); }

    //GetByID
    @Override
    public Optional<AppUser> findById(int id) {
        return appUserDAO.findById(id);
    }

    //Post
    @Override
    public void create(AppUser appUser) {
        appUser.setIdAppUser(null);
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

}
