FROM maven:3.9.6-amazoncorretto-21 AS BUILD

WORKDIR build/
COPY pom.xml /build/pom.xml
RUN mvn dependency:resolve dependency:resolve-plugins

COPY src/ /build/src/
RUN mvn clean package
RUN mv target/expense.tracker-*.jar target/expense.tracker.jar

FROM amazoncorretto:21 as APP
COPY --from=BUILD /build/target/expense.tracker.jar /app/
WORKDIR /app/
EXPOSE 8080

CMD ["java", "-jar", "expense.tracker.jar"]
