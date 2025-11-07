package com.example.bitcoin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@RestController
public class BitcoinController {
    private static final String URL_API = "https://api.coindesk.com/v1/bpi/currentprice.json";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/cotacao")
    public ResponseEntity<String> getValorBitcoin() {
        try {
            String url = "https://api.coinbase.com/v2/prices/spot?currency=USD";
            String response = restTemplate.getForObject(url, String.class);
            return ResponseEntity.ok(response);
        }
        catch (ResourceAccessException e)
        {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("Não foi possível acessar a API externa: " + e.getMessage());
        }
    }
}

