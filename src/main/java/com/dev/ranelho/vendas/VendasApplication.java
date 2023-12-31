package com.dev.ranelho.vendas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@OpenAPIDefinition(info = @Info(title = "Vendas", version = "1.0.0", description = "Vendas"),
			servers = {@Server(url = "/vendas/api", description = "Default Server URL")})*/
@SpringBootApplication
public class VendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
