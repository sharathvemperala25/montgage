package com.hcl.Mortgage.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hcl.Mortgage.entity.Applications;

public interface ApplicationService {

public String approveCredit(Long appId);
Applications saveApplication(Applications applications);
public List<Applications> retrieveAllApplications();
public Applications createApplication(Applications applications);
public Applications retrieveApplication(Long id);
public ResponseEntity<Applications> updateApplication(Long id,Applications applications);

}
