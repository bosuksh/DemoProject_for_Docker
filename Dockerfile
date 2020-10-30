FROM java:8-jdk-alpine

COPY ./build/libs/demo-0.0.1.jar /usr/app/

ENTRYPOINT ["java","-jar","usr/app/demo-0.0.1.jar"]
