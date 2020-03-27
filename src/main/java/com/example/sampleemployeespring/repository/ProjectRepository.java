package com.example.sampleemployeespring.repository;

import com.example.sampleemployeespring.pojo.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository  extends JpaRepository<Project, Integer> {
}
