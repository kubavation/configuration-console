package com.durys.jakub.configurationconsole.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConfigurationServiceTest {

    @Autowired
    private ConfigurationService configurationService;

    @Test
    void shouldChangeConfiguration() throws IOException {

        assertDoesNotThrow(() -> configurationService.changeConfiguration("cm-company-management", "TEST3", "val=1234"));

    }

    @Test
    void shouldLoadContent() throws IOException {

        configurationService.changeConfiguration("cm-company-management", "TEST1", "val=123");

        String content = configurationService.loadConfiguration("test123", "TEST1");

        assertEquals("val=123", content);
    }
}