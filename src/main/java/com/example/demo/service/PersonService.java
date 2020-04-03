package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

  private final PersonDao personDao;

  @Autowired
  public PersonService(@Qualifier("postgres") PersonDao personDao) {
    this.personDao = personDao;
  }

  public List<Person> getAllPeople() {
    return personDao.getPeople();
  }

  public UUID insertNewPerson(Person person) {
    return personDao.addPerson(person);
  }

  public Optional<Person> getPersonById(UUID personId) {
    return personDao.getPerson(personId);
  }

 public  void deletePerson(UUID personId) {
    personDao.deletePerson(personId);
  }

  public void updatePerson(UUID personId, Person person) {
    personDao.updatePerson(personId, person);
  }
}
