package com.example.consumingwebservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigInteger;

import com.example.consumingwebservice.wsdl.NumberToWordsResponse;

@SpringBootApplication
public class ConsumingWebServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumingWebServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(Client quoteClient) {
      return args -> {
        BigInteger num = BigInteger.valueOf(1);
        NumberToWordsResponse response = quoteClient.getNumberToWord(num);
        System.err.println(response.getNumberToWordsResult());
      };
    }
}
