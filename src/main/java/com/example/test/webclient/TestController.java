package com.example.test.webclient;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@Slf4j
public class TestController {

  @Autowired
  WebClient webClient;

  @GetMapping("/test")
  public String test(){
    log.info("getting data...");
    val response =   webClient.get()
      .uri("https://google.ca")
      .retrieve()
      .bodyToMono(String.class)
      .block();
    log.info("got response");
    return response;
  }
}
