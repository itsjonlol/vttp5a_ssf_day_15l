package sg.edu.nus.iss.vttp5a_ssf_day15l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.vttp5a_ssf_day15l.model.Person;
import sg.edu.nus.iss.vttp5a_ssf_day15l.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    PersonService personService;
    
    @GetMapping("")
    public String getPersonList(Model model) {
        List<Person> persons = personService.findAll("persons");
        model.addAttribute("persons",persons);

        return "personlist";
        
        
    }
    @GetMapping("/create")
    public String showCreatePage(Model model) {
        Person p = new Person();
        model.addAttribute("person",p);
        return "personcreate";

    }
}
