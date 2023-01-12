FROM java:8-jre-alpine
VOLUME /tmp
LABEL com.jadevirek="patient-service"
LABEL description="Image for patient-service."
COPY target/patient-service-0.0.1-SNAPSHOT.jar patient-service-0.0.1-SNAPSHOT.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/patient-service-0.0.1-SNAPSHOT.jar"]