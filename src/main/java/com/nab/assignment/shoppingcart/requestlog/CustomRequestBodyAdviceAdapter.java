package com.nab.assignment.shoppingcart.requestlog;

import com.nab.assignment.shoppingcart.constant.ApplicationConstants;
import com.nab.assignment.shoppingcart.service.RequestLogService;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;
import java.util.UUID;

/*
* Logging requests (POST, PUT, PATCH, DELETE …)
* */

@ControllerAdvice
public class CustomRequestBodyAdviceAdapter extends RequestBodyAdviceAdapter {

    private final RequestLogService requestLogService;
    private final HttpServletRequest httpServletRequest;

    public CustomRequestBodyAdviceAdapter(RequestLogService requestLogService, HttpServletRequest httpServletRequest) {
        this.requestLogService = requestLogService;
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        String requestId = UUID.randomUUID().toString();
        httpServletRequest.setAttribute(ApplicationConstants.REQUEST_ID, requestId);
        requestLogService.logRequest(httpServletRequest, body);

        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }
}
