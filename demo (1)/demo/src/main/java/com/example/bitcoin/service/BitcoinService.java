package com.example.bitcoin.service;

import com.example.bitcoin.model.BitcoinResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class BitcoinService
{
    private static final String URL_API = "https://api.coindesk.com/v1/bpi/currentprice.json";

    @Autowired
    private RestTemplate restTemplate;

    public BitcoinResponse obterCotacao() {
        try
        {
            // Chamada à API externa
            BitcoinResponse resposta = restTemplate.getForObject(URL_API, BitcoinResponse.class);
            return resposta;
        }
        catch (ResourceAccessException e)
        {
            // Erro de conexão com a API
            throw new RuntimeException("Não foi possível acessar a API externa: " + e.getMessage());
        }
        catch (Exception e)
        {
            // Qualquer outro erro
            throw new RuntimeException("Erro inesperado ao buscar cotação: " + e.getMessage());
        }
    }
}


