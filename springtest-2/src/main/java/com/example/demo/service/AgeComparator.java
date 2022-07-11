package com.example.demo.service;

import java.util.Comparator;

import com.example.demo.entity.Person;

class AgeComparator implements Comparator<Person> {

	public int compare(Person p1, Person p2) {
		// TODO Auto-generated method stub
		if(p1.getAge() > p2.getAge()) {
			return 1;
		}else if(p1.getAge() == p2.getAge()) {
			return 0;
		}else {
			return -1;
		}
	}

	

}
