package com.techprimers.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techprimers.stock.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	
	@Override
	List<Project> findAllById(Iterable<Long> iterable);
	
	Project findByProjectIdentifier(String projectId);
	

}
