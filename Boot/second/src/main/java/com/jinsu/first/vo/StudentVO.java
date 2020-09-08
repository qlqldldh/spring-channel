package com.jinsu.first.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="STUDENT")
public class StudentVO implements Serializable{

	private static final long serialVersionUID = 4951160332037016256L;

	@Id
	@Column(name="studid")
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

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof StudentVO) {
			StudentVO temp = (StudentVO) obj;
			return this.studid==temp.getStudid();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return studid;
	}
	
}
