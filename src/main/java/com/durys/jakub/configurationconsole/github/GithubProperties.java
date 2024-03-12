package com.durys.jakub.configurationconsole.github;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("git")
public class GithubProperties {

    private String username;
    private String password;
    private String repository;

    GithubProperties(String username, String password, String repository) {
        this.username = username;
        this.password = password;
        this.repository = repository;
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public String repository() {
        return repository;
    }
}
