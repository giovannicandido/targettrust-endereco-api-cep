FROM amazoncorretto:17

ENV PORT = "8080"

RUN mkdir /app

RUN mkdir /build

COPY . /build

RUN cd /build && chmod +x ./mvnw && ./mvnw package && cp ./target/endereco-api-cep-0.0.1-SNAPSHOT.jar /app

RUN rm -r /build

CMD ["sh", "-c", "java -jar /app/endereco-api-cep-0.0.1-SNAPSHOT.jar --server.port=${PORT}"]
