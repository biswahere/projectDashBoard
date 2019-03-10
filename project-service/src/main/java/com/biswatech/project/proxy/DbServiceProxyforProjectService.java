package com.biswatech.project.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.biswatech.project.model.Project;



@FeignClient(name="DB-SERVICE", url="localhost:8300")
public interface DbServiceProxyforProjectService {
	
	@PostMapping("/api/project/create")
	public ResponseEntity<Project> createNewProject(@RequestBody Project project);

}
