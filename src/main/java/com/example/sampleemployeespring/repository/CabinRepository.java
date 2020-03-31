package com.example.sampleemployeespring.repository;

import com.example.sampleemployeespring.beans.Cabin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CabinRepository extends JpaRepository<Cabin, Integer> {
    List<Cabin> findByFloorNo(Integer floorNo);
}
