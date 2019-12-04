package cn.org.harvey.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestException {
    
    final static Logger logger = LoggerFactory.getLogger(TestException.class);
    
    // Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
    public static String helloFallback() {
        return String.format("Halooooo %d", 1);
    }
    
    // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public static String exceptionHandler(BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + 2;
    }
    
    
}
