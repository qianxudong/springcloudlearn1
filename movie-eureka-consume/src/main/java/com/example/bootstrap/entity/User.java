package com.example.bootstrap.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String address;
	
	public User() {
		super();
	}

	public User(Long id) {
		super();
		this.id = id;
	}
	
	public User(Long id, String name) {
		this(id,name,"SHHAI");
	}
	
	public User(Long id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}
