package com.mns.cda.filsrouge.mockDAO;

import com.mns.cda.filsrouge.dao.SeatDAO;
import com.mns.cda.filsrouge.model.Reservation;
import com.mns.cda.filsrouge.model.Seat;
import com.mns.cda.filsrouge.model.Level;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockSeatDao implements SeatDAO {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Seat> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Seat> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Seat> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Seat getOne(Integer integer) {
        return null;
    }

    @Override
    public Seat getById(Integer integer) {
        return null;
    }

    @Override
    public Seat getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Seat> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Seat> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Seat> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Seat> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Seat> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Seat> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Seat, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Seat> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Seat> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Seat> findById(Integer idTypeEvenement) {
        if(idTypeEvenement == 1) {
            return Optional.of(new Seat(1,
                    "Test",
                    new Level(),List.of(
                    new Reservation())));
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Seat> findAll() {

        return List.of(new Seat(1,
                "Test",
                new Level(),List.of(
                new Reservation())));
    }

    @Override
    public List<Seat> findAllById(Iterable<Integer> integers) {
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
    public void delete(Seat entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Seat> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Seat> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Seat> findAll(Pageable pageable) {
        return null;
    }

    //TODO
    @Override
    public List<Seat> findByPlatformAndLevel(String platform, String level) {
        return List.of();
    }
}
