package com.shukldi.spring_secuirty;

import com.shukldi.spring_secuirty.auth.AuthenticationService;
import com.shukldi.spring_secuirty.auth.RegistrationRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import static com.shukldi.spring_secuirty.user.Role.ADMIN;
import static com.shukldi.spring_secuirty.user.Role.MANAGER;

@SpringBootApplication
@EnableMethodSecurity
public class SpringSecuirtyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecuirtyApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(AuthenticationService authenticationService) {
		return args -> {
			var admin = RegistrationRequest.builder()
					.firstName("Divyanshu")
					.lastName("Shukla")
					.email("div@4q35.com")
					.password("daev")
					.role(ADMIN)
					.build();
			System.out.printf("Admin: " + authenticationService.register(admin).getToken());

			var manager = RegistrationRequest.builder()
					.firstName("manager")
					.lastName("manager")
					.email("divdsafdd@4q35.com")
					.password("dfev")
					.role(MANAGER)
					.build();
			System.out.printf(" Manager: " + authenticationService.register(manager).getToken());
		};
	}
}
