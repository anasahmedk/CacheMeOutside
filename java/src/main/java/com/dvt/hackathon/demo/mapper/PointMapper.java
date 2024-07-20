package com.dvt.hackathon.demo.mapper;

import com.dvt.hackathon.demo.api.PointBalance;
import com.dvt.hackathon.demo.model.PointBalanceEntity;
import com.dvt.hackathon.demo.model.PointsBalanceDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PointMapper {

    PointsBalanceDomain mapDtoToDomain(PointBalance pointBalance);

    PointBalance mapDomainToDto(PointsBalanceDomain pointsBalanceDomain);

    PointBalanceEntity mapDomainToEntity(PointsBalanceDomain pointsBalanceDomain);

    PointsBalanceDomain mapEntityToDomain(PointBalanceEntity pointBalanceEntity);