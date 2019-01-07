package com.bsj.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
//@EnableHystrix
//@EnableHystrixDashboard
public class GroupServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(GroupServiceApplication.class, args);

	}

	// @Bean 需要时可以放在api中
	public ServletRegistrationBean<HystrixMetricsStreamServlet> getsBean() {
		HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean<HystrixMetricsStreamServlet> bean = new ServletRegistrationBean<>(
				hystrixMetricsStreamServlet, "/hystrix.stream");
		bean.setLoadOnStartup(1);
		return bean;
	}

}
