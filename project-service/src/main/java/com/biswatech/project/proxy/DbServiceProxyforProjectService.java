package com.biswatech.project.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.biswatech.project.model.Project;



@FeignClient(name="DB-SERVICE", url="localhost:8300")
public interface DbServiceProxyforProjectService {
	
	@PostMapping("/api/project/create")
	public ResponseEntity<Project> createNewProject(@RequestBody Project project);
	
	

	@GetMapping("/api/project/fetchProject/{id}")
	public Project fetchProject( @PathVariable String id);
	
	@GetMapping("/api/project/fetchProjectList")
	public List<Project> getAllProjects();
	
	@DeleteMapping("/api/project/{id}")
	public void deleteProject(@PathVariable Long id);
	
	

}
