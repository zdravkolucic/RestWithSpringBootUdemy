package de.zlucic.converter.mock;

import de.zlucic.data.model.Person;
import de.zlucic.data.vo.PersonVO;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {

    public Person mockEntity() {
        return mockEntity(0);
    }

    public PersonVO mockVO() {
        return mockVO(0);
    }

    public List<Person> mockEntityList(int count) {
        List<Person> persons = new ArrayList<Person>();
        for( int i=0; i < count; i++) {
            persons.add( mockEntity(i));
        }
        return persons;
    }

    public List<PersonVO> mockVOList(int count) {
        List<PersonVO> persons = new ArrayList<PersonVO>();
        for( int i=0; i < count; i++) {
            persons.add( mockVO(i));
        }
        return persons;
    }

    private Person mockEntity( Integer number) {
        Person person = new Person();
        person.setId( number.longValue());
        person.setFirstName( "Firstname_" + number);
        person.setLastName( "Lastname_" + number);
        person.setAddress( "Street_"+number+"; City_"+number);
        person.setGender(((number % 2)==0) ?"Male":"Female");

        return person;
    }

    private PersonVO mockVO( Integer number) {
        PersonVO person = new PersonVO();
        person.setId( number.longValue());
        person.setFirstName( "Firstname_" + number);
        person.setLastName( "Lastname_" + number);
        person.setAddress( "Street_"+number+"; City_"+number);
        person.setGender(((number % 2)==0) ?"Male":"Female");

        return person;
    }
}
