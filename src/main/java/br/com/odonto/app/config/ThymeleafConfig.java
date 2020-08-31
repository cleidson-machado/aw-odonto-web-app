package br.com.odonto.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class ThymeleafConfig {
	
	//CRIADA PARA MUDAR E PERSONALIZAR A ROTA PADRÃO DAS VIEWS DO THYMELEAF
	
	@Bean
	public ClassLoaderTemplateResolver secondaryTemplateResolver() {
		
		ClassLoaderTemplateResolver secondaryTemplateResolver = new ClassLoaderTemplateResolver();
		
		secondaryTemplateResolver.setPrefix("templates/pages/");
		secondaryTemplateResolver.setCacheable(false);
        secondaryTemplateResolver.setSuffix(".html");
        secondaryTemplateResolver.setTemplateMode(TemplateMode.HTML);
        secondaryTemplateResolver.setCharacterEncoding("UTF-8");
        secondaryTemplateResolver.setOrder(1);
        secondaryTemplateResolver.setCheckExistence(true);
		
		return secondaryTemplateResolver;
		
	}

}
