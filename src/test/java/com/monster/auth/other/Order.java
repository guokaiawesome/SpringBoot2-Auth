package com.monster.auth.other;

public class Order {
	
	private Integer id;
	
	private String name;
	
	private String uid;
	
	private String producer;
	
	private String consumer;
	
	private String vars;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	public String getVars() {
		return vars;
	}

	public void setVars(String vars) {
		this.vars = vars;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", uid=" + uid + ", producer=" + producer + ", consumer="
				+ consumer + ", vars=" + vars + "]";
	}
	
	

}
