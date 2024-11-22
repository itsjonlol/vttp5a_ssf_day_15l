FROM openjdk:23-jdk

ARG app-dir=/app

ARG port=4000
WORKDIR ${app-dir}

COPY .mvn .mvn
COPY src src
COPY pom.xml .
COPY mvnw .
COPY mvnw.cmd .

RUN ./mvnw clean package -Dmaven.tests.skip=true

ENV SERVER_PORT 4000

EXPOSE ${SERVER_PORT}

#run app using ENTRYPOINT or CMD

ENTRYPOINT java -jar target/vttp5a_ssf_day15l-0.0.1-SNAPSHOT.jar

#ENTRYPOINT ["java", "-jar", "target/vttp5a_ssf_day15l-0.0.1-SNAPSHOT.jar"]
#host
#redis://default:ADNpEdjTWmbAHrHHRjdfRnXsYhSTLWQt@junction.proxy.rlwy.net:43200

#PORT
#6379

#USERNAME
#default


#Password
#ADNpEdjTWmbAHrHHRjdfRnXsYhSTLWQt