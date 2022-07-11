package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;



@Controller
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Autowired
	PersonService personService;
	//List<Person> personList = new ArrayList<Person>();
	
	
	@GetMapping("/form")
	public String form(Model model) {
		Person person = new Person();
		model.addAttribute("person", person);
		return "form";
	}
	
	@PostMapping("/form")
	public String newForm(@ModelAttribute Person person, Model model) {
		Iterable<Person> allPersonList = personService.createPerosn(person);
		Person newPerson = new Person();
		model.addAttribute("person", newPerson);
		return "redirect:/form";
	}

	@GetMapping("/add")
	public String add(@ModelAttribute Person person, Model model) {
		Iterable<Person> allPersonList = personService.getPerson();
		model.addAttribute("personlist", allPersonList);
		return "add";
	}
	
	@GetMapping("/result")
	public String result(@ModelAttribute Person person, Model model) {
		//List<Person> allPersonList = personService.findPerson("女").values().stream().sorted().collect(Collectors.toList());
		List<Person> allPersonList = personService.findPerson("女");
		//System.out.println(allPersonList);
		model.addAttribute("personlist", allPersonList);
		return "result";
	}
	
}