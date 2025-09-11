package com.physiobook.physiobook_receptionist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhysiobookReceptionistApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhysiobookReceptionistApplication.class, args);
	}
}