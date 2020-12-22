package de.zlucic.controller;

import de.zlucic.data.model.Person;
import de.zlucic.data.vo.PersonVO;
import de.zlucic.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    // @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{id}")
    public PersonVO findById(@PathVariable(value = "id") Long id) {
        return personServices.findById( id);
    }

    //@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public List<PersonVO> findAll() {
        return personServices.findAll();
    }

    /*@RequestMapping(
            value="/addPerson",
            method=RequestMethod.POST,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE
            )*/
    @PostMapping
    public PersonVO addPerson( @RequestBody PersonVO person)
    {
        return personServices.addPerson( person);
    }

    /*@RequestMapping(
            value="/deletePerson/{id}",
            method=RequestMethod.DELETE)*/
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable(value="id") Long id) {
        personServices.deletePerson( id);
        return ResponseEntity.ok().build();
    }

    /*@RequestMapping(
            value="/updatePerson",
            method=RequestMethod.PUT,
            consumes=MediaType.APPLICATION_JSON_VALUE*/
    @PutMapping
    public PersonVO updatePerson( @RequestBody PersonVO p) {
        return personServices.updatePerson( p);
    }
}
