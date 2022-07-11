package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.entity.Person;

@Service
public class PersonService {
	
	@Autowired
	PersonDao personDao;
	
	public Iterable<Person> getPerson(){
		return personDao.findAll();
	}
	
	public Iterable<Person> createPerosn(Person person){
		personDao.save(person);
		return getPerson();
	}
	
	public List<Person> findPerson(String gender){
		//排序職業, 再排序年齡
		List<Person> work1 = new ArrayList<>();
		List<Person> work2 = new ArrayList<>();
		List<Person> work3 = new ArrayList<>();
		List<Person> work4 = new ArrayList<>();
		List<Person> totalList = new ArrayList<>();
		List<Person> personGroup = personDao.findGender(gender);
		Collections.sort(personGroup, new AgeComparator());
		//List<Person> sortPerson = new ArrayList<>();
		//Map<String, List<Person>> personMAp =  personGroup.stream().collect(Collectors.groupingBy(Person::getWork));
		//return personGroup.stream().collect(Collectors.groupingBy(Person::getWork));
		/*
		for(Object row : personGroup) {
			Object[] cells = (Object[]) row;
			Person person = new Person();
			person.setName((String)cells[0]);
			person.setAge((Integer)cells[1]);
			person.setGender((String)cells[2]);
			person.setWork((String)cells[3]);
			sortPerson.add(person);
			
		}
		*/
		personGroup.forEach(p ->{
			//用確定的東西去equals不確定
			if("士".equals(p.getWork()))
				work1.add(p);
			if("農".equals(p.getWork()))
				work2.add(p);
			if("工".equals(p.getWork()))
				work3.add(p);
			if("商".equals(p.getWork()))
				work4.add(p);
		});

		totalList.addAll(work1);
		totalList.addAll(work2);
		totalList.addAll(work3);
		totalList.addAll(work4);
		return totalList;
	}
	
}
