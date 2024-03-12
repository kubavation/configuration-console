package com.durys.jakub.configurationconsole.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
class ConfigurationController {

    @PutMapping("/configuration/{subsystem}/{property}")
    void changeConfiguration(@PathVariable String subsystem, @PathVariable String property,
                             @RequestParam(required = false) String client, @RequestBody Configuration configuration) {

        //todo
    }

}
