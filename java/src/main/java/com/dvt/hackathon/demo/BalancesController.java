package com.dvt.hackathon.demo;

import com.dvt.hackathon.demo.api.Balance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalancesController {

    @GetMapping("members/{id}/balances")
    public Balance getBalances(@PathVariable("id") final String id) {
        return new Balance().amount((int) 100.00);
    }
}
