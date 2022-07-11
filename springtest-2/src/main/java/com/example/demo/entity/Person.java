package com.example.demo.entity;

import javax.persistence.*;


@Entity
@Table
public class Person {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
	
	@Column
	String name;
	
	@Column
	Integer age;
	
	@Column
	String gender;
	
	@Column
	String work;
	
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
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getWork() {
		return work;
	}
	
	public void setWork(String work) {
		this.work = work;
	}

}
