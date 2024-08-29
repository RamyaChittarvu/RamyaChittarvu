package guru.spring_web.SpringRest.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import guru.spring_web.SpringRest.model.Beer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import guru.spring_web.SpringRest.services.BeerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {


    private final BeerService beerService;
@PostMapping
 //   @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity handlePost(@RequestBody Beer beer)
    {

        Beer beerSaved= beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer/"+beerSaved.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);

    }


    @RequestMapping(method= RequestMethod.GET)
    public List<Beer> listBeers()
    {
return beerService.listBeers();
    }


    @RequestMapping(value="{beerId}", method=RequestMethod.GET)
    public Beer getBeerByID(@PathVariable("beerId") UUID id)
    {
        log.debug("Get Beer by ID - Controller");
        return beerService.getBeerByID(id);
    }
}
