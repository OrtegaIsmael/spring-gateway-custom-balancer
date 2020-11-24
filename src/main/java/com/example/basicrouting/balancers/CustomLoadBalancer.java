package com.example.basicrouting.balancers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.*;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Slf4j
public class CustomLoadBalancer extends RoundRobinLoadBalancer {

	public CustomLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider,
							  String serviceId) {
		super(serviceInstanceListSupplierProvider, serviceId);
	}

	@Override
	public Mono<Response<ServiceInstance>> choose(Request request) {
		Object context = request.getContext();
		if (context == null) {
			log.warn("Request context null");
		}else if (!(context instanceof ServerWebExchange)) {
			log.warn("Request context is not an ServerWebExchange");
		}
		return super.choose(request);
	}
}
