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
    public void createValue(String key,String value) {
        template.opsForValue().set(key,value);

        // setifpresent
        // setifabsent
    }

    public String getValue(String key) {
        return template.opsForValue().get(key); 
        

    }
        //slide 27
    public Boolean deleteValue(String key) {
        return template.delete(key);

    }
    //26 - only works for key with integer value
    public void incrementValue(String key) {
        template.opsForValue().increment(key);
    }

    public void decrementValue(String key) {
        template.opsForValue().decrement(key);
    }

    public void incrementByValue(String key,Integer value) {
        template.opsForValue().increment(key,value);
    }

    public void decrementByValue(String key,Integer value) {
        template.opsForValue().decrement(key,value);
    }

    public boolean checkExists(String key) {
        return template.hasKey(key);
    }




    
}
