package com.jinsu.proj.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jinsu.proj.vo.NoticeVO;

@Repository
public class NoticeDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<NoticeVO> selectAll() {
		String query="select * from notice";
		
		List<Map<String,Object>> temp = jdbcTemplate.queryForList(query);
		List<NoticeVO> ret = new ArrayList<>();
		
		NoticeVO vo;
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		for(Map<String,Object> mp:temp) {
			vo=new NoticeVO();
			vo.setUsername(mp.get("username").toString());
			vo.setTitle(mp.get("title").toString());
			vo.setNcontents(mp.get("ncontents").toString());
			
			String dt = sdf.format((Date)mp.get("ndate")).toString();
			vo.setNdate(dt);
			
			ret.add(vo);
		}
		return ret;
	}
}
