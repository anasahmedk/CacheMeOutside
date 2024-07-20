package com.dvt.hackathon.demo.service;

import com.dvt.hackathon.demo.PointRepository;
import com.dvt.hackathon.demo.api.PointBalance;
import com.dvt.hackathon.demo.mapper.PointMapper;
import com.dvt.hackathon.demo.model.PointBalanceEntity;
import com.dvt.hackathon.demo.model.PointsBalanceDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository pointRepository;
    private final PointMapper pointMapper;

    public PointBalance getById(final Long pointId) {
        PointBalanceEntity pointBalanceEntity = pointRepository.findById(pointId)
                .orElseThrow(() -> new RuntimeException("Point with id " + pointId + " not found"));
        PointsBalanceDomain pointsBalanceDomain = pointMapper.mapEntityToDomain(pointBalanceEntity);
        return pointMapper.mapDomainToDto(pointsBalanceDomain);

    }

    public PointBalance update(final Long pointId, final PointBalance pointBalance) {
        PointBalanceEntity existingPointEntity  = pointRepository.findById(pointId)
                .orElseThrow(() -> new RuntimeException("Point with id " + pointId + " not found"));
        PointsBalanceDomain pointsBalanceDomain = pointMapper.mapDtoToDomain(pointBalance);
        existingPointEntity.setAmount(pointBalance.getAmount());

        PointBalanceEntity updatedPointEntity = pointRepository.save(existingPointEntity);
        PointsBalanceDomain updatedPointDomain = pointMapper.mapEntityToDomain(updatedPointEntity);
        return pointMapper.mapDomainToDto(updatedPointDomain);
    }
}