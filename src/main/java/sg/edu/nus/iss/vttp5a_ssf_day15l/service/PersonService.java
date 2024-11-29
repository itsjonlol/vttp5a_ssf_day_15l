package sg.edu.nus.iss.vttp5a_ssf_day15l.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_ssf_day15l.model.Person;
import sg.edu.nus.iss.vttp5a_ssf_day15l.repo.ListRepo;

@Service
public class PersonService {
    
    @Autowired
    ListRepo personRepo;

    List<Person> persons = new ArrayList<>();
    
    public void addPerson(String redisKey,Person person) {
        personRepo.rightPush(redisKey,person.toString()); // you want to add the stirng variable
    }



    public List<Person> findAll(String redisKey) {

        List<String> listData = personRepo.getList(redisKey);
        List<Person> persons = new ArrayList<>();

        for(String data: listData) {
            String [] rawData = data.split(",");
            Person p = new Person(Integer.parseInt(rawData[0]), rawData[1], rawData[2]);
            persons.add(p);

        }
        return persons;
    }

    
    public Boolean delete(String redisKey,Person person) {
        return personRepo.delete(redisKey, 1, person.toString());
    }
}
