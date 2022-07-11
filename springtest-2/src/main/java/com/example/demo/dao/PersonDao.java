package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Person;

public interface PersonDao extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {

	
	@Query(value="select * from Person p where p.gender = ?1"
			,nativeQuery=true)
	List<Person> findGender(String gender);
	
	
}
