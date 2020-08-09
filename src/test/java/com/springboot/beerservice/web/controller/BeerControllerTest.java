package com.springboot.beerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.beerservice.bootstrap.BeerLoader;
import com.springboot.beerservice.services.BeerService;
import com.springboot.beerservice.web.model.BeerDto;
import com.springboot.beerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureRestDocs
@WebMvcTest(BeerController.class)
@ComponentScan(basePackages = "com.springframework.beerservice.web.mappers")
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;


    @Test
    void getBeerById() throws Exception{

        given(beerService.getById(any())).willReturn(getValidBeerDTO());

        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {

        BeerDto beerDto = getValidBeerDTO();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        given(beerService.saveNewBeer(any())).willReturn(getValidBeerDTO());

        mockMvc.perform(post("/api/v1/beer/")
        .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());

    }

    @Test
    void updateBeerById() throws Exception{
        given(beerService.updateBeer(any(),any())).willReturn(getValidBeerDTO());
        BeerDto beerDto = getValidBeerDTO();

        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());
    }

    BeerDto getValidBeerDTO()
    {
        return BeerDto.builder()
                .beerName("MY Test Beer")
                .beerStyle(BeerStyleEnum.PILSNER)
                .price(new BigDecimal("2.99"))
                .UPC(BeerLoader.BEER_3_UPC)
                .build();
    }
}