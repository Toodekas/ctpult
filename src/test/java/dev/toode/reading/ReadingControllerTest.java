package dev.toode.reading;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ReadingController.class)
class ReadingControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReadingService readingService;

    @Test
    void getReadings() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/readings");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("[]", result.getResponse().getContentAsString());
    }
    @Test
    void addReading() throws Exception {
        Reading reading = new Reading(1, 10000000L, 50);
        mvc.perform( MockMvcRequestBuilders
                .post("/api/reading")
                .content(asJsonString(reading))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    void add10Readings() throws Exception {
        List<Reading> readings = Arrays.asList(
                new Reading(1, 11000000L, 50),
                new Reading(1, 10100000L, 50),
                new Reading(1, 10010000L, 50),
                new Reading(1, 10000100L, 50),
                new Reading(1, 10000010L, 50),
                new Reading(1, 10110000L, 50),
                new Reading(1, 10010000L, 50),
                new Reading(1, 10100000L, 50),
                new Reading(1, 10100000L, 50),
                new Reading(1, 11000000L, 50));
        mvc.perform( MockMvcRequestBuilders
                .post("/api/reading10")
                .content(asJsonString(readings))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
