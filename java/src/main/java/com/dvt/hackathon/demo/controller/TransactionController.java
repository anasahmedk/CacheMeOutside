package com.dvt.hackathon.demo.controller;

import com.dvt.hackathon.demo.api.Transaction;
import com.investec.hackathon.demo.api.GetTransactions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final RestTemplate restTemplate;

    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        String apiURL = "https://plankton-app-zkjow.ondigitalocean.app/za/pb/v1/accounts/4675778129910189600000003/transactions";
        var transactions = restTemplate.getForEntity(apiURL, GetTransactions.class).getBody().getData().getTransactions();
        return transactions.stream().map(transaction -> {
            final var transactionDto = new Transaction();
            transactionDto.setDescription(transaction.getDescription());
            transactionDto.setAmount(transaction.getAmount());
            return transactionDto;
        }).collect(Collectors.toList());
    }
}
