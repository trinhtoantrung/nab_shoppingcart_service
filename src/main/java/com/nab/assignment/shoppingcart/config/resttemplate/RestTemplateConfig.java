package com.nab.assignment.shoppingcart.config.resttemplate;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestTemplateConfig {

    private final RestTemplateLogInterceptor restTemplateLogInterceptor;

    public RestTemplateConfig(RestTemplateLogInterceptor restTemplateLogInterceptor) {
        this.restTemplateLogInterceptor = restTemplateLogInterceptor;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();;
        interceptors.add(restTemplateLogInterceptor);

        return builder.setConnectTimeout(Duration.ofMillis(30000))
                .setReadTimeout(Duration.ofMillis(30000))
                .errorHandler(new RestTemplateResponseErrorHandler())
                .interceptors(interceptors)
                .build();
    }
}
