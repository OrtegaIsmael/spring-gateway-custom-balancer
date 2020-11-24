package com.example.basicrouting.config;

import com.example.basicrouting.balancers.CustomLoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BalancerConfig {

    @Bean
    @Primary
    public ReactorLoadBalancer<ServiceInstance> reactorServiceInstanceLoadBalancer(LoadBalancerClientFactory loadBalancerClientFactory) {
        return new CustomLoadBalancer(
                loadBalancerClientFactory.getLazyProvider(Constants.SERVICE, ServiceInstanceListSupplier.class), Constants.SERVICE);
    }
}
