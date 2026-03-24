package com.mns.cda.filsrouge.mock;

import com.mns.cda.filsrouge.dao.DisciplineDAO;
import com.mns.cda.filsrouge.model.Discipline;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockDisciplineDao implements DisciplineDAO {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Discipline> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Discipline> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Discipline> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Discipline getOne(Integer integer) {
        return null;
    }

    @Override
    public Discipline getById(Integer integer) {
        return null;
    }

    @Override
    public Discipline getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Discipline> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Discipline> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Discipline> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Discipline> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Discipline> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Discipline> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Discipline, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Discipline> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Discipline> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Discipline> findById(Integer idDiscipline) {
        if(idDiscipline == 1) {
            return Optional.of(new Discipline(1, "Saut en hauteur", "2.45m","2.45 m"));
        }

        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Discipline> findAll() {
        return List.of();
    }

    @Override
    public List<Discipline> findAllById(Iterable<Integer> integers) {
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
    public void delete(Discipline entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Discipline> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Discipline> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Discipline> findAll(Pageable pageable) {
        return null;
    }
}
