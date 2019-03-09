package com.techprimers.stock.proxy;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.techprimers.stock.model.ProjectTask;

@FeignClient(name="DB-SERVICE", url="localhost:8300")
public interface DBServiceProxy {

	@PostMapping("/projectTask/adding")
	public ResponseEntity<?> saveOrUpdateProjectTask(@RequestBody ProjectTask projectTask);
	
	@GetMapping("/projectTask/fetchProjectTasks")
	public List<ProjectTask> findAllProjectTask();
	
	@DeleteMapping("/projectTask/{pt_id}")
	public ResponseEntity<?> deleteProjectTask(@PathVariable Long pt_id);
	
	@GetMapping("/projectTask/getProjectTask/{pt_id}")
	public ProjectTask getProjectTask(@PathVariable Long pt_id);
}
