package cn.org.harvey.controller;

import cn.org.harvey.domain.User;
//import com.alibaba.csp.sentinel.Entry;
//import com.alibaba.csp.sentinel.EntryType;
//import com.alibaba.csp.sentinel.SphU;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {



    @GetMapping(value = "/getUser/{id}")
    public User getUser(@PathVariable Long id){
        User user=new User();
        user.setId(id);
        user.setName("张三 v1");
        user.setAge(18);
        return user;
    }
    @GetMapping(value = "/getName")
    public String getName(){
        return "张三";
    }
    
    
    @GetMapping("/testSentinel")
    public @ResponseBody
    String testSentinel() {
        String resourceName = "hello";
//        Entry entry = null;
        String retVal = null;
//        try{
//            entry = SphU.entry(resourceName, EntryType.IN);
//            retVal = "passed";
//        }catch(BlockException e){
//            retVal = "blocked";
//        }finally {
//            if(entry!=null){
//                entry.exit();
//            }
//        }
        return retVal;
    }
}
