package com.jinsu.proj.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="notice")
public class NoticeVO implements Serializable{

	private static final long serialVersionUID = -3437472533334089068L;
	
	@Column(name="username")
	@NotEmpty(message="username:empty value is not allowed")
	private String username;
	
	@Id
//	@GeneratedValue // when is it used????
	@Column(name="title")
	@NotEmpty(message="title:empty value is not allowed")
	private String title;
	
	@Column(name="ncontents")
	private String ncontents;
	
	@Column(name="ndate")
	private String ndate;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNcontents() {
		return ncontents;
	}
	public void setNcontents(String ncontents) {
		this.ncontents = ncontents;
	}
	public String getNdate() {
		return ndate;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof NoticeVO) {
			NoticeVO temp = (NoticeVO) obj;
			return this.title.equals(temp.getTitle());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return title.hashCode();
	}
	
}
