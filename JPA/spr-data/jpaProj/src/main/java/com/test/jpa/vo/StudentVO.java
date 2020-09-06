package com.test.jpa.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentVO {
	
	@Id
	@Column(name="studid")
//	@Pattern(regexp="[0-9+]", message="only number type is accepted") // use only when validated variable's type is String
	private int studid;
	
	@Column(name="stname")
	private String stname;
	
	@Column(name="grade")
	private int grade;
	
	@Column(name="stgroup")
	private int stgroup;

	public int getStudid() {
		return studid;
	}

	public void setStudid(int studid) {
		this.studid = studid;
	}

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getStgroup() {
		return stgroup;
	}

	public void setStgroup(int stgroup) {
		this.stgroup = stgroup;
	}
	
}
