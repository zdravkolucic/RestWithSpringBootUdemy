package de.zlucic.services;

import de.zlucic.exception.UnknownRessourceException;
import de.zlucic.model.Person;
import de.zlucic.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    public PersonServices() {
    }

    public Person findById(Long id) {
        return repository.findById( id)
                .orElseThrow(() -> new UnknownRessourceException( "Person mit der ID: " + id + " unbekannt."));
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person addPerson( Person person) {
        return repository.save( person);
    }

    public Person updatePerson( Person person) {
        Person entity = repository.findById( person.getId()).orElseThrow(() -> new UnknownRessourceException("Person mit der ID: " + person.getId() + " unbekannt."));

        entity.setFirstName( person.getFirstName());
        entity.setLastName( person.getLastName());
        entity.setAddress( person.getAddress());
        entity.setGender( person.getGender());
        return repository.save( entity);
    }

    public void deletePerson( Long id) {
        Person entity = repository.findById( id).orElseThrow(() -> new UnknownRessourceException("Person mit der ID: " + id + " unbekannt."));
        repository.deleteById( id);
    }
}
