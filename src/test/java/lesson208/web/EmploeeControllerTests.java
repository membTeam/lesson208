package lesson208.web;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmploeeControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void maxSalary_withError_test() throws Exception {
        mockMvc.perform(get("/departments/max-salary/10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void maxSalary_test() throws Exception {
        mockMvc.perform(get("/departments/max-salary/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void minSalary_withError_test() throws Exception {
        mockMvc.perform(get("/departments/min-salary/10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void minSalary_test() throws Exception {
        mockMvc.perform(get("/departments/min-salary/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void allEmploeeForDepartment_withError_test() throws Exception {
        mockMvc.perform(get("/departments/all/10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void allEmploeeForDepartment_test() throws Exception {
        mockMvc.perform(get("/departments/all/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void listDepartment_test() throws Exception {
            mockMvc.perform(get("/departments/list-department")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
    }

    @Test
    public void allEmploee_test() throws Exception  {
            mockMvc.perform(get("/departments/all")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
    }

}
