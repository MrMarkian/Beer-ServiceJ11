package com.springboot.beerservice.bootstrap;

import com.springboot.beerservice.domain.Beer;
import com.springboot.beerservice.web.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }


    public static final String BEER_1_UPC = "0631234620453";
    public static final String BEER_2_UPC = "0631235321062";
    public static final String BEER_3_UPC = "0631244324569";


    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {

        if(beerRepository.count() == 0){
            beerRepository.save(Beer.builder()
            .beerName("Mango Bobs")
            .beerStyle("IPA")
            .quantityToBrew(200)
                    .upc(BeerLoader.BEER_1_UPC)
                    .price(new BigDecimal("12.95"))
            .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(250)
                    .upc(BeerLoader.BEER_2_UPC)
                    .price(new BigDecimal("10.99"))
                    .build());
        }

        System.out.println("Loaded Default Beers:" + beerRepository.count());

    }
}
