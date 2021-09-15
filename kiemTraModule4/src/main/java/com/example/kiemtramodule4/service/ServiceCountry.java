package com.example.kiemtramodule4.service;

import com.example.kiemtramodule4.model.Country;
import com.example.kiemtramodule4.repository.IRepoCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCountry implements IServiceCountry {
    @Autowired
    IRepoCountry iRepoCountry;

    @Override
    public List<Country> findAll() {
        return (List<Country>) iRepoCountry.findAll();
    }

    @Override
    public Country findById(long id) {
        return iRepoCountry.findById(id).get();
    }

    @Override
    public Country save(Country country) {
        return iRepoCountry.save(country);
    }

    @Override
    public void delete(Country country) {
        iRepoCountry.delete(country);
    }
}
