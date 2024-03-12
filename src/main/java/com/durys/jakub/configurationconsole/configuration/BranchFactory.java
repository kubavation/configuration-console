package com.durys.jakub.configurationconsole.configuration;

import org.kohsuke.github.GHRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
class BranchFactory {

    private final GHRepository repository;
    private final String masterBranchName;

    BranchFactory(GHRepository repository, @Value("${git.master-branch-name}") String masterBranchName) {
        this.repository = repository;
        this.masterBranchName = masterBranchName;
    }

    void createClientBranch(String client) {

        String clientBranchName = retrieveClientBranchName(client);

        if (Objects.nonNull(clientBranchName)) {
            throw new RuntimeException("Client branch already exists");
        }

        try {
            repository.createRef("refs/heads/%s".formatted(client), masterBranchId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    boolean clientBranchExists(String client) {
        return Objects.nonNull(retrieveClientBranchName(client));
    }

    String retrieveClientBranchName(String client) {
        try {
            return repository.getBranch(client).getName();
        } catch (IOException e) {
            return null;
        }
    }

    private String masterBranchId() {
        try {
            return repository.getBranch(masterBranchName).getSHA1();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
