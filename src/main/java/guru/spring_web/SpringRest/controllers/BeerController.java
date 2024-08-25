package guru.spring_web.SpringRest.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import guru.spring_web.SpringRest.model.Beer;
import org.springframework.stereotype.Controller;
import guru.spring_web.SpringRest.services.BeerService;

import java.util.UUID;


@AllArgsConstructor
@Slf4j
@Controller
public class BeerController {
    private final BeerService beerService;

    public Beer getBeerByID(UUID id)
    {
        log.debug("Get Beer by ID - Controller");
        return beerService.getBeerByID(id);
    }
}
