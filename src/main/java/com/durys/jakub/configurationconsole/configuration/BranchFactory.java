package com.durys.jakub.configurationconsole.configuration;

import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GHRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
@Slf4j
class BranchFactory {

    private final GHRepository repository;
    private final String masterBranchName;

    private static final String REF_URI = "refs/heads/";

    BranchFactory(GHRepository repository, @Value("${git.master-branch-name}") String masterBranchName) {
        this.repository = repository;
        this.masterBranchName = masterBranchName;
    }

    String retrieveClientBranchName(String client) {

        log.info("retrieveClientBranchName | retrieving client branch name [client: {}]", client);

        if (Objects.isNull(client)) {
            log.info("retrieveClientBranchName | client is empty, returning master branch [branch: {}]", masterBranchName);
            return masterBranchName;
        }

        String clientBranchName = getClientBranchName(client);

        if (Objects.nonNull(clientBranchName)) {
            log.info("retrieveClientBranchName | client branch retrieved [branch: {}]", clientBranchName);
            return clientBranchName;
        }

        try {
            String branch = repository.createRef("%s%s".formatted(REF_URI, client), masterBranchId()).getRef();

            log.info("retrieveClientBranchName | client branch created [branch: {}]", branch);

            return branch;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String getClientBranchName(String client) {
        try {
            return "%s%s".formatted(REF_URI, repository.getBranch(client).getName());
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
