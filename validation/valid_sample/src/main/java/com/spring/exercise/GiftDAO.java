package com.spring.exercise;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GiftDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<GiftVO> selectAll(){
		String sql = "select * from gift";
		List<Map<String,Object>> temp = jdbcTemplate.queryForList(sql);
		List<GiftVO> ret = new ArrayList<GiftVO>();
		
		try {
			for(Map<String,Object> mp:temp) {
				GiftVO gv = new GiftVO();
				gv.setGno(((BigDecimal)mp.get("gno")).intValue());
				gv.setGname((String)mp.get("gname"));
				gv.setG_start(((BigDecimal)mp.get("g_start")).intValue());
				gv.setG_end(((BigDecimal)mp.get("gno")).intValue());
				
				ret.add(gv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public int insertGift(GiftVO gv) throws Exception {
		System.out.println("insertDAO!!");
		String sql = "insert into gift values(?,?,?,?)";
		if(gv.getGname().equals("")) throw new Exception(); // 이렇게 하면 TestController로 exception을 위임함
		return jdbcTemplate.update(sql,gv.getGno(),gv.getGname(),gv.getG_start(),gv.getG_end());
	}
	
	public int insertGift2(GiftVO gv) {
		String sql="insert into gift values(?,?,?,?)";
		return jdbcTemplate.update(sql,gv.getGno(),gv.getGname(),gv.getG_start(),gv.getG_end());
	}
	
	public int deleteGift(String gno) {
		String sql="delete from gift where gno=?";
		return jdbcTemplate.update(sql,gno);
	}
}
