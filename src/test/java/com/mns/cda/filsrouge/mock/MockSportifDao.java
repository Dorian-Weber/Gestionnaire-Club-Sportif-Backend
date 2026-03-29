package com.mns.cda.filsrouge.mock;

import com.mns.cda.filsrouge.dao.SportifDAO;
import com.mns.cda.filsrouge.model.Evenement;
import com.mns.cda.filsrouge.model.Sportif;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockSportifDao implements SportifDAO {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Sportif> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Sportif> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Sportif> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Sportif getOne(Integer integer) {
        return null;
    }

    @Override
    public Sportif getById(Integer integer) {
        return null;
    }

    @Override
    public Sportif getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Sportif> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Sportif> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Sportif> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Sportif> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Sportif> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Sportif> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Sportif, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Sportif> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Sportif> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Sportif> findById(Integer idSportif) {
        if(idSportif == 1) {
            return Optional.of(new Sportif(1,
                    "Dupont","Jean",
                    new java.util.Date()));
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Sportif> findAll() {

        return List.of(new Sportif(1,
                "Dupont","Jean",
                new java.util.Date()));
    }

    @Override
    public List<Sportif> findAllById(Iterable<Integer> integers) {
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
    public void delete(Sportif entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Sportif> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Sportif> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Sportif> findAll(Pageable pageable) {
        return null;
    }
}
