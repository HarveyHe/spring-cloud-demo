package cn.org.harvey.feign;

import cn.org.harvey.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


//@FeignClient(value = "provider-demo",configuration = Configuration.class)修改契约为Feign的契约
@FeignClient(value = "provider-demo")
public interface UserFeignClient {

  @GetMapping (value = "/user/getUser/{id}")
  public User getUser(@PathVariable("id")Long id);

 /* //当修改契约为Feign的契约时使用
// @RequestLine("GET /user/getUser/{id}")
  public User getUser(@Param("id") Long id);*/
}
