package com.spring.exercise;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class GiftVO implements Serializable{
	private static final long serialVersionUID = 13098236493L;
	
	@NotNull // String을 제외한 다른 기본 타입들은 값이 들어오지 않으면 null로 들어가기 때문에 @NotNull로 validation해야함
	private int gno; // PK
	
	@NotEmpty // String의 경우엔 null값이 아닌 ""로 들어옴. 따라서 @NotNull이 아니고 @NotEmpty를 사용해서 validation해야함
	@Size(max=100)
	private String gname;
	
	@NotNull
	private int g_start;
	
	@NotNull
	private int g_end;

	
	public int getGno() {
		return gno;
	}

	public void setGno(int gno) {
		this.gno = gno;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getG_start() {
		return g_start;
	}

	public void setG_start(int g_start) {
		this.g_start = g_start;
	}

	public int getG_end() {
		return g_end;
	}

	public void setG_end(int g_end) {
		this.g_end = g_end;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof GiftVO) {
			GiftVO temp = (GiftVO)obj;
			return this.gno==temp.getGno();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return gno;
	}
	
}
