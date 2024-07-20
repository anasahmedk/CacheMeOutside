package com.dvt.hackathon.demo.controller;

import com.dvt.hackathon.demo.model.InvestecTransaction;
import com.dvt.hackathon.demo.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionMappingService {

    public Transaction mapToTransaction(InvestecTransaction investecTransaction) {
        Transaction transaction = new Transaction();
        transaction.setDescription(investecTransaction.getDescription());
        transaction.setAmount((int) investecTransaction.getAmount());
        transaction.setScored(false);
        return transaction;
    }
}