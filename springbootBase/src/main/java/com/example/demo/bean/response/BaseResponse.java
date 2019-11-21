package com.example.demo.bean.response;

import java.io.Serializable;

public class BaseResponse implements Serializable{

	private static final long serialVersionUID = 11L;
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
