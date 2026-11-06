package in.balu.feignclients;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
@LoadBalancerClient
public interface ProductFeignClient {

    @GetMapping("products/exists/{productId}")
    public boolean isProductExists(@PathVariable Long productId);

}
