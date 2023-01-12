FROM java:8-jre-alpine
VOLUME /tmp
LABEL com.jadevirek="medicaltest-service"
LABEL description="Image for medicaltest-service."
COPY target/medicaltest-service-0.0.1-SNAPSHOT.jar medicaltest-service-0.0.1-SNAPSHOT.jar
EXPOSE 8000

ENTRYPOINT ["java", "-jar", "/medicaltest-service-0.0.1-SNAPSHOT.jar"]