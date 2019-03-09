package com.techprimers.stock.controller;

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
import com.techprimers.stock.proxy.DBServiceProxy;


@RestController
@RequestMapping("/rest/project")
@CrossOrigin
public class ProjectTaskController {

	
	@Autowired
	private DBServiceProxy proxy;
	
	@PostMapping("/createTask")
	public ResponseEntity<?> saveOrUpdateProjectTask(@Valid @RequestBody ProjectTask projectTask, BindingResult result){
		if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
		
		return proxy.saveOrUpdateProjectTask(projectTask);
	}
	
	///for validation
	/*@PostMapping("/testing")
	public ResponseEntity<?> Test(@Valid @RequestBody ProjectTask projectTask, BindingResult result){
		
		if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
		System.out.println("Enterringgggg====================================");
		return proxy.saveOrUpdateProjectTask(projectTask);
	}*/
	
	@GetMapping("/projectTaskList")
	public List<ProjectTask> projectLists(){
			return proxy.findAllProjectTask();
		
	}
	
	
	@DeleteMapping("/deleteProjectTask/{pt_id}")
	public List<ProjectTask> deleteProjectTask(@PathVariable Long pt_id){
	
		   this.proxy.deleteProjectTask(pt_id);
			return proxy.findAllProjectTask();
		
	}
	
	@GetMapping("/fetchPropjectTask/{pt_id}")
	public ProjectTask getproject(@PathVariable Long pt_id){
		
		System.out.println("project service"+pt_id);
			return proxy.getProjectTask(pt_id);
		
	}
	
	
	
	
	

}
