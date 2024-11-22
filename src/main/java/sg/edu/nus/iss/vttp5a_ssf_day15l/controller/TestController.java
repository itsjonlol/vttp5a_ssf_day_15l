package sg.edu.nus.iss.vttp5a_ssf_day15l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.vttp5a_ssf_day15l.model.Person;
import sg.edu.nus.iss.vttp5a_ssf_day15l.service.PersonService;


@Controller
@RequestMapping("/tests")
public class TestController {

    @Autowired
    PersonService personSvc;
    
    @ResponseBody
    @GetMapping("/add")
    public String addPerson() {
        Person p = new Person(1,"darryl","darryl@nus.edu.sg");
        personSvc.addPerson("persons",p);
        p = new Person(2,"jon","jonsu@gmail.com");
        personSvc.addPerson("persons", p);
        p = new Person(3,"cena","cena@gmail.com");
        personSvc.addPerson("persons", p);
        return "added persons successfully";
        
    }
    @ResponseBody
    @GetMapping("/persons")
    public List<Person> personFindAll() {
        return personSvc.findAll("persons");
    }
    
    @ResponseBody
    @GetMapping("/delete")
    public Boolean deletePerson() {
        Person p = new Person(3,"cena","cena@gmail.com");
        return personSvc.delete("persons",p);

    }
}
