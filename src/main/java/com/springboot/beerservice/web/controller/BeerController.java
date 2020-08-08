package com.springboot.beerservice.web.controller;

import com.springboot.beerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pi/v1/beer")
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerID") UUID beerId){
        //todo: Create full Implementation
        return new ResponseEntity<BeerDto>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto){
        //todo: Create full implementation
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerID") UUID beerId,@RequestBody BeerDto beerDto){
        //todo: Create Full implemenation
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
