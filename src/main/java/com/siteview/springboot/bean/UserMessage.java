package com.siteview.springboot.bean;

import java.io.Serializable;

public class UserMessage implements Serializable {

	/**
	 * 用户
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Integer sex;
	private Integer age;
	private String phone;

	public UserMessage() {

	}

	public UserMessage(Integer id, String name, Integer sex, Integer age, String phone) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
