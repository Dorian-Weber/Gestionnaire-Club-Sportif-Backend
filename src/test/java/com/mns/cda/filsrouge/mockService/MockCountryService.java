package com.mns.cda.filsrouge.mockService;

import com.mns.cda.filsrouge.Iservice.ICountryService;
import com.mns.cda.filsrouge.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MockCountryService implements ICountryService {
    @Override
    public List<Country> findAll() {
        return List.of(new Country(1,
                "France",
                List.of(new Athlete())));
    }

    @Override
    public Optional<Country> findById(int id) {
        if (id == 1) {
            return Optional.of(new Country(1,
                    "France",
                    List.of(new Athlete())));
        }
        return Optional.empty();
    }

    @Override
    public void create(Country country) {
        country.setIdCountry(null);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Country country) throws CountryNotFoundException {
        if (id != 1) {
            throw new CountryNotFoundException();
        }
        country.setIdCountry(id);

    }
}
