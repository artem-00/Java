package com.example.gps.data;

import com.example.gps.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GpsData {

    @Value("${ipinfo.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public GpsData(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

public Location getLocationByIp(String ip) {
    // Безопасное построение URL с использованием UriComponentsBuilder
    String url = UriComponentsBuilder.fromUriString(apiUrl)
                                      .pathSegment(ip)
                                      .toUriString();

    // Отправляем запрос и получаем ответ от сервиса
    return restTemplate.getForObject(url, Location.class);
}
}
