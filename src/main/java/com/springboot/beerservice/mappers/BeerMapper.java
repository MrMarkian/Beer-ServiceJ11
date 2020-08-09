package com.springboot.beerservice.mappers;


import com.springboot.beerservice.domain.Beer;
import com.springboot.beerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDTO(Beer beer);
        Beer beerDTOtoBeer(BeerDto dto);
}
