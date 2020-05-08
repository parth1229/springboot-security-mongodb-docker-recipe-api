FROM openjdk:8-jdk-alpine
ADD build/libs/recipe-list-service.jar recipe-service.jar
EXPOSE 8082:8082
ENTRYPOINT ["java","-jar","recipe-service.jar"]