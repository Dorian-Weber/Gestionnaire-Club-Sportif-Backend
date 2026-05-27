package com.mns.cda.filsrouge.mockDAO;

import com.mns.cda.filsrouge.dao.PlatformDAO;
import com.mns.cda.filsrouge.model.Level;
import com.mns.cda.filsrouge.model.Platform;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockPlatformDao implements PlatformDAO {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Platform> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Platform> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Platform> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Platform getOne(Integer integer) {
        return null;
    }

    @Override
    public Platform getById(Integer integer) {
        return null;
    }

    @Override
    public Platform getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Platform> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Platform> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Platform> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Platform> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Platform> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Platform> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Platform, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Platform> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Platform> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Platform> findById(Integer id) {
        if(id == 1) {
            return Optional.of(new Platform(1,
                    "Test",List.of(new Level())));
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Platform> findAll() {

        return List.of(new Platform(1,
                "Test",List.of(new Level())));
    }

    @Override
    public List<Platform> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Platform entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Platform> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Platform> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Platform> findAll(Pageable pageable) {
        return null;
    }
}
