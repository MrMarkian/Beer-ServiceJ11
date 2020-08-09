package com.springboot.beerservice.web.mappers;

import com.springboot.beerservice.domain.Beer;
import com.springboot.beerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper (uses = DateMapper.class)
public interface BeerMapper {

    BeerDto BeerToBeerDTO(Beer beer);
    Beer BeertDTOToBeer(BeerDto beerDto);

}
