package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

  private final static List<Person> DB = new ArrayList<>();

  @Override
  public List<Person> getPeople() {
    return DB;
  }

  @Override
  public UUID addPerson(UUID id, Person person) {
    DB.add(new Person(id, person.getName()));
    return id;
  }

  @Override
  public Optional<Person> getPerson(UUID id) {
    return DB
        .stream()
        .filter(person -> person.getId().equals(id))
        .findFirst();
  }

  @Override
  public int deletePerson(UUID id) {
    Optional<Person> personOptional = getPerson(id);
    if (!personOptional.isPresent()) {
      return 0;
    }
    DB.remove(personOptional.get());
    return 1;
  }

  @Override
  public int updatePerson(UUID id, Person personUpdate) {
    return getPerson(id)
        .map(person -> {
          int indexOfPersonToDelete = DB.indexOf(person);
          if (indexOfPersonToDelete >= 0) {
            DB.set(indexOfPersonToDelete, new Person(id, personUpdate.getName()));
            return 1;
          }
          return 0;
        })
        .orElse(0);
  }
}
