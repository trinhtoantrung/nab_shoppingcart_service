package com.nab.assignment.shoppingcart.config.resttemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RestTemplateLogInterceptor implements ClientHttpRequestInterceptor {
    private final Logger log = LoggerFactory.getLogger(RestTemplateLogInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        log.debug(" --- REST TEMPLATE REQUEST ---");

        log.debug("METHOD: {}", request.getMethod());
        log.debug("URI: {}", request.getURI());
        log.debug("HEADERS: {}", request.getHeaders());

        log.debug(" -----------------------------");

        ClientHttpResponse response = execution.execute(request, body);
        return response;
    }
}
