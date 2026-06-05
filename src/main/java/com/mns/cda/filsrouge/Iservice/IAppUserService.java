package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.dto.UserInfoDTO;
import com.mns.cda.filsrouge.enumerate.UserVisibility;
import com.mns.cda.filsrouge.model.AppUser;

import java.util.List;
import java.util.Optional;

public interface IAppUserService {

    public static class UserNotFoundException extends Exception {}

    //GetAll
    List<AppUser> findAll();

    //GetByID
    Optional<AppUser> findById(int id);

    //GetUserInfo
    UserInfoDTO getMyInfo(int id);

    //Post
    void create(AppUser appUser);

    //Delete
    void delete(int id);

    //Put
    void update(int id, AppUser appUser) throws UserNotFoundException;

    //Patch
    public void updateVisibility(UserVisibility visibility, int userId);

    public void updatePseudo(String newPseudo, int userId);
}
