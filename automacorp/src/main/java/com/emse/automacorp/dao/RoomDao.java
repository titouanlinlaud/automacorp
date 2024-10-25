package com.emse.automacorp.dao;

import com.emse.automacorp.model.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomDao extends JpaRepository<RoomEntity, Long> {
    // Example custom queries:
    List<RoomEntity> findByName(String name);         // Find rooms by name
    List<RoomEntity> findByFloor(Integer floor);      // Find rooms by floor
    void getById(long number);
}
