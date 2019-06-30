package com.biswatech.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswatech.project.model.Project;
import com.biswatech.project.proxy.DbServiceProxyforProjectService;
import com.biswatech.project.service.MapValidationErrorService;

@RestController
@RequestMapping("/rest/project")
@CrossOrigin
public class ProjectController {
	
	@Autowired
	private DbServiceProxyforProjectService dbServiceProxyforProjectService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("/createProject")
	public ResponseEntity<?> saveorUpdate( @Valid @RequestBody Project project, BindingResult result) {
		
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationErrorService(result);
		if(errorMap != null) return errorMap;
		System.out.println("jhhgfgfgcfgcfgcvg ");
	
		return this.dbServiceProxyforProjectService.createNewProject(project);
		
	}
	
	@GetMapping("/project/{id}")
	public Project findProjectById(@PathVariable String id){
		
		return dbServiceProxyforProjectService.fetchProject(id);
		
	}
	
	@GetMapping("/projectList")
	public List<Project> findAllProjects(){
		
		return dbServiceProxyforProjectService.getAllProjects();
		
	}
	
	@DeleteMapping("/deleteProject/{id}")
	public void deleteProject(@PathVariable Long id){
		
	 this.dbServiceProxyforProjectService.deleteProject(id);
	

	}

}
