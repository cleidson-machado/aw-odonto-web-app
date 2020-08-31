package br.com.odonto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OdondoContractRebuldApplication  {
		
	//GERENCIA O MODO COMO A APLICAÇÃO INICIA E SE COMPORTA DEPOIS???
	//extends SpringBootServletInitializer
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {		
//		return builder.sources(OdondoContractRebuldApplication.class);
//	}

	public static void main(String[] args) {
		SpringApplication.run(OdondoContractRebuldApplication.class, args);
	}

}
