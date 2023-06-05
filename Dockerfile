FROM amazoncorretto:17

ENV PORT = "8080"

RUN mkdir /app

COPY ./target/endereco-api-cep-0.0.1-SNAPSHOT.jar /app

CMD ["sh", "-c", "java -jar /app/endereco-api-cep-0.0.1-SNAPSHOT.jar --server.port=${PORT}"]
