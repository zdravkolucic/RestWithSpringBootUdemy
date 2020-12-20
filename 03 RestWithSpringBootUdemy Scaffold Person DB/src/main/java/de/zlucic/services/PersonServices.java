package de.zlucic.services;

import de.zlucic.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    ArrayList<Person> persons = new ArrayList<Person>();

    public PersonServices() {
        setupMock();
    }

    private void setupMock() {
        persons.add( new Person( counter.incrementAndGet(), "Zdravko", "Lucic", "Mozarstr. 37/1, 88255 Sigmaringen", "male"));
        persons.add( new Person( counter.incrementAndGet(), "Zlatko", "Lucic", "Bittelschießerstr. 38, 72488 Sigmaringen", "male"));
    }

    public Person findById(Long id) {
        for( Person p:persons) {
            if( p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public List<Person> findAll() {
        return persons;
    }

    public Long addPerson( Person person) {
        Long id = counter.incrementAndGet();
        person.setId( id);
        persons.add( person);
        return id;
    }

    public String updatePerson( Person person) {
        for( Person p:persons) {
            if( p.getId() == person.getId()) {
                p.setFirstName( person.getFirstName());
                p.setLastName( person.getLastName());
                p.setAddress( person.getAddress());
                p.setGender( person.getGender());
                return "Updated person: " + p.toString();
            }
        }
        return "Person with id " + person.getId() + " not found";
    }

    public String deletePerson( Long id) {
        for( int index = 0; index<persons.size(); index++) {
            if( persons.get( index).getId() == id) {
                String person = persons.get( index).toString();
                persons.remove( index);
                return "Removed person: " + person.toString();
            }
        }
        return "Person with id " + id + " not found";
    }
}
