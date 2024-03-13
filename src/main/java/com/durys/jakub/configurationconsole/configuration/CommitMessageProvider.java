package com.durys.jakub.configurationconsole.configuration;

import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
class CommitMessageProvider {

    String commitMessage() {
        return "%s%s".formatted("todo-operator", Instant.now().toString());
    }
}
