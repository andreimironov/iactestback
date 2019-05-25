package com.andreymironov.iactestback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TimeZone;

@Slf4j
@SpringBootApplication
public class App {
	private static String HOME = System.getProperty("user.home");

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		log.debug(String.format("home dir: %s", HOME));
		log.debug(String.format("is writable: %s", Files.isWritable(Paths.get(HOME))));
	}

	@PostConstruct
	void postConstruct() {
		// set time zone to prevent date collisions while database handling
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
