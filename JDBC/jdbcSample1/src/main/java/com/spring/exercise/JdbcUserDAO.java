package com.spring.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcUserDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int CountTotalUser() {
		String sql = "select count(*) from buser";
		return jdbcTemplate.queryForObject(sql, Integer.class).intValue();
	}
	
	public List<BuserVO> selectAll(){
		String sql = "select * from buser";
		List<Map<String,Object>> lst = jdbcTemplate.queryForList(sql);
		List<BuserVO> ret = new ArrayList<BuserVO>();
		for(Map<String,Object> mp:lst) {
			BuserVO bv = new BuserVO();
			bv.setEmail((String)mp.get("email"));
			bv.setPasswd((String)mp.get("passwd"));
			bv.setPhone((String)mp.get("phone"));
			bv.setAddress((String)mp.get("address"));
			bv.setBirth((String)mp.get("birth"));
			bv.setName((String)mp.get("name"));
			ret.add(bv);
		}
		
		return ret;
	}
	
	public BuserVO searchByEmail(String email) {
		String sql="select * from buser where email=?";
		
		Map<String,Object> mp = jdbcTemplate.queryForMap(sql,email);
		
		BuserVO bv = new BuserVO();
		
		bv.setEmail((String)mp.get("email"));
		bv.setPasswd((String)mp.get("passwd"));
		bv.setPhone((String)mp.get("phone"));
		bv.setAddress((String)mp.get("address"));
		bv.setBirth((String)mp.get("birth"));
		bv.setName((String)mp.get("name"));
		
		return bv;
	}
	
	public int updateUser(BuserVO bv) {
		String sql = "update buser set phone=?, address=?, birth=?, name=? where email=?";
		return jdbcTemplate.update(sql,bv.getPhone(),bv.getAddress(),bv.getBirth(),bv.getName(),bv.getEmail());
	}
	
	/*
	 * public List<BuserVO> selectAll2(){ String sql = "select * from buser";
	 * 
	 * return jdbcTemplate.query(sql, (rs,rowNum)->{ BuserVO bv = new BuserVO();
	 * bv.setEmail(rs.getString("email")); bv.setPasswd(rs.getString("passwd"));
	 * bv.setPhone(rs.getString("phone")); bv.setAddress(rs.getString("address"));
	 * bv.setBirth(rs.getString("birth")); bv.setName(rs.getString("name"));
	 * bv.setEnabled(rs.getInt("enabled"));
	 * bv.setAuthority(rs.getString("authority"));
	 * 
	 * return bv; }); }
	 */  // -- lambda식은 java SE 1.8부터 적용 가능
}
