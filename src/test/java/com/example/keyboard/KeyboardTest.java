package com.example.keyboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class KeyboardTest {

    @Autowired
    private KeyboardService keyboardService;

    @Test
    void contextLoads() {
        Random random = new Random();
        int a = random.nextInt(100);
        keyboardService.getResult(a);
    }
}
