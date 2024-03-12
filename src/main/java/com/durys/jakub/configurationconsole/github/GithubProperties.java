package com.durys.jakub.configurationconsole.github;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("git")
class GithubProperties {

    private String username;
    private String password;
    private String repository;

    GithubProperties(String username, String password, String repository) {
        this.username = username;
        this.password = password;
        this.repository = repository;
    }

    String username() {
        return username;
    }

    String password() {
        return password;
    }

    String repository() {
        return repository;
    }
}
