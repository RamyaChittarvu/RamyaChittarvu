package guru.spring_web.SpringRest.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.spring_web.SpringRest.model.Beer;
import guru.spring_web.SpringRest.services.BeerService;
import guru.spring_web.SpringRest.services.BeerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@SpringBootTest
    @WebMvcTest(BeerController.class)
    class BeerControllerTest {

        //BeerController beerController;
        @Autowired
        MockMvc mockMvc;
        @MockBean
        BeerService beerService;

        @Autowired
    ObjectMapper objectMapper;

        @Captor
                ArgumentCaptor<UUID> uuidArgumentCaptor;

        @Captor
                ArgumentCaptor<Beer> beerArgumentCaptor;

        BeerServiceImpl beerServiceImpl;//= new BeerServiceImpl();

    @BeforeEach
    void setUp() {
        beerServiceImpl= new BeerServiceImpl();
    }


    @Test
    void testPatchBeer() throws Exception {
        Beer beer= beerServiceImpl.listBeers().get(0);

        Map<String,Object> beerMap= new HashMap<>();
        beerMap.put("beerName","New Name");

        mockMvc.perform(patch("/api/v1/beer/"+beer.getId()).contentType(MediaType.APPLICATION_JSON).
                        accept(MediaType.APPLICATION_JSON)
                . content(objectMapper.writeValueAsString(beerMap)))
                .andExpect(status().isNoContent());

        verify(beerService).updateBeerPatchByID(uuidArgumentCaptor.capture(),beerArgumentCaptor.capture());

        assertThat(beer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
        assertThat(beerMap.get("beerName")).isEqualTo(beerArgumentCaptor.getValue().getBeerName());

    }


    @Test
    void getBeerByIDNotFound() throws Exception {

given(beerService.getBeerByID(any(UUID.class))).willThrow(NotFoundException.class);
        mockMvc.perform(get("/api/v1/beer/"+UUID.randomUUID())).andExpect(status().isNotFound());
    }

    @Test
    void testDeleteBeer() throws Exception {
        Beer beer= beerServiceImpl.listBeers().get(0);
        mockMvc.perform(delete("/api/v1/beer/"+beer.getId()).
                        accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

      //  ArgumentCaptor<UUID> uuidArgumentCaptor=ArgumentCaptor.forClass(UUID.class);

        verify(beerService).DeleteBeerByID(uuidArgumentCaptor.capture());

        assertThat(beer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
    }

    @Test
    void testUpdateBeer() throws Exception {
        Beer beer= beerServiceImpl.listBeers().get(0);
//        given(beerService.saveNewBeer(any(Beer.class))).willReturn(beerServiceImpl.listBeers().get(1));
        mockMvc.perform(put("/api/v1/beer/"+beer.getId()).
                        accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).
                        content(objectMapper.writeValueAsString(beer)))
                .andExpect(status().isNoContent());

                verify(beerService).updateBeerByID(any(UUID.class),any(Beer.class));
    }

    @Test
    void testCreateNewBeer() throws Exception {
Beer beer= beerServiceImpl.listBeers().get(0);
//System.out.println(objectMapper.writeValueAsString(beer));
beer.setVersion(null);
beer.setId(null);
given(beerService.saveNewBeer(any(Beer.class))).willReturn(beerServiceImpl.listBeers().get(1));
        mockMvc.perform(post("/api/v1/beer").
                        accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).
                content(objectMapper.writeValueAsString(beer)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));
        }


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