package org.howe.examples.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;

@ApplicationScoped
public class PersonRepository {

    @PersistenceContext(unitName = "SAMPLE_PU")
    private EntityManager em;

    @Transactional(REQUIRED)
    public void create(Person person) {
        em.persist(person);
    }

    public Person find(Long id) {
        return em.find(Person.class, id);
    }
}


