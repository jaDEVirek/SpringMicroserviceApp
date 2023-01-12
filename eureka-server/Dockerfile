FROM java:8-jre-alpine
VOLUME /tmp
LABEL com.jadevirek="eureka-server"
LABEL description="Image for eureka-server."
COPY target/eureka-server-0.0.1-SNAPSHOT.jar eureka-server-0.0.1-SNAPSHOT.jar
EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/eureka-server-0.0.1-SNAPSHOT.jar"]