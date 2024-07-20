package com.dvt.hackathon.demo.controller;

import com.investec.hackathon.demo.api.GetTransactions;
import com.investec.hackathon.demo.api.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class TransactionController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/transactions")
    public GetTransactions getTransaction() {
        String apiURL = "https://plankton-app-zkjow.ondigitalocean.app/za/pb/v1/accounts/4675778129910189600000003/transactions";
        ResponseEntity<GetTransactions> response = restTemplate.getForEntity(apiURL, GetTransactions.class);
        return response.getBody();
    }

}
