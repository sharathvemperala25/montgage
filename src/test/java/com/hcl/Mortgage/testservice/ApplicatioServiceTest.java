package com.hcl.Mortgage.testservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.Mortgage.entity.User;
import com.hcl.Mortgage.repository.ApplicationRepository;
import com.hcl.Mortgage.service.ApplicationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicatioServiceTest {
	
	@Autowired
	ApplicationService applicationService;

	@MockBean
	ApplicationRepository applicationRepository;

	
	
	

}
