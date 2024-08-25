package guru.spring_web.SpringRest.services;

import guru.spring_web.SpringRest.model.Beer;

import java.util.UUID;

public interface BeerService {

    Beer getBeerByID(UUID id);
}
