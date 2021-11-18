package com.example.demo.services;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
//    @Autowired
//    private PersonNotFoundException personNotFoundException;
    public Person addPerson(Person person) {
      return personRepository.save(person);
    }

    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<Person>();
        personRepository.findAll().forEach(persons1 -> persons.add(persons1));
        return persons;
    }

    public Optional<Person> getUser(Long id) {
        return personRepository.findById(id);

    }

    public Optional<Person> updatePerson(Person newperson, Long id) {
        Optional<Person> personPresent = personRepository.findById(id);

        if (personPresent.isPresent())
        {
            personRepository.save(newperson);
        }
        else
        {
            System.out.println("id wont exists");
        }


        return personPresent;


    }

    public void deletePerson(Long id) {
         personRepository.deleteById(id);
    }

    public List<Person> getByAge(int age) {

        List<Person> finalResult=new ArrayList<Person>();
        Iterable<Person> resultSet = personRepository.findAll();

        for (Person result:
             resultSet) {
            if (result.getAge()>age)
            {
                finalResult.add(result);
            }
        }

        return finalResult;
    }

    public Long totalCount() {
        return personRepository.count();
    }

    public List<Person> getByfirstname(String firstName) {
        List<Person> finalResult=new ArrayList<Person>();
        Iterable<Person> resultSet = personRepository.findAll();

        for (Person result:
                resultSet) {
            if (result.getFirstName().equalsIgnoreCase(firstName))
            {
                finalResult.add(result);
            }
        }

        return finalResult;

    }

    public List<Person> getAllDetails(String c) {
        List<Person> finalResult=new ArrayList<Person>();
        Iterable<Person> resultSet = personRepository.findAll();
        for (Person result:
                resultSet) {
            if (result.getFirstName().startsWith(c))
            {
                finalResult.add(result);
            }
        }

        return finalResult;
    }

    public List<Person> getBylastname(String lastName) {
      return personRepository.findByLastName(lastName);
    }

    public void delete() {
        Iterable<Person> resultSet = personRepository.findAll();
        for (Person result:
        resultSet) {
            if (result.getFirstName() == null)
            {
                personRepository.delete(result);
            }
        }

    }
}
