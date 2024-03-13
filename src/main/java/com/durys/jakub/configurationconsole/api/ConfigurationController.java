package com.durys.jakub.configurationconsole.api;

import com.durys.jakub.configurationconsole.configuration.ConfigurationService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
class ConfigurationController {

    private final ConfigurationService configurationService;

    ConfigurationController(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @GetMapping("/configuration/{client}/{subsystem}")
    Configuration loadConfiguration(@PathVariable String subsystem, @PathVariable String client) throws IOException {
        return new Configuration(configurationService.loadConfiguration(subsystem, client));
    }

    @PutMapping("/configuration/{client}/{subsystem}")
    void changeConfiguration(@PathVariable String subsystem, @PathVariable String client,
                             @RequestBody Configuration configuration) throws IOException {
        configurationService.changeConfiguration(subsystem, client, configuration.getValue());
    }

}
