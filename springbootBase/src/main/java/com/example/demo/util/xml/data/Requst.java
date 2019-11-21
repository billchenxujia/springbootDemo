package com.example.demo.util.xml.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Requst")
public class Requst {
	@XStreamAlias("Head")
	private Head head;
	@XStreamAlias("Body")
	private Body body;
	public Head getHead() {
		return head;
	}
	public void setHead(Head head) {
		this.head = head;
	}
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	
}
