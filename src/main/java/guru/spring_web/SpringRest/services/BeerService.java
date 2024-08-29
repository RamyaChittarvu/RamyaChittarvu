package guru.spring_web.SpringRest.services;

import guru.spring_web.SpringRest.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    List<Beer> listBeers();

    Beer getBeerByID(UUID id);

    Beer saveNewBeer(Beer beer);
}
