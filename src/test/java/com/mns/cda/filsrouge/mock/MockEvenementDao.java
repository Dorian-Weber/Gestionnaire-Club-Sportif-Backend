package com.mns.cda.filsrouge.mock;

import com.mns.cda.filsrouge.dao.EvenementDAO;
import com.mns.cda.filsrouge.model.Evenement;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockEvenementDao implements EvenementDAO {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Evenement> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Evenement> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Evenement> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Evenement getOne(Integer integer) {
        return null;
    }

    @Override
    public Evenement getById(Integer integer) {
        return null;
    }

    @Override
    public Evenement getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Evenement> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Evenement> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Evenement> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Evenement> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Evenement> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Evenement> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Evenement, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Evenement> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Evenement> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Evenement> findById(Integer idEvenement) {
        if(idEvenement == 1) {
            return Optional.of(new Evenement(1, "Match de Football", "Rencontre amicale entre deux équipes locales", LocalDateTime.of(2026,04,15,18,00)));
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Evenement> findAll() {

        return List.of(new Evenement(1, "Match de Football", "Rencontre amicale entre deux équipes locales", LocalDateTime.of(2026,04,15,18,00)));
    }

    @Override
    public List<Evenement> findAllById(Iterable<Integer> integers) {
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
    public void delete(Evenement entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Evenement> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Evenement> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Evenement> findAll(Pageable pageable) {
        return null;
    }
}
