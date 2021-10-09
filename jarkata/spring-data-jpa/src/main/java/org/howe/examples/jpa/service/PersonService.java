package org.howe.examples.jpa.service;

import org.howe.examples.jpa.entity.Person;
import org.howe.examples.jpa.entity.PersonDao;

import javax.inject.Inject;

public class PersonService {

    @Inject
    private PersonDao personDao;


    public void save(Person person) {
        personDao.save(person);
    }

    public Person findById(Long id) {
        return personDao.findById(id);
    }
}
