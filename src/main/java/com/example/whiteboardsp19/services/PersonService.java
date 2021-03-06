package com.example.whiteboardsp19.services;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.whiteboardsp19.model.Person;

@Service
@CrossOrigin(origins = "http://localhost:3000", allowCredentials="true")
public class PersonService {

    private ArrayList<Person> persons = new ArrayList<>();

    public List<Person> findAllPerson() {
        return persons;
    }

    public Person findPersonById(Integer id) {
        for (Person Person : persons) {
            if (id == Person.getId().intValue())
                return Person;
        }
        return null;
    }


    public Person createPerson(Person newPerson) {
    	newPerson.setId((int) (Math.random() * 10000));
        persons.add(newPerson);
        return newPerson;
    }

    public Person register(Person person, HttpSession session) {
    	for (Person Person : persons) {
    	 if(Person.getUsername().equals(person.getUsername())) {
    		 person.setId((int)-1);
    		 return person;
    	 }
    	}
    	person.setId((int) (Math.random() * 10000));
        persons.add(person);
        session.setAttribute("currentUser", person);
        return person;
    }


    public void deletePerson(Integer id) {
        for (Person Person : persons) {
            if (id == Person.getId().intValue()) {
                persons.remove(Person);
                break;
            }
        }
    }

    public Person updatePerson(Integer id, Person Person) {
        for (int u = 0; u < persons.size(); u++) {
            if (id == persons.get(u).getId().intValue()) {
                persons.set(u, Person);
            }
        }
        return Person;

    }


} 