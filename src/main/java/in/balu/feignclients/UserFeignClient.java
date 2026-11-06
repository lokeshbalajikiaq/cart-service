package in.balu.feignclients;

import in.balu.dto.UserDto;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
@LoadBalancerClient
public interface UserFeignClient {

    @GetMapping("/api/users/{userId}")
    public UserDto fetchUser(@PathVariable("userId") Integer userId);

}
