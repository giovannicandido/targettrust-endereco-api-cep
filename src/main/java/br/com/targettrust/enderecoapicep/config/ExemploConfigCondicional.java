package br.com.targettrust.enderecoapicep.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExemploConfigCondicional {

    @Bean
    @ConditionalOnProperty(name = "app.banco", havingValue = "bradesco")
    public BradescoApiImpl bradescoApi() {
        return new BradescoApiImpl();
    }

    @Bean
    @ConditionalOnProperty(name = "app.banco", havingValue = "itau")
    public ItauApiImpl itauApi() {
        return new ItauApiImpl();
    }
}
