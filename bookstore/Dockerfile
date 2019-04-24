FROM maven:3.6.0-jdk-8-alpine
COPY . /code
WORKDIR /code
RUN mvn clean package
CMD java -jar target/gs-rest-service-0.1.0.jar --server.port=5000
