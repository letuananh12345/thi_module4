package com.example.kiemtramodule4.repository;

import com.example.kiemtramodule4.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRepoCountry extends PagingAndSortingRepository<Country, Long> {
}
