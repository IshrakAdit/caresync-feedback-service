package com.caresync.service.feedback.clients;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class AuthClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String AUTH_SERVICE_BASE_URL = "http://auth-service:8081/user/v1";

    public boolean isAdmin(String userId) {
        String url = AUTH_SERVICE_BASE_URL + "/verify-admin/" + userId;

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            return false;
        }
    }
}
