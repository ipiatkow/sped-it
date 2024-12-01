FROM amazoncorretto:21.0.3-alpine
COPY target/sped-it-0.0.1-SNAPSHOT.jar /sped-it.jar
ENTRYPOINT ["java", "-jar", "/sped-it.jar"]