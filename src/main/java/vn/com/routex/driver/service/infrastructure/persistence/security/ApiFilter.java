package com.smart.pay.transaction.service.infrastructure.persistence.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.pay.transaction.service.application.RequestAttributes;
import com.smart.pay.transaction.service.interfaces.model.request.ApiRequest;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class ApiFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if(requestURI.startsWith("/actuator/")) {
            filterChain.doFilter(request, response);
            return;
        }
        try {
            CachedHttpServletRequestWrapper cachedHttpServletRequestWrapper = new CachedHttpServletRequestWrapper(request);
            String jsonStringBody = new String(cachedHttpServletRequestWrapper.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            ApiRequest apiRequest = objectMapper.readValue(jsonStringBody, ApiRequest.class);
            request.setAttribute(RequestAttributes.REQUEST_ID, apiRequest.getRequestId());
            request.setAttribute(RequestAttributes.REQUEST_DATE_TIME, apiRequest.getRequestDateTime());
            request.setAttribute(RequestAttributes.CHANNEL, apiRequest.getChannel());
            filterChain.doFilter(cachedHttpServletRequestWrapper, response);
        } catch(Exception e) {
            log.error(e.getLocalizedMessage());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Invalid Request");
            response.getWriter().flush();
        }
    }
}
