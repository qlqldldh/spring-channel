package com.jinsu.proj;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {HelloMessageConfig.class,ByeMessageConfig.class})
@ActiveProfiles("bye")
public class ProfileTest {
	
	@Autowired
	AmbgMessage ambgMessage; // extended by HelloMessage & ByeMessage
	// it will be changed according to the profile name
	
	@BeforeClass
	public static void beforeTest() {
		System.out.println("Before Test...");
	}
	
	@AfterClass
	public static void afterTest() {
		System.out.println("After Test...");
	}
	
	@Test
	public void test() {
		System.out.println(ambgMessage.printMessage());
		assertThat(ambgMessage.printMessage(),is("bye")); // return 'true' because parameter of ActiveProfiles is "bye"
	}
}
