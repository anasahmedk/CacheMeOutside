package com.dvt.hackathon.demo.controller;

import com.dvt.hackathon.demo.model.InvestecTransaction;
import lombok.Data;

import java.util.List;

@Data
public class GetTransactions {
    private List<InvestecTransaction> transactions;
}
