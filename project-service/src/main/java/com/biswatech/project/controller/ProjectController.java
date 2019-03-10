package com.biswatech.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswatech.project.model.Project;
import com.biswatech.project.proxy.DbServiceProxyforProjectService;

@RestController
@RequestMapping("/rest/project")
public class ProjectController {
	
	@Autowired
	private DbServiceProxyforProjectService dbServiceProxyforProjectService;
	
	@PostMapping("/createProject")
	
	public ResponseEntity<Project> saveorUpdate(@RequestBody Project project) {
		
		return this.dbServiceProxyforProjectService.createNewProject(project);
		
	}

}
