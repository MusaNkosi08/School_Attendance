package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.ac.cput.controller.ScholarController;
import za.ac.cput.domain.Scholar;
import za.ac.cput.factory.ScholarFactory;
import za.ac.cput.repository.IScholarRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ScholarController.class)
public class ScholarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IScholarRepository scholarRepository;

    private Scholar testScholar;

    @BeforeEach
    void setUp() {
        testScholar = ScholarFactory.createScholar(
                "8294757482928",
                "Musa",
                "Nkosi",
                "Grade 12",
                "musa@gmail.com",
                null
        );
    }

    @Test
    void testCreateScholar() throws Exception {
        when(scholarRepository.save(any(Scholar.class))).thenReturn(testScholar);

        mockMvc.perform(post("/api/scholars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"cemisNumber\":\"8294757482928\",\"firstNames\":\"Musa\",\"lastName\":\"Nkosi\",\"grade\":\"Grade 12\",\"email\":\"musa@gmail.com\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.cemisNumber").value(testScholar.getCemisNumber()));
    }

    @Test
    void testGetScholar() throws Exception {
        when(scholarRepository.findById(testScholar.getCemisNumber()))
                .thenReturn(java.util.Optional.of(testScholar));

        mockMvc.perform(get("/api/scholars/" + testScholar.getCemisNumber()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cemisNumber").value(testScholar.getCemisNumber()));
    }

    @Test
    void testUpdateScholar() throws Exception {
        when(scholarRepository.save(any(Scholar.class))).thenReturn(testScholar);

        mockMvc.perform(put("/api/scholars/" + testScholar.getCemisNumber())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"cemisNumber\":\"8294757482928\",\"firstNames\":\"Musa\",\"lastName\":\"Nkosi\",\"grade\":\"Grade 12\",\"email\":\"musa@gmail.com\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteScholar() throws Exception {
        mockMvc.perform(delete("/api/scholars/" + testScholar.getCemisNumber()))
                .andExpect(status().isOk());
    }
}
