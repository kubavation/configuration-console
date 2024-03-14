package com.durys.jakub.configurationconsole.github;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("git")
class GithubProperties {

    private final String repository;
    private final String token;
    private final String masterBranchName;

    GithubProperties( String repository, String token, String masterBranchName) {
        this.repository = repository;
        this.token = token;
        this.masterBranchName = masterBranchName;
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
