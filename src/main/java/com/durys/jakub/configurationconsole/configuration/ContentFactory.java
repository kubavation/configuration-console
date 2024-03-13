package com.durys.jakub.configurationconsole.configuration;

import org.kohsuke.github.GHContent;
import org.kohsuke.github.GHRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
class ContentFactory {

    private final GHRepository repository;
    private final String propertiesFileName;
    private final CommitMessageProvider commitMessageProvider;

    ContentFactory(GHRepository repository, @Value("${properties.file}") String propertiesFileName,
                   CommitMessageProvider commitMessageProvider) {
        this.repository = repository;
        this.propertiesFileName = propertiesFileName;
        this.commitMessageProvider = commitMessageProvider;
    }

    void savePropertiesContent(String ref, String subsystem, String content) throws IOException {

        GHContent fileContent = loadPropertiesContent(ref, subsystem);

        fileContent.update(content, commitMessageProvider.commitMessage(), ref);
    }

    String loadContent(String ref, String subsystem) throws IOException {

        GHContent fileContent = loadPropertiesContent(ref, subsystem);

        return fileContent.getContent();
    }

    private GHContent loadPropertiesContent(String ref, String subsystem) throws IOException {

        if (Objects.isNull(subsystem)) {
            return repository.getFileContent(propertiesFileName, ref);
        }

        return repository.getDirectoryContent(subsystem, ref).stream()
                .filter(content -> content.getName().equals(propertiesFileName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cannot find properties file"));

    }

}
