package com.hcl.Mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hcl.Mortgage.service.ApplicationService;

@RestController
public class ApplicationController {
	
	@Autowired
	ApplicationService applicationService;
	
	
	@PutMapping("/approval/{id}")
	public String getApproval(@PathVariable("id") Long  appId)
	{
		return applicationService.approveCredit(appId);
	}

}
