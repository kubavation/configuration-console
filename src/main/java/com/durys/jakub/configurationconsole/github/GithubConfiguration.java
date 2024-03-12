package com.durys.jakub.configurationconsole.github;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
class GithubConfiguration {

    @Bean
    GitHub client(GithubProperties properties) throws IOException {
        return new GitHubBuilder().withPassword(properties.username(), properties.password()).build();
    }

    @Bean
    GHRepository repository(GithubProperties properties, GitHub client) throws IOException {
        return client.getRepository(properties.repository());
    }


}
