package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformDAO extends JpaRepository<Platform, Integer> {
}
