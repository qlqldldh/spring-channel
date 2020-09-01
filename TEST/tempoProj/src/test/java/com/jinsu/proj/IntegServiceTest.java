package com.jinsu.proj;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, PoolingDataSourceConfig.class})
public class IntegServiceTest {

	@Autowired
	ServiceMessage serviceMessage;
	
	@BeforeClass
	public static void testBefore() {
		System.out.println("Before Test....");
	}

	@AfterClass
	public static void testAfter() {
		System.out.println("After Test....");
	}

	@Test
	public void testInteg() {
		System.out.println(serviceMessage.getMessage());

		assertThat(serviceMessage.getMessage(), is("hello"));
	}
}
// cglib 추가
