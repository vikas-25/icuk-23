package com.oms.customer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OmsCustomerServiceApplication {
	
	private static final Logger LOGGER = LogManager.getLogger(OmsCustomerServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info(">> main() from OmsCustomerServiceApplication");
		SpringApplication.run(OmsCustomerServiceApplication.class, args);
		LOGGER.info("<< main() from OmsCustomerServiceApplication");
	}
}
