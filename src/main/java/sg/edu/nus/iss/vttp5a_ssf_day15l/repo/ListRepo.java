package sg.edu.nus.iss.vttp5a_ssf_day15l.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_ssf_day15l.util.Util;

@Repository
public class ListRepo {
    
    @Autowired
    @Qualifier(Util.template01)
    RedisTemplate<String,String> template;

    //create 
    public void leftPush(String redisKey, String value) { //lpush cart apple
        template.opsForList().leftPush(redisKey, value); //template.opsForList().leftpush("cart","apple");
    }
    public void rightPush(String redisKey, String value) {
        template.opsForList().rightPush(redisKey, value);
    }
    //can pop by count or by key. // can i get the string directly?
    public void leftPop(String redisKey) { //lpop cart
        template.opsForList().leftPop(redisKey,1); //template.opsForList().leftpop("cart");
    }
    public void rightPop(String redisKey) {
        template.opsForList().leftPop(redisKey,1);
    }

    //get value at index
    public String getValueAtIndex(String redisKey, Integer index) { //lindex cart 1
        return template.opsForList().index(redisKey,index); // String item = tempalte.opsForList().index("cart",1L);

    }
    //update value at index
    public void updateListValue(String redisKey, int index, String newValue) {
        template.opsForList().set(redisKey, index, newValue); //-LSET cart 1 "grape"

    } 
    
    //size
    public Long size(String redisKey) { //lllreen cart
        return template.opsForList().size(redisKey); //long cartLen = template.opsForlist().size("cart");
    }
    //key is the list
    public List<String> getList(String redisKey) {
        List<String> list = template.opsForList().range(redisKey,0,-1); //lrange redisKey 0 -1
        return list;
    }
    //Delete
    public Boolean delete(String redisKey,Integer count, String value) {//lrem cart 1 apple or "apple"
        Boolean isDeleted = false;
        Long iFound = template.opsForList().remove(redisKey,count,value);
        /*
         * Removes elements equal to the value:
         * - count > 0: Remove `count` occurrences from the head (left).
         * - count < 0: Remove `count` occurrences from the tail (right).
         * - count == 0: Remove all occurrences of the value.
         */
        
        
        if (iFound>0) {
            isDeleted = true;
        }
        return isDeleted;
        
        
    }

    // public Boolean deleteItem(String key, String valueToDelete) {
    //     Boolean isDeleted = false;

    //     List<String> retrievedList = template.opsForList().range(key,0,-1);
    //     String[] splitData = valueToDelete.toString().split(",");
    //     //find then delete
    //     // Long iFound = template.opsForList().indexOf(key, valueToDelete);

    //     // if (iFound>=0) {
    //     //     template.opsForList().remove(key,1,valueToDelete);
    //     //     isDeleted = true;
    //     // }
    //     // return isDeleted;
    //     Optional<String> tempString = retrievedList.stream().filter(p -> p.toString().contains(splitData[2])).findFirst();

    //     int iFound = -1;
    //     if (tempString.isPresent()) {
    //         for(int i = 0;  i < retrievedList.size(); i++) {
    //             if (retrievedList.get(i).contains(splitData[2])) {
    //                 iFound = i;
    //                 break;
    //             }
    //         }
    //     }

    //     String data = template.opsForList().index(Util.keyPerson, iFound);

    //     System.out.println("valueToDelete: " + valueToDelete.toString());
    //     System.out.println("tempString: " + tempString);
    //     System.out.println("tempString: " + tempString.toString());


    //     if (iFound >= 0) {
    //         template.opsForList().remove(key, 1, data);
    //         isDeleted = true;
    //     }

    //     return isDeleted;
    // }

    
}
