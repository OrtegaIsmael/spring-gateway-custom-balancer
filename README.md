# spring-gateway-custom-balancer
This is a basic implementation of Spring Cloud Gateway without discovery service and using a custom balancer.

The custom balancer for now is RoundRobinLoadBalancer extended, but the intention is to make a Sticky Balancer taking a header that will tell to 
which cluster need to go the request.
