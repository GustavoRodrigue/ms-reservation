package com.school.msreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsreservaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsreservaApplication.class, args);
	}

}
