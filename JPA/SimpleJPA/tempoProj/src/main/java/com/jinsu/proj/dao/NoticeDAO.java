package com.jinsu.proj.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jinsu.proj.vo.NoticeVO;

@Repository
public class NoticeDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<NoticeVO> selectAll() {
		String query="select * from notice";
		
		List<Map<String,Object>> temp = jdbcTemplate.queryForList(query);
		List<NoticeVO> ret = new ArrayList<>();
		
		NoticeVO vo;
		for(Map<String,Object> mp:temp) {
			vo=new NoticeVO();
			vo.setUsername(mp.get("username").toString());
			vo.setTitle(mp.get("title").toString());
			vo.setNcontents(mp.get("ncontents").toString());
			vo.setNdate(mp.get("ndate").toString());
			
			ret.add(vo);
		}
		return ret;
	}
	
	public NoticeVO selectByTemp(String title) {
		String sql="select * from notice where title=?";
		Map<String,Object> result = jdbcTemplate.queryForMap(sql,title);
		
		NoticeVO nv = new NoticeVO();
		nv.setUsername((String)result.get("username"));
		nv.setTitle((String)result.get("title"));
		nv.setNcontents((String)result.get("ncontents"));
		
		nv.setNdate((String)result.get("ndate"));
		
		return nv;
	}
	
	public void insertByTemp(NoticeVO nv) {
		String sql = "insert into notice values(?,?,?,?)";
		jdbcTemplate.update(sql,nv.getUsername(),nv.getTitle(),nv.getNcontents(),nv.getNdate());
		// inconvenient process because of many arguments
	}
	
	public void deleteByTemp(String title) {
		String sql = "delete from notice where title=?";
		
		jdbcTemplate.update(sql,title);
	}
}
