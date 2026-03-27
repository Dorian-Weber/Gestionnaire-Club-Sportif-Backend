package com.mns.cda.filsrouge.mock;

import com.mns.cda.filsrouge.dao.TypeEvenementDAO;
import com.mns.cda.filsrouge.model.TypeEvenement;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockTypeEvenementDao implements TypeEvenementDAO {
    @Override
    public void flush() {

    }

    @Override
    public <S extends TypeEvenement> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends TypeEvenement> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<TypeEvenement> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TypeEvenement getOne(Integer integer) {
        return null;
    }

    @Override
    public TypeEvenement getById(Integer integer) {
        return null;
    }

    @Override
    public TypeEvenement getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends TypeEvenement> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TypeEvenement> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends TypeEvenement> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends TypeEvenement> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TypeEvenement> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TypeEvenement> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends TypeEvenement, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends TypeEvenement> S save(S entity) {
        return null;
    }

    @Override
    public <S extends TypeEvenement> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<TypeEvenement> findById(Integer idTypeEvenement) {
        if(idTypeEvenement == 1) {
            return Optional.of(new TypeEvenement(1, "Tournois"));
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<TypeEvenement> findAll() {

        return List.of(new TypeEvenement(1, "Tournois"));
    }

    @Override
    public List<TypeEvenement> findAllById(Iterable<Integer> integers) {
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
    public void delete(TypeEvenement entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends TypeEvenement> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<TypeEvenement> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<TypeEvenement> findAll(Pageable pageable) {
        return null;
    }
}
