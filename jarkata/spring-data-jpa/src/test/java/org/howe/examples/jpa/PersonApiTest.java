package org.howe.examples.jpa;

import org.howe.examples.jpa.entity.Person;
import org.howe.examples.jpa.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonApiTest {

    @InjectMocks
    private PersonApi api;

    @Mock
    private PersonService service;

    @Test
    void shouldReturnResponseWithStatusOkWhenCreatePerson() {
        Person person = new Person();
        person.setName("howe");
        Response response = api.createPerson(person);
        verify(service, only()).save(person);
        assertEquals(Response.Status.OK, response.getStatusInfo());
    }
}