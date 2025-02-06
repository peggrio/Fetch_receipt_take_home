package com.fetch.receipt;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Receipt microservice REST API Documentation",
				description = "Receipt Microservice REST API Documentation",
				version = "1.0",
				contact = @Contact(
						name = "Peizhen Liao",
						email = "peizhenliao23@gmail.com",
						url = "https://github.com/peggrio"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.apache.org/licenses/LICENSE-2.0"
				)
		)
)
public class ReceiptApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReceiptApplication.class, args);
	}

}
