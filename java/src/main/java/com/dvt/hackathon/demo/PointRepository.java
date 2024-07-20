package com.dvt.hackathon.demo;

import com.dvt.hackathon.demo.model.PointBalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<PointBalanceEntity, Long> {
}
