package cn.org.harvey.handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class SentinelExceptionHandler {
    
    final static Logger logger = LoggerFactory.getLogger(SentinelExceptionHandler.class);
    
    public static String blockExceptionHandle(BlockException exception) {
        exception.printStackTrace();
        logger.info("sentinel 熔断处理 {}", "SentinelExceptionHandler");
        return "Sentinel 熔断处理函数";
    }
 

}
