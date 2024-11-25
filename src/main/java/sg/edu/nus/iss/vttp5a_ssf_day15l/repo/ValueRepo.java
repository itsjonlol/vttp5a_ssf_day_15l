package sg.edu.nus.iss.vttp5a_ssf_day15l.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_ssf_day15l.util.Util;

@Repository
public class ValueRepo {

    @Autowired
    @Qualifier(Util.template01)
    RedisTemplate<String,String> template;

    
    // slide24 - create.update a value
    public void createValue(String key,String value) {//set name "Fred Flintstone"
        template.opsForValue().set(key,value); // template.opsForValue().set("name","Fred Flintstone");

        // setifpresent
        // setifabsent
    }

    public String getValue(String key) { //get name
        return template.opsForValue().get(key);  //Optional<String> opt = Optional.ofNullable(template.opsForValue().get("name")));
        //if (opt.isPresent()) {String name = opt.get();}

    }
        //slide 27
    public Boolean deleteValue(String key) {//del email
        return template.delete(key);//tempalte.delete("email")

    }
    //26 - only works for key with integer value
    public void incrementValue(String key) { //incr count
        template.opsForValue().increment(key); //template.opsForValue().increment("count");
    }

    public void decrementValue(String key) {
        template.opsForValue().decrement(key);
    }

    public void incrementByValue(String key,Integer value) { //incryby count 10
        template.opsForValue().increment(key,value);//template.opsForValue().increment("count",10);
    }

    public void decrementByValue(String key,Integer value) {
        template.opsForValue().decrement(key,value);
    }

    public boolean checkExists(String key) {
        return template.hasKey(key); //boolean hasEmail = tempalte.hasKey("email");
    }




    
}
