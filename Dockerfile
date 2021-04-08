FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/ms_address-0.0.1-SNAPSHOT.jar ms_address.jar
ENTRYPOINT ["java", "-jar", "/ms_address.jar"]