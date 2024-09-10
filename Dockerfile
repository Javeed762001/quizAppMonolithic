FROM openjdk:17

VOLUME /tmp

COPY target/quizapp_docker.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "quizapp_docker.jar"]
