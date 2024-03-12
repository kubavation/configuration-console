package com.durys.jakub.configurationconsole.configuration;

import org.kohsuke.github.GHContent;
import org.kohsuke.github.GHRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
class ContentFactory {

    private final GHRepository repository;
    private final String propertiesFileName;

    ContentFactory(GHRepository repository, @Value("${properties.file}") String propertiesFileName) {
        this.repository = repository;
        this.propertiesFileName = propertiesFileName;
    }

    void savePropertiesContent(String ref, String content) throws IOException {

        GHContent fileContent = repository.getFileContent(propertiesFileName, ref);

        fileContent.update(content, "commit-123", ref);
    }

}
