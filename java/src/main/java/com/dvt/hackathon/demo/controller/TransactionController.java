package com.dvt.hackathon.demo.controller;

import com.dvt.hackathon.demo.model.Transaction;
import com.investec.hackathon.demo.api.GetTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping
public class TransactionController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TransactionMappingService transactionMappingService;

    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        String apiURL = "https://plankton-app-zkjow.ondigitalocean.app/za/pb/v1/accounts/4675778129910189600000003/transactions";
        var response = restTemplate.getForEntity(apiURL, GetTransactions.class).getBody().getData();
        return new List.of(new Transaction().setDescription());
    }
}
