package com.mns.cda.filsrouge.Iservice;

import com.mns.cda.filsrouge.model.Country;

import java.util.List;
import java.util.Optional;

public interface ICountryService {

    public static class CountryNotFoundException extends Exception {}

    //GetAll
    List<Country> findAll();

    //GetByID
    Optional<Country> findById(int id);

    //Post
    void create(Country country);

    //Delete
    void delete(int id);

    //Put
    void update(int id, Country country) throws CountryNotFoundException;

}
