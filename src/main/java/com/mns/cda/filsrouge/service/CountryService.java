package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.ICountryService;
import com.mns.cda.filsrouge.dao.CountryDAO;
import com.mns.cda.filsrouge.model.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService implements ICountryService{

    protected final CountryDAO countryDAO;

    //GetAll
    @Override
    public List<Country> findAll() { return countryDAO.findAll(); }

    //GetByID
    @Override
    public Optional<Country> findById(int id) {
        return countryDAO.findById(id);
    }

    //Post
    @Override
    public void create(Country country) {
        country.setIdCountry(null);
        countryDAO.save(country);
    }

    //Delete
    @Override
    public void delete(int id) {
        countryDAO.deleteById(id);
    }

    //Put
    @Override
    public void update(int id, Country country) throws CountryNotFoundException {
        Optional<Country> countryOptional = countryDAO.findById(id);

        if(countryOptional.isEmpty()) {
            throw new CountryNotFoundException();
        }
        country.setIdCountry(id);
        countryDAO.save(country);
    }

}
