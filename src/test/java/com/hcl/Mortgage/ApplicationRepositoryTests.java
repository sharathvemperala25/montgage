package com.hcl.Mortgage;


import static org.hamcrest.CoreMatchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.hcl.Mortgage.repository.ApplicationRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationRepositoryTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ApplicationRepository applicationRepository;

	@Before
	public void deleteAllBeforeTests() throws Exception {
		applicationRepository.deleteAll();
	}
	
	@Test
	public void shouldReturnRepositoryIndex() throws Exception {

		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
				jsonPath("$._links.mortgage").exists());
	}
	
	@Test
	public void shouldCreateEntity() throws Exception {

		mockMvc.perform(post("/mortgage").content(
				"{\r\n" + 
				"    \"id\": 2,\r\n" + 
				"    \"firstName\": \"Manoj\",\r\n" + 
				"    \"lastName\": \"Kumar\",\r\n" + 
				"    \"address\": \"HCL Tech\",\r\n" + 
				"    \"creditStatus\": \"Funded\",\r\n" + 
				"    \"applicantIncome\": 400000,\r\n" + 
				"    \"loanAmount\": 200000.23,\r\n" + 
				"    \"timeCreated\": \"2019-06-03T09:07:58.000+0000\"\r\n" + 
				"}")).andExpect(
						status().isCreated()).andExpect(
								header().string("Location", containsString("mortgage/")));
	}
	
	@Test
	public void shouldUpdateEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post("/mortgage").content(
				"{\r\n" + 
				"\"id\": 2,\r\n" + 
				"    \"firstName\": \"Manoj\",\r\n" + 
				"    \"lastName\": \"Kumar\",\r\n" + 
				"    \"address\": \"HCL Tech\",\r\n" + 
				"    \"creditStatus\": \"Funded\",\r\n" + 
				"    \"applicantIncome\": 400000.34,\r\n" + 
				"    \"loanAmount\": 200000.23,\r\n" + 
				"    \"timeCreated\": \"2019-06-03T09:07:58.000+0000\"\r\n" + 
				"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(put(location).content(
				"{\r\n" + 
				"\"id\": 2,\r\n" + 
				"    \"firstName\": \"Manoj\",\r\n" + 
				"    \"lastName\": \"Kumar\",\r\n" + 
				"    \"address\": \"HCL Tech\",\r\n" + 
				"    \"creditStatus\": \"Funded\",\r\n" + 
				"    \"applicantIncome\": 400000.34,\r\n" + 
				"    \"loanAmount\": 200000.23,\r\n" + 
				"    \"timeCreated\": \"2019-06-03T09:07:58.000+0000\"\r\n" + 
				"}")).andExpect(
						status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.firstName").value("Manoj")).andExpect(
						jsonPath("$.lastName").value("Kumar")).andExpect(
								jsonPath("$.address").value("HCL Tech")).andExpect(
										jsonPath("$.creditStatus").value("Funded")).andExpect(
												jsonPath("$.applicantIncome").value("400000.34")).andExpect(
														jsonPath("$.loanAmount").value("200000.23")).andExpect(
																jsonPath("$.timeCreated").value("2019-06-03T09:07:58.000+0000"));
	}

}
