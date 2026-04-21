package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IPlatformService;
import com.mns.cda.filsrouge.dao.PlatformDAO;
import com.mns.cda.filsrouge.model.Platform;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlatformService implements IPlatformService{

    protected final PlatformDAO platformDAO;

    //GetAll
    @Override
    public List<Platform> findAll() { return platformDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Platform> findById(int id) {
        return platformDAO.findById(id);
    }

    //Post
    @Override
    public void create(Platform platform) {
        platform.setIdPlatform(null);
        platformDAO.save(platform);
    }

    //Delete
    @Override
    public void delete(int id) {
        platformDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(int id, Platform platform) throws PlatformNotFoundException {
        Optional<Platform> platformOptional = platformDAO.findById(id);

        if(platformOptional.isEmpty()) {
            throw new PlatformNotFoundException();
        }
        platform.setIdPlatform(id);
        platformDAO.save(platform);
    }

}
