package de.zlucic.controller;

import de.zlucic.model.Person;
import de.zlucic.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/person")
public class PersonController {

    @Autowired
    private PersonServices personServices;
    /* durch das @Autowired wird durch Spring automatisch eine Variable vom Typ PersonServices erzeugt
    und personServices zugewiesen (nennt sich DependencyInjection
    */

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") Long id) {
        return personServices.findById( id);
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return personServices.findAll();
    }

    @RequestMapping(
            value="/addPerson",
            method=RequestMethod.POST,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE
            )
    public Person addPerson( @RequestBody Person person)
    {
        return personServices.addPerson( person);
    }

    @RequestMapping(
            value="/deletePerson/{id}",
            method=RequestMethod.DELETE)
    public void deletePerson( @PathVariable(value="id") Long id) {
        personServices.deletePerson( id);
    }

    @RequestMapping(
            value="/updatePerson",
            method=RequestMethod.PUT,
            consumes=MediaType.APPLICATION_JSON_VALUE
    )
    public Person updatePerson( @RequestBody Person p) {
        return personServices.updatePerson( p);
    }
}
