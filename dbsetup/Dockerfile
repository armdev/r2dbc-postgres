FROM openjdk:10-jdk
COPY target/dbsetup.jar /opt/dbsetup.jar
ENTRYPOINT ["java", "-Djava.net.preferIPv4Stack=true", "-jar","/opt/dbsetup.jar"]
EXPOSE 8585

