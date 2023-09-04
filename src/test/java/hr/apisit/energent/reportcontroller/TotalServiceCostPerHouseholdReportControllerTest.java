package hr.apisit.energent.reportcontroller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TotalServiceCostPerHouseholdReportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTotalServiceCostPerHousehold() throws Exception {
        this.mockMvc.perform(get("/energent/totalServiceCostPerHousehold"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.['Velebitska 33']")
                        .value(333.45));
    }

}
