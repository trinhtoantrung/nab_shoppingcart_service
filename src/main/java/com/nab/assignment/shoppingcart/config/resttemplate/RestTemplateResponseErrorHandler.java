package com.nab.assignment.shoppingcart.config.resttemplate;

import com.nab.assignment.shoppingcart.dto.response.ErrorDTO;
import com.nab.assignment.shoppingcart.util.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {
    private static final Logger log = LoggerFactory.getLogger(RestTemplateResponseErrorHandler.class);

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (response.getStatusCode().series() == CLIENT_ERROR
                || response.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().series() == SERVER_ERROR
                || response.getStatusCode().series() == CLIENT_ERROR) {
            String errorBody = StreamUtils.copyToString(response.getBody(), Charset.defaultCharset());
            ErrorDTO error = GsonUtils.fromJson(errorBody, ErrorDTO.class);

            log.error(GsonUtils.toJsonPretty(error));
            throw new ResponseStatusException(response.getStatusCode(), error.getMessage());
        }
    }
}
