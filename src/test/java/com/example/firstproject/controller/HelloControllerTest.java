package com.example.firstproject.controller;

import com.example.firstproject.dto.HelloResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloController.class)
@DisplayName("HelloController 테스트")
public class HelloControllerTest {
    @Autowired private MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        String sUrl = "/hello";
        String sHello = "hello";
        mockMvc.perform(get(sUrl))
                .andExpect(status().isOk())
                .andExpect(content().string(sHello));
    }

    @Test
    public void helloDto_테스트() throws Exception {
        String sUrl = "/hello/dto";
        String name = "hello";
        int amount = 1000;
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        mockMvc.perform(get(sUrl).param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.amount").value(amount));
    }
}
