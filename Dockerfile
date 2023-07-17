FROM gradle:8.1.1-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle
WORKDIR /home/gradle
ENV JAVA_OPTS="-Xmx2g -XX:MaxMetaspaceSize=512m -XX:+HeapDumpOnOutOfMemoryError -Dfile.encoding=UTF-8"
RUN gradle build -x check -x test --no-daemon

FROM eclipse-temurin:17-jre-alpine

RUN mkdir /home/nobody
WORKDIR /home/nobody

COPY --from=build /home/gradle/build/libs/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","/app.jar"]
