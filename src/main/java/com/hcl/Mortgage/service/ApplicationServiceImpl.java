package com.hcl.Mortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
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

	

}
