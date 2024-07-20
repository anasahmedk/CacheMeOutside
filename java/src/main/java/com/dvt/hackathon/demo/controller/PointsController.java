package com.dvt.hackathon.demo.controller;

import com.dvt.hackathon.demo.api.PointBalance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PointsController {

    @GetMapping("members/{id}/points")
    public PointBalance getPoints(@PathVariable("id") final String id) {
        return new PointBalance().amount(100L);
    }

    @PutMapping("members/{id}/points")
    public PointBalance updateBalances(@PathVariable("id") final String id, @RequestBody final PointBalance pointBalance) {
        return pointBalance;
    }
}
