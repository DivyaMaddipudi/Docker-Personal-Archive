FROM openjdk:8
EXPOSE 8087
ADD target/rest-mysql.jar rest-mysql.jar
ENTRYPOINT ["java", "-jar", "rest-mysql.jar"]