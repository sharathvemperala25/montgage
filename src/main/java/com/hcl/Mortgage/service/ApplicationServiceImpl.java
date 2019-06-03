package com.hcl.Mortgage.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.Mortgage.entity.Applications;
import com.hcl.Mortgage.repository.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService{
	
	@Autowired
	ApplicationRepository applicationRepository;

	@Override
	public String approveCredit(Long appId) {
		
	   Applications application1=applicationRepository.findById(appId).get();
	   
	double salary=application1.getApplicantIncome()/3;
double loanAmt=	application1.getLoanAmount();
	   if(salary>=loanAmt)
	   { application1.setCreditStatus("Approved");
	   applicationRepository.save(application1);
		   
	   }else
	   {
		   application1.setCreditStatus("Rejected");
		   applicationRepository.save(application1);
	   }
	  
		return "Application "+ application1.getCreditStatus();
	}
	
	@Override

	public Applications saveApplication(Applications applications) {
		applications.setCreditStatus("New");
		Date timeCreated = new Date();
		applications.setTimeCreated(timeCreated);
		return applicationRepository.save(applications);
	}

	
	public List<Applications> retrieveAllApplications() {
		return applicationRepository.findAll();
	}

	@Override
	public Applications createApplication(Applications applications) {
		return applicationRepository.save(applications);
	}

	@Override
	public Applications retrieveApplication(Long id) {
		Applications app=applicationRepository.findById(id).orElse(null);
		return app;
	}

	@Override
	public ResponseEntity<Applications> updateApplication(Long id, Applications applicationDetails) {
		Applications currentApp=applicationRepository.findById(id).orElse(null);
		/*currentApp.setAddress(applicationDetails.getAddress());
		currentApp.setCreditStatus(applicationDetails.getCreditStatus());
		currentApp.setApplicantIncome(applicationDetails.getApplicantIncome());
		currentApp.setFirstName(applicationDetails.getFirstName());
		currentApp.setLastName(applicationDetails.getLastName());
		currentApp.setLoanAmount(applicationDetails.getLoanAmount());
		currentApp.setTimeCreated(applicationDetails.getTimeCreated());
		final Applications updatedApp=applicationRepository.save(currentApp);*/
		currentApp.setCreditStatus(applicationDetails.getCreditStatus());
		final Applications updatedApp=applicationRepository.save(currentApp);
		return ResponseEntity.ok(updatedApp);
	}

	

}
