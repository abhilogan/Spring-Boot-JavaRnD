package com.example.demo.controller;

import java.util.List;

import org.hibernate.hql.internal.ast.ParseErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

@RestController
@RequestMapping("/spring-boot-orm")
public class PersonController {

	@Autowired
	private PersonDao dao;

	@PostMapping("/savePerson")
	public String save(@RequestBody Person person) {
		dao.savePerson(person);
		return "success";
	}
	
	@PutMapping("/updatePerson")
	public String update(@RequestBody Person person) {
		dao.updatePerson(person);
		return "success";
	}
	
	@GetMapping("/getPerson/{id}")
	public String getById(@PathVariable int id) {
		dao.findById(id);
		return "success";
	}
	
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<Person> getUserById(@PathVariable("id") int id) {
        System.out.println("Fetching person with id " + id);
        Person user = dao.findById(id);
        if (user == null) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Person>(user, HttpStatus.OK);
    }

	

	@GetMapping("/getAll")
	public List<Person> getALlPersons() {
		return dao.getPersons();
	}
	
	@DeleteMapping(value="/{id}")
    public ResponseEntity<Person> deleteUser(@PathVariable("id") int id){
        Person user = dao.findById(id);
        if (user == null) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        dao.deletePersonById(id);
        return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
    }

}
