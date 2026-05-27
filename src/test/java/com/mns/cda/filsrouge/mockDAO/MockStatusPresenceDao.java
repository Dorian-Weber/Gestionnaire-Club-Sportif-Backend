package com.mns.cda.filsrouge.mockDAO;

import com.mns.cda.filsrouge.dao.StatusPresenceDAO;
import com.mns.cda.filsrouge.model.StatusPresence;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockStatusPresenceDao implements StatusPresenceDAO {
    @Override
    public void flush() {

    }

    @Override
    public <S extends StatusPresence> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends StatusPresence> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<StatusPresence> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public StatusPresence getOne(Integer integer) {
        return null;
    }

    @Override
    public StatusPresence getById(Integer integer) {
        return null;
    }

    @Override
    public StatusPresence getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends StatusPresence> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends StatusPresence> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends StatusPresence> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends StatusPresence> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends StatusPresence> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends StatusPresence> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends StatusPresence, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends StatusPresence> S save(S entity) {
        return null;
    }

    @Override
    public <S extends StatusPresence> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<StatusPresence> findById(Integer id) {
        if(id == 1) {
            return Optional.of(new StatusPresence(1,
                    "Test"));
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<StatusPresence> findAll() {

        return List.of(new StatusPresence(1,
                "Test"));
    }

    @Override
    public List<StatusPresence> findAllById(Iterable<Integer> integers) {
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
    public void delete(StatusPresence entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends StatusPresence> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<StatusPresence> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<StatusPresence> findAll(Pageable pageable) {
        return null;
    }
}
