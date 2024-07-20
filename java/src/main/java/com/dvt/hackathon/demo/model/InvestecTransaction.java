package com.dvt.hackathon.demo.model;

import lombok.Data;

@Data
public class InvestecTransaction {
    private String accountId;
    private String type;
    private String transactionType;
    private String status;
    private String description;
    private String cardNumber;
    private int postedOrder;
    private String postingDate;
    private String valueDate;
    private String actionDate;
    private String transactionDate;
    private double amount;
    private double runningBalance;
}
