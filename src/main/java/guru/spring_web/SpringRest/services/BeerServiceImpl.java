package guru.spring_web.SpringRest.services;

import lombok.extern.slf4j.Slf4j;
import guru.spring_web.SpringRest.model.Beer;
import guru.spring_web.SpringRest.model.BeerStyle;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID,Beer> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        Beer beer1=Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12345")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer2= Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("1234524567")
                .price(new BigDecimal("11.99"))
                .quantityOnHand(392)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();


        Beer beer3= Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Sunshine City")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("127812367")
                .price(new BigDecimal("13.99"))
                .quantityOnHand(144)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();


        beerMap.put(beer1.getId(),beer1);
        beerMap.put(beer2.getId(),beer2);
        beerMap.put(beer3.getId(),beer3);


    }


@Override
    public List<Beer> listBeers()
    {
        return new ArrayList<>(beerMap.values());
    }



        @Override
        public Beer getBeerByID (UUID id){
            log.debug("Get Beer by ID - service" + id.toString());
            return beerMap.get(id);
        }

    @Override
    public Beer saveNewBeer(Beer beer) {

       Beer beerSaved= Beer.builder()
               .id(UUID.randomUUID())
               .createdDate(LocalDateTime.now())
               .updateDate(LocalDateTime.now())
               .version(beer.getVersion())
               .beerStyle(beer.getBeerStyle())
               .upc(beer.getUpc())
               .quantityOnHand(beer.getQuantityOnHand())
               .beerName(beer.getBeerName())
               .price(beer.getPrice())
               .build();

       beerMap.put(beerSaved.getId(),beerSaved);

        return beerSaved;
    }

}
