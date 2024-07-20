package com.dvt.hackathon.demo.model;

import lombok.Data;

@Data
public class Transaction {
    private String description;
    private int amount;
    private boolean scored;
}

