package com.mns.cda.filsrouge.mock;

import com.mns.cda.filsrouge.dao.AthleteDAO;
import com.mns.cda.filsrouge.model.Athlete;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockAthleteDao implements AthleteDAO {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Athlete> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Athlete> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Athlete> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Athlete getOne(Integer integer) {
        return null;
    }

    @Override
    public Athlete getById(Integer integer) {
        return null;
    }

    @Override
    public Athlete getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Athlete> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Athlete> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Athlete> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Athlete> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Athlete> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Athlete> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Athlete, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Athlete> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Athlete> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Athlete> findById(Integer idAthlete) {
        if(idAthlete == 1) {
            return Optional.of(new Athlete(1,
                    "Dupont","Jean", LocalDate.now()));
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Athlete> findAll() {

        return List.of(new Athlete(1,
                "Dupont","Jean",
                LocalDate.now()));
    }

    @Override
    public List<Athlete> findAllById(Iterable<Integer> integers) {
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
    public void delete(Athlete entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Athlete> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Athlete> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Athlete> findAll(Pageable pageable) {
        return null;
    }
}
