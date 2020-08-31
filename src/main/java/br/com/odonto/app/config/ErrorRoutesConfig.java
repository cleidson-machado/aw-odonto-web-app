package br.com.odonto.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//CLASSE ESPECIALIZADA NAS ROTAS DE LOGIN E LOGOUT
//TRABALHA COMO UM CONTROLLER MAS DA ACESSO A OUTROS REFINAMENTOS DE CONFIGURAÇÃO MVC NATIVO DO THYMELEAF.

@Configuration
public class ErrorRoutesConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/login_success").setViewName("/aLoginApp/login_success");
		//registry.addViewController("/login_error").setViewName("/aLoginApp/login_error");
		registry.addViewController("/logout_success").setViewName("/aLogoutApp/logout_success");
		
		//TESTE E TENTATIVA DE CARREGAMENTE EXTERNO ANTES DE LOGIN.. AQUI ANO FUNCIONA AINDA!
		registry.addViewController("/rescue_pass").setViewName("/aLogoutApp/forget_pass");
	}

}