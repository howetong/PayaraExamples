package org.howe.examples.jpa.entity;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PersonDao {

    @Inject
    private PersonRepository personRepository;

    public void save(Person person) {
        personRepository.save(person);
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

//    public void updatePerson(Person person) {
//        personRepository.save(person);
//    }
}
