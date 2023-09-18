package hr.apisit.energent.controller;

import hr.apisit.energent.domain.*;
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
import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContractControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    @Order(1)
//    public void returnAllContractsFromDB() throws Exception {
//        final int CONTRACTS_SIZE = 6;
//
//        this.mockMvc.perform(get("/energent/contract"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$", hasSize(CONTRACTS_SIZE)));
//    }
//
//    @Test
//    @Order(2)
//    public void returnContractByIdFromFile() throws Exception {
//
//        final String CONTRACT_ID = "1";
//        final String CONTRACT_TIP = "FIXED";
//        final String CONTRACT_SPROVIDER = "1";
//        final String CONTRACT_HOUSEHOLD = "1";
//
//        this.mockMvc.perform(get("/energent/contract/" + CONTRACT_ID))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.tip").value(CONTRACT_TIP))
//                .andExpect(jsonPath("$.pruzateljUsluge.id").value(CONTRACT_SPROVIDER))
//                .andExpect(jsonPath("$.kucanstvo.id").value(CONTRACT_HOUSEHOLD));
//
//    }
//
//    @Test
//    @Order(3)
//    public void return204IfContractDoesNotExist() throws Exception {
//        final String CONTRACT_ID = "10000";
//
//        this.mockMvc.perform(get("/energent/contract/" + CONTRACT_ID))
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    @Order(4)
//    public void shouldCreateNewContract() throws Exception {
//        LocalDate newDateOfBirth = LocalDate.of(1990,02,19);
//        LocalDate contractStart = LocalDate.of(2000,05,01);
//        LocalDate contractEnd = LocalDate.of(2001,05,01);
//        Owner testOwner = new Owner(1, "Ivo",
//                "Ivic", newDateOfBirth , "19823245234");
//
//        Household testHousehold = new Household(1, "Velebitska 33",
//                testOwner);
//
//        ServiceProvider testServiceProvider = new ServiceProvider(2, "Jugoplastika",
//                "Smičiklasova 2", ServiceType2.WATER_SUPPLY, new BigDecimal(233));
//
//        Contract testContract = new FixedTermContract(6, "FIXED", testServiceProvider,
//                testHousehold ,contractStart,contractEnd);
//
//        final String NEW_CONTRACT = JsonUtils.toJson(testContract);
//
//        this.mockMvc.perform(post("/energent/contract").
//                        contentType(MediaType.APPLICATION_JSON)
//                        .content(NEW_CONTRACT))
//                .andExpect(status().isCreated())
//                .andReturn();
//    }
//
//    @Test
//    @Order(5)
//    public void shouldDeleteContractById() throws Exception {
//        final String CONTRACT_ID = "6";
//
//        this.mockMvc.perform(delete("/energent/contract/" + CONTRACT_ID).
//                        contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    @Order(6)
//    public void return204IfContractDoesNotExistDeleteById() throws Exception {
//        final String CONTRACT_ID = "10000000";
//
//        this.mockMvc.perform(delete("/energent/contract/" + CONTRACT_ID))
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    @Order(7)
//    public void shouldUpdateContractById() throws Exception {
//
//        final Integer CONTRACT_ID = 5;
//
//        LocalDate newDateOfBirth = LocalDate.of(1977,02,04);
//        LocalDate contractStart = LocalDate.of(2002,05,01);
//        LocalDate contractEnd = LocalDate.of(2003,05,01);
//        Owner testOwner = new Owner(5, "Alfa",
//                "Supreme", newDateOfBirth , "88888888888");
//
//        Household testHousehold = new Household(5, "Krndeljeva 21",
//                testOwner);
//
//        Address address = new Address(1,"Smičiklasova 2", )
//
//        ServiceProvider testServiceProvider = new ServiceProvider(2, "Jugoplastika",
//                address, ServiceType2.WATER_SUPPLY, new BigDecimal(233));
//
//        Contract testContract = new FixedTermContract(CONTRACT_ID, "FIXED", testServiceProvider,
//                testHousehold ,contractStart,contractEnd);
//
//        final String NEW_CONTRACT = JsonUtils.toJson(testContract);
//
//        this.mockMvc.perform(put("/energent/contract/" + CONTRACT_ID)
//                        .content(NEW_CONTRACT)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().is2xxSuccessful());
//
//
//    }
}
