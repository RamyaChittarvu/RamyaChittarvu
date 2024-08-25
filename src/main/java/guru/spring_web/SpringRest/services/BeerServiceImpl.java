package guru.spring_web.SpringRest.services;

import lombok.extern.slf4j.Slf4j;
import guru.spring_web.SpringRest.model.Beer;
import guru.spring_web.SpringRest.model.BeerStyle;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerByID(UUID id) {
        log.debug("Get Beer by ID - service"+ id.toString());
        return Beer.builder()
                .id(id)
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12345")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }
}
