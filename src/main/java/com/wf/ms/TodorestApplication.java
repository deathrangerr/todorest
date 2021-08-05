//package com.wf.ms;

//import io.prometheus.client.Counter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodorestApplication {

	static final Counter requests = Counter.build()
     .name("requests_total").help("Total requests.").register();


	public static void main(String[] args) {
		SpringApplication.run(TodorestApplication.class, args);
	}

}
