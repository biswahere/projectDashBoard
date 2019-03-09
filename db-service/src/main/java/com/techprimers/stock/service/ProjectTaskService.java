package com.techprimers.stock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techprimers.stock.model.ProjectTask;
import com.techprimers.stock.repository.ProjectTaskRepository;

@Service
public class ProjectTaskService {
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask) {
		if (projectTask.getStatus() == null || projectTask.getStatus()=="" ) {
			projectTask.setStatus("TO_DO");
		}
		return projectTaskRepository.save(projectTask);
		
		
	}

	public List<ProjectTask> findAll() {
		// TODO Auto-generated method stub
		return projectTaskRepository.findAll();
	}

	public void delete(Long pt_id) {
		ProjectTask projectTask = projectTaskRepository.getOne(pt_id);
        projectTaskRepository.delete(projectTask);
		
	}

	public ProjectTask getProjectTask(Long pt_id) {
		return projectTaskRepository.getOne(pt_id);
		
	}
	
	

}
