package com.mns.cda.filsrouge.mockDAO;

import com.mns.cda.filsrouge.dao.AppUserDAO;
import com.mns.cda.filsrouge.dto.UserInfoDTO;
import com.mns.cda.filsrouge.enumerate.UserVisibility;
import com.mns.cda.filsrouge.model.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockAppUserDao implements AppUserDAO {
    @Override
    public void flush() {

    }

    @Override
    public <S extends AppUser> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends AppUser> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<AppUser> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public AppUser getOne(Integer integer) {
        return null;
    }

    @Override
    public AppUser getById(Integer integer) {
        return null;
    }

    @Override
    public AppUser getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends AppUser> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends AppUser> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends AppUser> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends AppUser> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends AppUser> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends AppUser> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends AppUser, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends AppUser> S save(S entity) {
        return null;
    }

    @Override
    public <S extends AppUser> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<AppUser> findById(Integer id) {
        if(id == 1) {
            return Optional.of(new AppUser(1,
                    "Test",
                    "Test",
                    "TestTest",
                    "Test@test.com",
                    "TestTest1!",
                    "0698144242",
                    UserVisibility.PRIVATE,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    new AccountType(),
                    List.of(new Relation()),
                    List.of(new Relation()),
                    List.of(new Vote()),
                    List.of(new Reservation())));
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<AppUser> findAll() {

        return List.of(new AppUser(1,
                "Test",
                "Test",
                "TestTest",
                "Test@test.com",
                "TestTest1!",
                "0698144242",
                UserVisibility.PRIVATE,
                LocalDateTime.now(),
                LocalDateTime.now(),
                new AccountType(),
                List.of(new Relation()),
                List.of(new Relation()),
                List.of(new Vote()),
                List.of(new Reservation())));
    }

    @Override
    public List<AppUser> findAllById(Iterable<Integer> integers) {
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
    public void delete(AppUser entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends AppUser> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<AppUser> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<AppUser> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<AppUser> findByAppUserEmail(String email) {
        return Optional.empty();
    }

    @Override
    public boolean existsByAppUserPseudo(String appUserPseudo) {
        return false;
    }

    //TODO
    @Override
    public UserInfoDTO getUserInfo(int idUser) {
        return null;
    }
}
