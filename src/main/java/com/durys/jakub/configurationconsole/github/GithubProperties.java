package com.durys.jakub.configurationconsole.github;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("git")
class GithubProperties {

    private String username;
    private String password;
    private String repository;
    private String token;
    private String masterBranchName;

    GithubProperties(String username, String password, String repository, String token, String masterBranchName) {
        this.username = username;
        this.password = password;
        this.repository = repository;
        this.token = token;
        this.masterBranchName = masterBranchName;
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

    String token() {
        return token;
    }

    String masterBranchName() {
        return masterBranchName;
    }
}
