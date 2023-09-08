package hr.apisit.energent.controller;

import hr.apisit.energent.domain.Owner;
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

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OwnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    @Order(1)
//    public void returnAllSOwnersFromFile() throws Exception {
//        this.mockMvc.perform(get("/energent/owner"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$", hasSize(5)));
//    }
//
//    @Test
//    @Order(2)
//    public void returnOwnerByIdFromFile() throws Exception {
//
//        final String OWNER_ID = "1";
//        final String OWNER_IME = "Ivo";
//        final String OWNER_PREZIME = "Ivic";
//        final String OWNER_DATUM_RODENJA = "19.02.1990.";
//        final String OWNER_OIB = "19823245234";
//
//        this.mockMvc.perform(get("/energent/owner/" + OWNER_ID))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.ime").value(OWNER_IME))
//                .andExpect(jsonPath("$.prezime").value(OWNER_PREZIME))
////                .andExpect(jsonPath("$.datumRodenja").value(LocalDateUtility.convertStringToLocalDate(OWNER_DATUM_RODENJA)))
//                .andExpect(jsonPath("$.oib").value(OWNER_OIB));
//    }
//
//    @Test
//    @Order(3)
//    public void return204IfOwnerDoesNotExist() throws Exception {
//        final String OWNER_ID = "100";
//
//        this.mockMvc.perform(get("/energent/owner/" + OWNER_ID))
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    @Order(4)
//    public void shouldCreateNewOwner() throws Exception {
//        LocalDate newDateOfBirth = LocalDate.of(1950,1,5);
//
//        Owner testOwner = new Owner(6, "Milorad",
//                "Pupovac", newDateOfBirth , "99999999999");
//
//        final String NEW_OWNER = JsonUtils.toJson(testOwner);
//
//        this.mockMvc.perform(post("/energent/owner").
//                        contentType(MediaType.APPLICATION_JSON)
//                        .content(NEW_OWNER))
//                .andExpect(status().isCreated())
//                .andReturn();
//    }
//
//    @Test
//    @Order(5)
//    public void shouldDeleteOwnerById() throws Exception {
//        final String OWNER_ID = "6";
//
//        this.mockMvc.perform(delete("/energent/owner/" + OWNER_ID).
//                        contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    @Order(6)
//    public void return204IfOwnerDoesNotExistDeleteById() throws Exception {
//        final String OWNER_ID = "10000000";
//
//        this.mockMvc.perform(delete("/energent/owner/" + OWNER_ID))
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    @Order(7)
//    public void shouldUpdateOwnerById() throws Exception {
//
//        final Integer OWNER_ID = 5;
//        LocalDate newDateOfBirth = LocalDate.of(1977,2,4);
//        Owner updatedOwner = new Owner(OWNER_ID, "Alfa",
//                "Supreme", newDateOfBirth, "88888888888");
//
//        final String NEW_OWNER = JsonUtils.toJson(updatedOwner);
//
//        this.mockMvc.perform(put("/energent/owner/" + OWNER_ID)
//                        .content(NEW_OWNER)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().is2xxSuccessful());
//
//
//    }
}
