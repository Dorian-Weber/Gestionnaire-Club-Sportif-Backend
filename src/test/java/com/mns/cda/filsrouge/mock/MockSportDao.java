package com.mns.cda.filsrouge.mock;

import com.mns.cda.filsrouge.dao.SportDAO;
import com.mns.cda.filsrouge.model.Discipline;
import com.mns.cda.filsrouge.model.Sport;
import com.mns.cda.filsrouge.model.Sport;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockSportDao implements SportDAO {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Sport> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Sport> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Sport> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Sport getOne(Integer integer) {
        return null;
    }

    @Override
    public Sport getById(Integer integer) {
        return null;
    }

    @Override
    public Sport getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Sport> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Sport> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Sport> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Sport> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Sport> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Sport> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Sport, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Sport> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Sport> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Sport> findById(Integer idSport) {
        if(idSport == 1) {
            return Optional.of(new Sport(1, "Athlétisme",List.of(new Discipline())));
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Sport> findAll() {

        return List.of(new Sport(1, "Athlétisme",List.of(new Discipline())));
    }

    @Override
    public List<Sport> findAllById(Iterable<Integer> integers) {
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
    public void delete(Sport entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Sport> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Sport> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Sport> findAll(Pageable pageable) {
        return null;
    }
}
