package com.springboot.beerservice.services;

import com.springboot.beerservice.controller.NotFoundException;
import com.springboot.beerservice.domain.Beer;
import com.springboot.beerservice.mappers.BeerMapper;
import com.springboot.beerservice.web.model.BeerDto;
import com.springboot.beerservice.web.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service("beerService")
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;


    @Override
    public BeerDto getById(UUID beerID) {
       return beerMapper.beerToBeerDTO(beerRepository.findById(beerID).orElseThrow(NotFoundException::new));

    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {

        return beerMapper.beerToBeerDTO(beerRepository.save(beerMapper.beerDTOtoBeer(beerDto)));

    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {

        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUPC());


        return beerMapper.beerToBeerDTO(beerRepository.save(beer));

    }
}
