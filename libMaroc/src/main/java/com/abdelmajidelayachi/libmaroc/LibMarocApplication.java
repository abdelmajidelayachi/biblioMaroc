package com.abdelmajidelayachi.libmaroc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.abdelmajidelayachi.libmaroc"})
		public class LibMarocApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibMarocApplication.class, args);
	}

}
