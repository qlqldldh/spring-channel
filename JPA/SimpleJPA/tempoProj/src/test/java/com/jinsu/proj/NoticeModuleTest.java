package com.jinsu.proj;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.jinsu.proj.config.JpaAppConfig;
import com.jinsu.proj.config.PoolingDataSourceConfig;
import com.jinsu.proj.service.NoticeService;
import com.jinsu.proj.vo.NoticeVO;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {PoolingDataSourceConfig.class, JpaAppConfig.class, NoticeConfig.class})
public class NoticeModuleTest {

	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	NoticeService noticeService;
	
	@Test
	public void selectTest() {
		NoticeVO nv = noticeService.showNoticeByTitle("su1");
		if(nv==null) System.out.println("null");
		
		assertThat(nv.getTitle(),is("su1"));
	}

}
