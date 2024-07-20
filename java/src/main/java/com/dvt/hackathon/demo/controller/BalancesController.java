package com.dvt.hackathon.demo.controller;

import com.dvt.hackathon.demo.api.Balance;
import com.investec.hackathon.demo.api.GetAccountBalance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BalancesController {

    private final RestTemplate restTemplate;
    @GetMapping("members/{id}/balances")
    public Balance getBalances(@PathVariable("id") final String id) {
        var apiURL = "https://plankton-app-zkjow.ondigitalocean.app/za/pb/v1/accounts/4675778129910189600000003/balance";
        var accountBalance = restTemplate.getForEntity(apiURL, GetAccountBalance.class).getBody().getData();
        return new Balance().amount(accountBalance.getAvailableBalance());
    }
}
