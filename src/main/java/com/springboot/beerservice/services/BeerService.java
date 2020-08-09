package com.springboot.beerservice.services;

import com.springboot.beerservice.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {


    BeerDto getById(UUID beerID);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
