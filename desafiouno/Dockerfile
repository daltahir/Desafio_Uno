From alpine:latest
RUN apk update && apk add openjdk8
RUN mkdir /desafiouno
WORKDIR /desafiouno
COPY target/desafiouno-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch app.jar'
ENTRYPOINT ["java","-jar","app.jar"]