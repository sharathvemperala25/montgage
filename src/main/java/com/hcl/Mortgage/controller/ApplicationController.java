package com.hcl.Mortgage.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.Mortgage.entity.Applications;
import com.hcl.Mortgage.service.ApplicationService;

@RestController
public class ApplicationController {
	
	@Autowired
	ApplicationService applicationService;
	
	
	@PutMapping("/approval/{id}")
	public Applications getApproval(@PathVariable("id") Long  appId)
	{
		return applicationService.approveCredit(appId);
	}
	

	@PostMapping("/createApplication")
	public Applications createApplication(@RequestBody Applications applications) {
		return applicationService.saveApplication(applications);
	}
	
	

	@GetMapping("/getall")
	public List<Applications>getAllApps(){
		return applicationService.retrieveAllApplications();
	}
	
	@GetMapping("/getapp/{id}")
	public Applications getApp(@PathVariable(value="id")Long id){
		Applications applications=applicationService.retrieveApplication(id);
		return applications;
	}
	
	/*@PostMapping("/create")
	public Applications createApplication(@Valid @RequestBody Applications applications){
		applications.setTimeCreated(new Date());
		return applicationService.createApplication(applications);
	}*/
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Applications> updateApplication(@PathVariable (value="id")Long id,
			@Valid @RequestBody Applications applicationDetails){
		ResponseEntity<Applications> applications1=applicationService.updateApplication(id, applicationDetails);
		return applications1;
	}

}
