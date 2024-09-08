package com.ksoot.poc;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class KsootPocApplication {

  public static void main(String[] args) {
    SpringApplication.run(KsootPocApplication.class, args);
  }
}
