package org.howe.examples.jpa.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.cdi.Eager;

@Eager
public interface PersonRepository extends JpaRepository<Person, Long> {

}


