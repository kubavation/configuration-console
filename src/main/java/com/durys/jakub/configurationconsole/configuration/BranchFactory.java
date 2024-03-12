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

    private static final String REF_URI = "refs/heads/";

    BranchFactory(GHRepository repository, @Value("${git.master-branch-name}") String masterBranchName) {
        this.repository = repository;
        this.masterBranchName = masterBranchName;
    }

    String retrieveClientBranchName(String client) {

        if (Objects.isNull(client)) {
            return masterBranchName;
        }

        String clientBranchName = getClientBranchName(client);

        if (Objects.nonNull(clientBranchName)) {
            return clientBranchName;
        }

        try {
            return repository.createRef("%s%s".formatted(REF_URI, client), masterBranchId())
                    .getRef().replace(REF_URI, "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String getClientBranchName(String client) {
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
