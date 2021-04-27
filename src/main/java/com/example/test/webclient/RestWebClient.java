package com.example.test.webclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.netty.http.client.HttpClient;

/**
 * The type Rest web client.
 */
@Configuration
public class RestWebClient {


  /**
   * Web client web client.
   *
   * @return the web client
   */
  @Bean
  WebClient webClient() {
    final DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory();
    factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
    final HttpClient httpClient = HttpClient.create();
    final ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);
    httpClient.warmup().block();
    return WebClient.builder()
      .clientConnector(connector)
      .uriBuilderFactory(factory)
      .build();
  }

}
