package com.jinsu.proj.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notice")
public class NoticeVOsub implements Serializable{
	
	private static final long serialVersionUID = -5621220664942646274L;

	@Column(name="username")
	private String username;

	@Id
	@GeneratedValue
	@Column(name="title")
	private String title;
	
	@Column(name="ncontents")
	private String ncontents;

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

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof NoticeVOsub) {
			NoticeVOsub temp = (NoticeVOsub) obj;
			return this.title.equals(temp.getTitle());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return title.hashCode();
	}
	
}
