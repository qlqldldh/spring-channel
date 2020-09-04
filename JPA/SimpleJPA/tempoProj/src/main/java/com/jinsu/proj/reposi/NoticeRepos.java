package com.jinsu.proj.reposi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jinsu.proj.vo.NoticeVO;

@Repository
public class NoticeRepos {
	
	@PersistenceContext
	EntityManager entityManager;
	
	/* Access to Data with using JPA */
	public NoticeVO selectOneByJpa(String title){ // select specific one
		NoticeVO nv = entityManager.find(NoticeVO.class, title);
		return nv;
	}
	
	public List<NoticeVO> selectAllByJpa(){ // select all
		String jpql = "select n from NoticeVO n"; // table name -> Entity Object Name
		TypedQuery<NoticeVO> query = entityManager.createQuery(jpql,NoticeVO.class);
		
		return query.getResultList();
	}
	
	@Transactional
	public void insertByJpa(NoticeVO notice) { // insert
		entityManager.persist(notice); // 'detached entity passed to persist' -- solve : remove @GeneratedValue annotation on title variable in NoticeVO
//		entityManager.getTransaction().commit(); // when work without @Transactional
		
//		String jpql="insert into notice values(?,?,?,?)";
//		entityManager.createNativeQuery(jpql)
//		.setParameter(1, vo.getUsername())
//		.setParameter(2, vo.getTitle())
//		.setParameter(3, vo.getNcontents())
//		.setParameter(4, vo.getNdate())
//		.executeUpdate(); // sql using nativeQuery method
	}
	
	@Transactional
	public void deleteByJpa(String title) { // delete
		NoticeVO nv = entityManager.find(NoticeVO.class,title);
		
		entityManager.remove(nv);
	}
	
	@Transactional
	public void updateByJpa(String title, String contents) { // update
		NoticeVO nv = selectOneByJpa(title);
		nv.setNcontents(contents);
	}
}



