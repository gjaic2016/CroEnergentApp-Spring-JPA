package hr.apisit.energent.controller;

import hr.apisit.energent.domain.ServiceProvider;
import hr.apisit.energent.utility.JsonUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.hasSize;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceProviderControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    @Order(1)
//    public void returnAllServiceProvidersFromFile() throws Exception {
//        this.mockMvc.perform(get("/energent/serviceprovider"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$", hasSize(17)));
//    }
//
//    @Test
//    @Order(2)
//    public void returnServiceProviderByIdFromFile() throws Exception {
//
//        final String SERVICE_PROVIDER_ID = "1";
//        final String SERVICE_PROVIDER_NAZIV = "Jugoplastika";
//        final String SERVICE_PROVIDER_ADRESA = "Smičiklasova 2";
//        final String SERVICE_PROVIDER_VRSTA_USLUGE = "ELECTRICITY_SUPPLY";
//        final String SERVICE_PROVIDER_CIJENA_USLUGE = "333.45";
//
//        this.mockMvc.perform(get("/energent/serviceprovider/" + SERVICE_PROVIDER_ID))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.naziv").value(SERVICE_PROVIDER_NAZIV))
//                .andExpect(jsonPath("$.adresa").value(SERVICE_PROVIDER_ADRESA))
//                .andExpect(jsonPath("$.vrstaUsluge").value(SERVICE_PROVIDER_VRSTA_USLUGE))
//                .andExpect(jsonPath("$.cijenaUsluge").value(SERVICE_PROVIDER_CIJENA_USLUGE));
//    }
//
//    @Test
//    @Order(3)
//    public void return204IfServiceProviderDoesNotExist() throws Exception {
//        final String SERVICE_PROVIDER_ID = "100";
//
//        this.mockMvc.perform(get("/energent/serviceprovider/" + SERVICE_PROVIDER_ID))
//                .andExpect(status().isNoContent());
//    }
//
////    @Test
////    @Order(4)
////    public void shouldCreateNewServiceProvider() throws Exception {
////        ServiceProvider testServiceProvider = new ServiceProvider(18, "SOA Ured",
////                "Vrbina 33", ServiceType2.GAS_SUPPLY, new BigDecimal(33));
////
////        final String NEW_SERVICE_PROVIDER = JsonUtils.toJson(testServiceProvider);
////
////        this.mockMvc.perform(post("/energent/serviceprovider").
////                        contentType(MediaType.APPLICATION_JSON)
////                        .content(NEW_SERVICE_PROVIDER))
////                .andExpect(status().isCreated())
////                .andReturn();
////    }
//
//    @Test
//    @Order(5)
//    public void shouldDeleteServiceProviderById() throws Exception {
//        final String SERVICE_PROVIDER_ID = "18";
//
//        this.mockMvc.perform(delete("/energent/serviceprovider/" + SERVICE_PROVIDER_ID).
//                        contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    @Order(6)
//    public void return204IfServiceProviderDoesNotExistDeleteById() throws Exception {
//        final String SERVICE_PROVIDER_ID = "10000000";
//
//        this.mockMvc.perform(delete("/energent/serviceprovider/" + SERVICE_PROVIDER_ID))
//                .andExpect(status().is2xxSuccessful());
//    }
//
////    @Test
////    @Order(7)
////    public void shouldUpdateServiceProviderById() throws Exception {
////
////        final Integer SERVICE_PROVIDER_ID = 16;
////
//////        ServiceProvider updatedServiceProvider = new ServiceProvider(SERVICE_PROVIDER_ID, "Alfa Ormari",
//////                "Nad Lipom 35", ServiceType2.GAS_SUPPLY, new BigDecimal(150));
////
////        final String NEW_SERVICE_PROVIDER = JsonUtils.toJson(updatedServiceProvider);
////
////        this.mockMvc.perform(put("/energent/serviceprovider/" + SERVICE_PROVIDER_ID)
////                        .content(NEW_SERVICE_PROVIDER)
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .accept(MediaType.APPLICATION_JSON))
////                .andExpect(status().is2xxSuccessful());
////
////
////    }

}

