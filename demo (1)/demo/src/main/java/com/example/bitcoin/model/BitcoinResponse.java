package com.example.bitcoin.model;

import lombok.Data;

import java.util.Map;

@Data
public class BitcoinResponse
{
        private Time time;
        private Map<String, Currency> bpi;

        @Data
        public static class Time
        {
            private String updated;
        }




}

