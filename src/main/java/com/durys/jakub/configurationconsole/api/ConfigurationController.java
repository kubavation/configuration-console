package com.durys.jakub.configurationconsole.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
class ConfigurationController {

    @PutMapping("/configuration/{client}/{subsystem}")
    void changeConfiguration(@PathVariable String subsystem, @PathVariable String client,
                             @RequestBody Configuration configuration) {

        //todo
    }

}
