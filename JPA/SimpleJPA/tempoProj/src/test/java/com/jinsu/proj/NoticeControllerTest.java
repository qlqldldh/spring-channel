package com.jinsu.proj;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.jinsu.proj.controller.NoticeController;
import com.jinsu.proj.dao.NoticeDAO;

@RunWith(MockitoJUnitRunner.class) // mockito의 Runner class를 사용
@WebAppConfiguration
public class NoticeControllerTest {

	@Mock
	NoticeDAO noticeDAO; // 컨트롤러 내 빈을 모의화
	
	@InjectMocks
	NoticeController noticeController;
	
	MockMvc mockMvc;
	
	@Before
	public void setup() { // setup method for mvc test
		this.mockMvc = MockMvcBuilders.standaloneSetup(noticeController).build(); // need to check
	}
	
	@BeforeClass
	public static void beforeTest() {
		System.out.println("Before Test...");
	}
	
	@AfterClass
	public static void afterTest() {
		System.out.println("After Test...");
	}
	
	@Test
	public void testNoticeController() throws Exception{ // test controller's operation
		mockMvc.perform(get("index")).andExpect(status().isOk());
		
	}

}
