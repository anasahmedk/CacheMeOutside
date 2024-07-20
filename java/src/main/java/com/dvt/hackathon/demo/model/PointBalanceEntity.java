package com.dvt.hackathon.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "points")
public class PointBalanceEntity {

    @Id
    @GeneratedValue
    private Long pointId;

    @Column(name = "accountId")
    private Double amount;

}
