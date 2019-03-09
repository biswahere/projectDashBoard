package com.techprimers.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techprimers.stock.model.ProjectTask;

@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask,Long>{

}
