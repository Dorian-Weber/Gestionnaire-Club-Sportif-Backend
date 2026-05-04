package com.mns.cda.filsrouge.mockDAO;

import com.mns.cda.filsrouge.dao.TeamDAO;
import com.mns.cda.filsrouge.model.Athlete;
import com.mns.cda.filsrouge.model.Event;
import com.mns.cda.filsrouge.model.Team;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockTeamDao implements TeamDAO {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Team> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Team> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Team> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Team getOne(Integer integer) {
        return null;
    }

    @Override
    public Team getById(Integer integer) {
        return null;
    }

    @Override
    public Team getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Team> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Team> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Team> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Team> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Team> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Team> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Team, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Team> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Team> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Team> findById(Integer idTeam) {
        if(idTeam == 1) {
            return Optional.of(new Team(1,
                    "Test",
                    List.of(new Event()),
                    List.of(new Athlete())));
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Team> findAll() {

        return List.of(new Team(1,
                "Test",
                List.of(new Event()),
                List.of(new Athlete())));
    }

    @Override
    public List<Team> findAllById(Iterable<Integer> integers) {
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
    public void delete(Team entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Team> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Team> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Team> findAll(Pageable pageable) {
        return null;
    }

    //TODO
    @Override
    public List<Team> findTeamsByEvent(int eventId) {
        return List.of();
    }
}
