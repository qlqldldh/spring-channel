package com.jinsu.proj.reposi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jinsu.proj.vo.NoticeVO;

@Repository
public class NoticeRepos {
	
	@PersistenceContext
	EntityManager entityManager;
	
	/* Access to Data with using JPA */
	public NoticeVO selectOneByJpa(String title){ 
		NoticeVO nv = entityManager.find(NoticeVO.class, title);
		return nv;
	}
	
	public List<NoticeVO> selectAllByJpa(){
		String jpql = "select n from NoticeVO n"; // table name -> Entity Object Name
		TypedQuery<NoticeVO> query = entityManager.createQuery(jpql,NoticeVO.class);
		
		return query.getResultList();
	}
}
