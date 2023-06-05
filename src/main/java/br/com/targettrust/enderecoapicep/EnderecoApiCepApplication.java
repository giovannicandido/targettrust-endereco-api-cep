package br.com.targettrust.enderecoapicep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EnderecoApiCepApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnderecoApiCepApplication.class, args);
    }

}
