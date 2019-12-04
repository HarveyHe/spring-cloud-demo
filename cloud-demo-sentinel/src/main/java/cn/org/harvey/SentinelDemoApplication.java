package cn.org.harvey;

//import com.alibaba.csp.sentinel.Entry;
//import com.alibaba.csp.sentinel.SphU;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
//import com.alibaba.csp.sentinel.slots.block.RuleConstant;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import cn.org.harvey.handler.TestException;
import cn.org.harvey.handler.SentinelExceptionHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
//@EnableEurekaClient
public class SentinelDemoApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SentinelDemoApplication.class, args);
        initFlowRules();

//
//
//
//        initFlowRules();
//        int index = 0 ;
//        while (true) {
//            Entry entry = null;
//            try {
//                entry = SphU.entry("HelloWorld");
//                /*您的业务逻辑 - 开始*/
//                System.out.println("hello world :" + index);
//                /*您的业务逻辑 - 结束*/
//            } catch (BlockException e1) {
//                /*流控逻辑处理 - 开始*/
//                System.out.println("block!");
//
////                System.exit(0);
//                /*流控逻辑处理 - 结束*/
//            } finally {
//                if (entry != null) {
//                    entry.exit();
//                }
//            }
//            index++;
//        }
    }

    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("hello");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(10);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
    
    @Slf4j
    @RestController
    static class TestController {
        
        @GetMapping("/hello2")
//        @SentinelResource("hello")
        @SentinelResource(value = "hello", blockHandlerClass = SentinelExceptionHandler.class, blockHandler = "blockExceptionHandle")
        public String hello() {
            return "didispace.com";
        }
    
        @GetMapping("/hey")
        @SentinelResource("hey")
        public String hey() throws InterruptedException {
            Thread.sleep(2000);
            return "hey";
        }
    
    
        // 对应的 `handleException` 函数需要位于 `ExceptionUtil` 类中，并且必须为 static 函数.
//        @SentinelResource(value = "test", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
//        public void test() {
//            System.out.println("Test");
//        }
//
        // 原函数
        @GetMapping("/hello3")
        @SentinelResource(value = "hello", blockHandler = "exceptionHandler", fallback = "helloFallback",fallbackClass = TestException.class,blockHandlerClass = TestException.class)
        public String hello3() {
            return String.format("Hello at %d", 0);
        }
        @GetMapping("/hello4")
        @SentinelResource(value = "hello", blockHandler = "exceptionHandler", fallback = "helloFallback",fallbackClass = TestException.class,blockHandlerClass = TestException.class)
        public String hello4() {
            throw new RuntimeException("Ex for");
        }
    
        
    }
}
