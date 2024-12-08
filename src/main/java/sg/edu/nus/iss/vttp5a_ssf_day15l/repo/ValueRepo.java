package sg.edu.nus.iss.vttp5a_ssf_day15l.repo;

import java.time.Duration;

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
    public void createValue(String redisKey,String value) {//set name "Fred Flintstone"
        template.opsForValue().set(redisKey,value); // template.opsForValue().set("name","Fred Flintstone");

        // setifpresent
        // setifabsent
    }

    public void updateValue(String redisKey,String value) {
        template.opsForValue().set(redisKey,value);
    }

    public String getValue(String redisKey) { //get name
        return template.opsForValue().get(redisKey);  //Optional<String> opt = Optional.ofNullable(template.opsForValue().get("name")));
        //if (opt.isPresent()) {String name = opt.get();}

    }
        //slide 27
    public Boolean deleteValue(String redisKey) {//del email
        return template.delete(redisKey);//tempalte.delete("email")

    }
    //26 - only works for key with integer value
    public void incrementValue(String redisKey) { //incr count
        template.opsForValue().increment(redisKey); //template.opsForValue().increment("count");
    }

    public void decrementValue(String redisKey) {
        template.opsForValue().decrement(redisKey);
    }

    public void incrementByValue(String redisKey,Integer value) { //incryby count 10
        template.opsForValue().increment(redisKey,value);//template.opsForValue().increment("count",10);
    }

    public void decrementByValue(String redisKey,Integer value) {
        template.opsForValue().decrement(redisKey,value);
    }

    public boolean checkExists(String redisKey) {
        return template.hasKey(redisKey); //boolean hasEmail = tempalte.hasKey("email");
    }

    //expire key 
    //SET myKey "myValue" EX 10
    // SETEX myKey 10 "myValue"

    public void expireKey(String redisKey, Long seconds) {
        Duration expireDuration = Duration.ofSeconds(seconds);
        template.expire(redisKey, expireDuration);
    }



    
}
