package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.IAppUserService;
import com.mns.cda.filsrouge.dto.UserInfoDTO;
import com.mns.cda.filsrouge.enumerate.UserVisibility;
import com.mns.cda.filsrouge.model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MockAppUserService implements IAppUserService {
    @Override
    public List<AppUser> findAll() {
        return List.of(new AppUser(1,
                "Test",
                "Test",
                "TestTest",
                "Test@test.com",
                "TestTest1!",
                "0698144242",
                UserVisibility.PRIVATE,
                LocalDateTime.now(),
                LocalDateTime.now(),
                new AccountType(),
                List.of(new Relation()),
                List.of(new Relation()),
                List.of(new Vote()),
                List.of(new Reservation())));
    }
    //TODO
    @Override
    public UserInfoDTO getMyInfo(int id) {
        return null;
    }

    @Override
    public Optional<AppUser> findById(int id) {
        if (id == 1) {
            return Optional.of(new AppUser(1,
                    "Test",
                    "Test",
                    "TestTest",
                    "Test@test.com",
                    "TestTest1!",
                    "0698144242",
                    UserVisibility.PRIVATE,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    new AccountType(),
                    List.of(new Relation()),
                    List.of(new Relation()),
                    List.of(new Vote()),
                    List.of(new Reservation())));
        }
        return Optional.empty();
    }

    @Override
    public void create(AppUser appUser) {
        appUser.setIdAppUser(null);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, AppUser appUser) throws UserNotFoundException {
        if (id != 1) {
            throw new UserNotFoundException();
        }
        appUser.setIdAppUser(id);

    }
}
