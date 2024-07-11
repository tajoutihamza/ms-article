package com.ms.article.service;

import com.ms.article.dto.StockDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockService {


    private final RestTemplate restTemplate;

    public StockService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String STOCK_SERVICE_URL = "http://localhost:8080/stocks/";

    public StockDto getStockById(String id) {
        return restTemplate.getForObject(STOCK_SERVICE_URL + id, StockDto.class);
    }
}
