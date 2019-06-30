package com.techprimers.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techprimers.stock.model.Project;
import com.techprimers.stock.repository.ProjectRepository;

import exceptions.ProjectIdException;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdate(Project project) {
		
		//Logic
	
		return projectRepository.save(project);
	}

	
	public Project findById(String id) {
	
		Project project = projectRepository.findByProjectIdentifier(id);
		System.out.println(project);
		if(project == null){
            throw new ProjectIdException("Project ID '"+id+"' does not exist");

        }
		return project;
	}
	
	public List<Project> findAllProjects() {
		
		return projectRepository.findAll();
	}

	public void deleteProject(Long id) {
		
		Project project = this.projectRepository.getOne(id);
		
		/*if (project == null) {
			 throw new ProjectIdExcepion();
		}*/
		projectRepository.delete(project);
		
		
	}

}
