package com.example.kiemtramodule4.service;

import com.example.kiemtramodule4.model.City;

import java.util.List;

public interface IServiceCity {
    List<City> findAll();

    City findById(long id);

    City save(City city);

    void delete(City city);
}
