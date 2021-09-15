package com.example.kiemtramodule4.service;

import com.example.kiemtramodule4.model.Country;

import java.util.List;

public interface IServiceCountry {
    List<Country> findAll();

    Country findById(long id);

    Country save(Country country);

    void delete(Country country);

}
