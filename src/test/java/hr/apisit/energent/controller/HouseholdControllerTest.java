package hr.apisit.energent.controller;

import hr.apisit.energent.domain.Household;
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
public class HouseholdControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void returnAllSHouseholdsFromFile() throws Exception {
        this.mockMvc.perform(get("/energent/household"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(6)));
    }

    @Test
    @Order(2)
    public void returnHouseholdByIdFromFile() throws Exception {

        final String HOUSEHOLD_ID = "1";
        final String HOUSEHOLD_ADDRESS = "Velebitska 33";
        final String HOUSEHOLD_OWNER = "1";

        this.mockMvc.perform(get("/energent/household/" + HOUSEHOLD_ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.adresa").value(HOUSEHOLD_ADDRESS))
                .andExpect(jsonPath("$.vlasnik.id").value(HOUSEHOLD_OWNER));

    }

    @Test
    @Order(3)
    public void return204IfHouseholdDoesNotExist() throws Exception {
        final String HOUSEHOLD_ID = "100";

        this.mockMvc.perform(get("/energent/household/" + HOUSEHOLD_ID))
                .andExpect(status().isNoContent());
    }

    @Test
    @Order(4)
    public void shouldCreateNewHousehold() throws Exception {
        LocalDate newDateOfBirth = LocalDate.of(1990,02,19);
        Owner testOwner = new Owner(1, "Ivo",
                "Ivic", newDateOfBirth , "19823245234");

        Household testHousehold = new Household(7, "Miloradna 11",
                testOwner);

        final String NEW_HOUSEHOLD = JsonUtils.toJson(testHousehold);

        this.mockMvc.perform(post("/energent/household").
                        contentType(MediaType.APPLICATION_JSON)
                        .content(NEW_HOUSEHOLD))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    @Order(5)
    public void shouldDeleteHouseholdById() throws Exception {
        final String HOUSEHOLD_ID = "7";

        this.mockMvc.perform(delete("/energent/household/" + HOUSEHOLD_ID).
                        contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @Order(6)
    public void return204IfHouseholdDoesNotExistDeleteById() throws Exception {
        final String HOUSEHOLD_ID = "10000000";

        this.mockMvc.perform(delete("/energent/household/" + HOUSEHOLD_ID))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @Order(7)
    public void shouldUpdateHouseholdById() throws Exception {

        final Integer HOUSEHOLD_ID = 5;

        LocalDate newDateOfBirth = LocalDate.of(1950,1,5);
        Owner testOwner = new Owner(6, "Milorad",
                "Pupovac", newDateOfBirth , "99999999999");

        Household testHousehold = new Household(6, "Krndeljeva 21",
                testOwner);

        final String NEW_HOUSEHOLD = JsonUtils.toJson(testHousehold);

        this.mockMvc.perform(put("/energent/household/" + HOUSEHOLD_ID)
                        .content(NEW_HOUSEHOLD)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());


    }
}
