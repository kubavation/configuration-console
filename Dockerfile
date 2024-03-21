FROM openjdk:21

MAINTAINER jdurys

COPY target/configuration-console*.jar configuration-console.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar", "configuration-console.jar"]