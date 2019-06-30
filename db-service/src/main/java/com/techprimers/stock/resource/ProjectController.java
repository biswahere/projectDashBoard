package com.techprimers.stock.resource;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.techprimers.stock.model.Project;
import com.techprimers.stock.service.ProjectService;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
		/*if (result.hasErrors()) {
			
			return new ResponseEntity<String>("Invalid Project", HttpStatus.BAD_REQUEST);
		}
		*/
		this.projectService.saveOrUpdate(project);
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchProject/{id}")
	public Project fetchProject(@PathVariable String id ) {
		
		System.out.println("id"+id);
		return projectService.findById(id);
		
	}
	
	@GetMapping("/fetchProjectList")
	public List<Project> getAllProjects() {
	
		return projectService.findAllProjects();
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteProject(@PathVariable Long id) {
	
		this.projectService.deleteProject(id);
		
		
	}
	

}
