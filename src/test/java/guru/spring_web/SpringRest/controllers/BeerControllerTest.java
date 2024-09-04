package guru.spring_web.SpringRest.controllers;

import guru.spring_web.SpringRest.model.Beer;
import guru.spring_web.SpringRest.services.BeerService;
import guru.spring_web.SpringRest.services.BeerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@SpringBootTest
    @WebMvcTest(BeerController.class)
    class BeerControllerTest {

        //BeerController beerController;
        @Autowired
        MockMvc mockMvc;
        @MockBean
        BeerService beerService;

        BeerServiceImpl beerServiceImpl= new BeerServiceImpl();

        @Test
        void listBeers() throws Exception
        {
            given(beerService.listBeers()).willReturn(beerServiceImpl.listBeers());
            mockMvc.perform(get("/api/v1/beer").accept(MediaType.APPLICATION_JSON)).
                    andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.length()",is(3)));
        }
        @Test
        void getBeerByID() throws Exception {


            Beer testBeer=beerServiceImpl.listBeers().get(0);

            given(beerService.getBeerByID(any(UUID.class))).willReturn(testBeer);
            mockMvc.perform(get("/api/v1/beer/"+UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.id",is(testBeer.getId().toString())))
                    .andExpect(jsonPath("$.beerName",is(testBeer.getBeerName().toString())))



            ;

            //System.out.println(beerController.getBeerByID(UUID.randomUUID()));
        }
    }