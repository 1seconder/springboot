package com.siteview.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
//(scanBasePackages = { "com.siteview.springboot.mapper" })
public class Applciation {

  public static void main(String[] args) {
    SpringApplication.run(Applciation.class, args);
  }
}
