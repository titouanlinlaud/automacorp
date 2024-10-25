package com.emse.automacorp.dao;

import com.emse.automacorp.model.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDao extends JpaRepository<SensorEntity, Long> {

}