package com.andreymironov.iactestback;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@Slf4j
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		log.debug(String.format("%s::main(args: %s)", App.class.getName(), args.toString()));
		SpringApplication.run(App.class, args);
	}

	@PostConstruct
	void postConstruct() {
		log.debug(String.format("%s::postConstruct()", this.getClass().getName()));
		// set time zone to prevent date collisions while database handling
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
