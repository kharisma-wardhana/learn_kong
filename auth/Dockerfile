FROM maven:3.9.0 AS maven

WORKDIR /usr/src/app
COPY . /usr/src/app

# Compile and package the application to an executable JAR
RUN mvn package -DskipTests

FROM openjdk:20-ea-19-jdk-slim

# location jar file
ARG JAR_FILE=auth-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# cp jar file to /opt/app/app.jar
COPY --from=maven /usr/src/app/target/${JAR_FILE} app.jar

# java -Duser.timezone=Asia/Jakarta -jar /opt/app/app.jar
ENTRYPOINT ["java","-Duser.timezone=Asia/Jakarta","-jar","app.jar"]
