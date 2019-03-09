package com.techprimers.stock.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.stock.model.ProjectTask;
import com.techprimers.stock.service.ProjectTaskService;

@RestController
@RequestMapping("/projectTask")
@CrossOrigin
public class ProjectTaskController {
	
	@Autowired
	private ProjectTaskService projectTaskService;
	
	@PostMapping("/adding")
	public ResponseEntity<?> saveOrUpdateProjectTask(@RequestBody ProjectTask projectTask){
		
		ProjectTask newPtt = this.projectTaskService.saveOrUpdateProjectTask(projectTask);
		
		return new ResponseEntity<ProjectTask>(newPtt, HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/fetchProjectTasks")
	public List<ProjectTask> findAllProjectTask(){
		
		return this.projectTaskService.findAll();
		
					
	}
	
	@GetMapping("/getProjectTask/{pt_id}")
	public ProjectTask getProjectTask(@PathVariable Long pt_id) {
		System.out.println("db service"+pt_id);
		return this.projectTaskService.getProjectTask(pt_id);
		
	}
	
	@DeleteMapping("/{pt_id}")
    public ResponseEntity<?> deleteProjectTask(@PathVariable Long pt_id){
		
		System.out.println("Delete....."+pt_id);
		this.projectTaskService.delete(pt_id);
        return new ResponseEntity<String>("Project Task deleted", HttpStatus.OK);
    }

}
