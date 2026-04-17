package com.mns.cda.filsrouge.mockDAO;

import com.mns.cda.filsrouge.dao.LevelDAO;
import com.mns.cda.filsrouge.model.Level;
import com.mns.cda.filsrouge.model.Platform;
import com.mns.cda.filsrouge.model.Seat;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockLevelDao implements LevelDAO {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Level> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Level> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Level> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Level getOne(Integer integer) {
        return null;
    }

    @Override
    public Level getById(Integer integer) {
        return null;
    }

    @Override
    public Level getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Level> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Level> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Level> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Level> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Level> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Level> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Level, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Level> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Level> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Level> findById(Integer idTypeEvenement) {
        if(idTypeEvenement == 1) {
            return Optional.of(new Level(1,
                    "Test",
                    List.of(new Seat()),
                    new Platform()));
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Level> findAll() {

        return List.of(new Level(1,
                "Test",
                List.of(new Seat()),
                new Platform()));
    }

    @Override
    public List<Level> findAllById(Iterable<Integer> integers) {
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
    public void delete(Level entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Level> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Level> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Level> findAll(Pageable pageable) {
        return null;
    }
}
