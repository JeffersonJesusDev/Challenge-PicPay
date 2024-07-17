package br.com.desafiopicpay.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class AppCondfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
