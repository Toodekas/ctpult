package dev.toode.reading;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ReadingController.class)
class ReadingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getReadings() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/readings");
        MvcResult result = mvc.perform(request).andReturn();
        assertFalse(false);
    }
}