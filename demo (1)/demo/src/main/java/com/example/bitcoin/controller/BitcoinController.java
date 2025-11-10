package com.example.bitcoin.controller;

import com.example.bitcoin.model.BitcoinResponse;
import com.example.bitcoin.service.BitcoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BitcoinController
{

    @Autowired
    private BitcoinService bitcoinService;

    @GetMapping("/cotacao")
    public ResponseEntity<?> getCotacao()
    {
        try
        {
            BitcoinResponse resposta = bitcoinService.obterCotacao();
            return ResponseEntity.ok(resposta);
        }
        catch ( RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(e.getMessage());
        }
    }
}
