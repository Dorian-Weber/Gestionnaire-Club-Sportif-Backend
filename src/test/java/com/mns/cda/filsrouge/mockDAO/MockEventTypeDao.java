package com.mns.cda.filsrouge.mockDAO;

import com.mns.cda.filsrouge.dao.EventTypeDAO;
import com.mns.cda.filsrouge.model.Event;
import com.mns.cda.filsrouge.model.EventType;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockEventTypeDao implements EventTypeDAO {
    @Override
    public void flush() {

    }

    @Override
    public <S extends EventType> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends EventType> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<EventType> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public EventType getOne(Integer integer) {
        return null;
    }

    @Override
    public EventType getById(Integer integer) {
        return null;
    }

    @Override
    public EventType getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends EventType> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends EventType> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends EventType> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends EventType> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends EventType> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends EventType> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends EventType, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends EventType> S save(S entity) {
        return null;
    }

    @Override
    public <S extends EventType> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<EventType> findById(Integer idTypeEvenement) {
        if(idTypeEvenement == 1) {
            return Optional.of(new EventType(1,
                    "Tournois",
                    List.of(new Event())));
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<EventType> findAll() {

        return List.of(new EventType(1,
                "Tournois",
                List.of(new Event())));
    }

    @Override
    public List<EventType> findAllById(Iterable<Integer> integers) {
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
    public void delete(EventType entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends EventType> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<EventType> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<EventType> findAll(Pageable pageable) {
        return null;
    }
}
