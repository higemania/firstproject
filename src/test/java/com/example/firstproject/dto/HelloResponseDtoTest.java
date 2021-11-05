package com.example.firstproject.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        String name = "test";
        int amount = 1000;

        HelloResponseDto res = new HelloResponseDto(name, amount);
        assertThat(res.getName()).isEqualTo(name);
        assertThat(res.getAmount()).isEqualTo(amount);
    }
}
