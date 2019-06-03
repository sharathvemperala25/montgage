package com.hcl.Mortgage.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.Mortgage.entity.Applications;
import com.hcl.Mortgage.repository.ApplicationRepository;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationServiceTest {
	
	@Autowired
	ApplicationService applicationService;
	
	@MockBean
	ApplicationRepository applicationRepository;
	
	 @Test
	    public void testcreateApplicationSuccess() throws URISyntaxException
	    {
	    	Applications tempApplication = new Applications();
	    	tempApplication.setAddress("warangal");;
	    	tempApplication.setApplicantIncome(50000.0);;
	    	tempApplication.setCreditStatus("New");;
	    	tempApplication.setFirstName("sharath");
	    	tempApplication.setId(1L);
	    	tempApplication.setLastName("chandra");
	    	tempApplication.setLoanAmount(20000.0);
	    	Date date = new Date();
	    	tempApplication.setTimeCreated(date);
	    	Mockito.when(applicationRepository.save(tempApplication)).thenReturn(tempApplication);
	    	Applications applications = applicationService.saveApplication(tempApplication);
	    	Optional<Applications> optionalApplications = Optional.ofNullable(applications);
			assertThat(optionalApplications.isPresent());

	    }


}
	