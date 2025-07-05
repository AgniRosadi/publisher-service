package com.example.publisher_service.service;

import com.api.common.dto.PrefixDataReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class PrefixPublishService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.subscriber-service}")
    String urlSubscriber;

    public void publishAdd(PrefixDataReq req) {
        String url = urlSubscriber + "/prefix/save";
        postToSubscriber(url, req);
    }

    public void publishUpdate(PrefixDataReq req) {
        String url = urlSubscriber + "/prefix/update";
        postToSubscriber(url, req);
    }

    private void postToSubscriber(String url, Object body) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Object> entity = new HttpEntity<>(body, headers);
            restTemplate.postForEntity(url, entity, String.class);
            log.info("Published to Subscriber: {}", url);
        } catch (Exception e) {
            log.error("Failed to publish to Subscriber", e);
            throw new RuntimeException("Publish to Subscriber failed");
        }
    }
}
