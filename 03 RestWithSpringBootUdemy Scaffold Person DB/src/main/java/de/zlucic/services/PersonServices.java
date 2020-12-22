package de.zlucic.services;

import de.zlucic.converter.DozerConverter;
import de.zlucic.data.vo.PersonVO;
import de.zlucic.exception.UnknownRessourceException;
import de.zlucic.data.model.Person;
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

    public PersonVO findById(Long id) {
        Person person = repository.findById( id)
                .orElseThrow(() -> new UnknownRessourceException( "Person mit der ID: " + id + " unbekannt."));

        return DozerConverter.parseObject( person, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        List<Person> persons = repository.findAll();
        return DozerConverter.parseListObject( persons, PersonVO.class);
    }

    public PersonVO addPerson( PersonVO person) {
        Person personTemp = DozerConverter.parseObject( person, Person.class);
        personTemp = repository.save( personTemp);
        return DozerConverter.parseObject( personTemp, PersonVO.class);
    }

    public PersonVO updatePerson( PersonVO person) {
        Person entity = repository.findById( person.getId()).
                orElseThrow(() -> new UnknownRessourceException("Person mit der ID: " + person.getId() + " unbekannt."));

        Person personTemp = DozerConverter.parseObject( person, Person.class);
        entity.setFirstName( personTemp.getFirstName());
        entity.setLastName( personTemp.getLastName());
        entity.setAddress( personTemp.getAddress());
        entity.setGender( personTemp.getGender());

        personTemp = repository.save( entity);
        return DozerConverter.parseObject( personTemp, PersonVO.class);
    }

    public void deletePerson( Long id) {
        Person entity = repository.findById( id).
                orElseThrow(() -> new UnknownRessourceException("Person mit der ID: " + id + " unbekannt."));
        repository.deleteById( id);
    }
}
