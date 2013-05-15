package cn.tv189.domain;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = -3807511470861510540L;
	private int id;
	private String name;
	public Student(){
		
	}
	public Student(String name) {
		this.name = name;
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
	
	
}
