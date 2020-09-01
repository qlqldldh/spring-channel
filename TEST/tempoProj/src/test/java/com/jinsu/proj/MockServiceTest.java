package com.jinsu.proj;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsNot.*;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockServiceTest {
	
//	@Autowired
//	ServiceMessage serviceMessage; // Bean 등록이 안되있으면 주입이 안됨
	
	@InjectMocks
	ServiceMessage service;
	
	@Before
	public void beforeMethod() {
		System.out.println("Before Test....");
	}
	
	@After
	public void afterMethod() {
		System.out.println("After Test....");
	}
	
	@Test
	public void testMock1() { // success case
		System.out.println(service.getMessage());
		
		assertThat(service.getMessage(), is("hello")); // 'hamcrest' dependency is needed
	}

	@Test
	public void testMock2() { // fail case
		System.out.println(service.getMessage());
		assertThat(service.getMessage(),is(not("hello")));
	}
	
}
