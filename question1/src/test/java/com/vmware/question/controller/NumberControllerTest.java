package com.vmware.question.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vmware.question.app.OneApplication;
import com.vmware.question.model.Input;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(NumberController.class)
@ContextConfiguration(classes = OneApplication.class)
//@SpringBootTest
//@AutoConfigureMockMvc
class NumberControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	static String taskId;
	
	@Test
	public void generateNumbers() {
	   Input input=new Input("10","2");
	   String json="{ \"Goal\" : \"10\", \"Step\" : \"2\" }";
	   //this.mockMvc.perform(post("/api/generate"))
	   try {
		MvcResult result = this.mockMvc.perform(post("/api/generate")
				    .contentType(MediaType.APPLICATION_JSON)
				    .content(json)
				    .characterEncoding("utf-8"))
				    .andExpect(status().isAccepted())
				    .andReturn();
		MockHttpServletResponse response  = result.getResponse();
		ObjectMapper mapper = new ObjectMapper();
		Map<String,String> map = mapper.readValue(response.getContentAsString(),Map.class);
		taskId=map.get("task");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}

	@Test
	public void getTaskStatus()  {
		try {
		this.mockMvc.perform(get("/api/"+taskId+"/status")).andDo(print())
		.andExpect(status().isOk())
				.andExpect(content().string(containsString("{\"result\":\"SUCCESS\"}")));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getNumberList()  {
		try {
		this.mockMvc.perform(get("/api/"+taskId+"?action=get_numlist")).andDo(print())
		.andExpect(status().isOk())
				.andExpect(content().string(containsString("{\"result\":\"10,8,6,4,2,0\"}")));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	


}
