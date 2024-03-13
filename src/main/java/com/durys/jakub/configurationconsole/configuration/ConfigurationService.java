package com.durys.jakub.configurationconsole.configuration;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConfigurationService {

    private final BranchFactory branchFactory;
    private final ContentFactory contentFactory;

    ConfigurationService(BranchFactory branchFactory, ContentFactory contentFactory) {
        this.branchFactory = branchFactory;
        this.contentFactory = contentFactory;
    }

    public void changeConfiguration(String subsystem, String client, String content) throws IOException {

        String branchName = branchFactory.retrieveClientBranchName(client);

        contentFactory.savePropertiesContent(branchName, content);

    }

}
