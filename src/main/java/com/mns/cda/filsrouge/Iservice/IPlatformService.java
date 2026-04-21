package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.model.Platform;

import java.util.List;
import java.util.Optional;

public interface IPlatformService {

    public static class PlatformNotFoundException extends Exception {}

    //GetAll
    List<Platform> findAll();

    //GetByID
    Optional<Platform> findById(int id);

    //Post
    void create(Platform Platform);

    //Delete
    void delete(int id);

    //Put
    void update(int id, Platform platform) throws PlatformNotFoundException;

}
