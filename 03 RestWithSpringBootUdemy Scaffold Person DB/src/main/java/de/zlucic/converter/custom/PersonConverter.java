package de.zlucic.converter.custom;

import de.zlucic.data.model.Person;
import de.zlucic.data.vo.v2.PersonVOV2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service // Durch die Deklaration als Service können wir diese Klasse per DI injekten.
public class PersonConverter {

    public PersonVOV2 convertEntityToVO( Person person) {
        PersonVOV2 vo = new PersonVOV2();
        vo.setId( person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setAddress( person.getAddress());
        vo.setGender( person.getGender());
        vo.setBirthday( new Date());

        return vo;
    }

    public Person convertVOToEntity( PersonVOV2 person) {
        Person person1 = new Person();
        person1.setId( person.getId());
        person1.setFirstName(person.getFirstName());
        person1.setLastName(person.getLastName());
        person1.setAddress( person.getAddress());
        person1.setGender( person.getGender());

        return person1;
    }
}
