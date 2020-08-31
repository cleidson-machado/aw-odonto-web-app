package br.com.odonto.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception{
		authBuilder.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(new BCryptPasswordEncoder())
			.usersByUsernameQuery("SELECT email1, current_password, user_enable FROM usuario WHERE email1=?")
			.authoritiesByUsernameQuery("SELECT email1, role FROM usuario WHERE email1=?")
			;
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/contratante").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
			.permitAll()
			.loginPage("/login")//AQUI VAI A ROTA NA CONTROLLER
			.usernameParameter("nome")// VAI O NOME DO CAMPO NA VIEW HTML
			.passwordParameter("password")// VAI O NOME DO CAMPO NA VIEW HTML
			.loginProcessingUrl("/doLogin")//ALTERA ROTA ABSTRATA EMBUTIDA NO FRAMEWORK P/ PROCESSO DE LOGIN
			
			//USA UMA CONTROLLER ESPECIAL ErrorRoutesConfig.JAVA
			//.defaultSuccessUrl("/login_success")//AQUI DA USAR SE O .loginProcessingUrl("/doLogin") ESTIVER PADRAO
			
			//USA UMA CONTROLLER ESPECIAL ErrorRoutesConfig.JAVA
			//.failureUrl("/login_error")//REDIRECIONA A PAGINA INTERNA APENAS
			
			//USA UMA CONTROLLER NORMAL AppDefaultController.java
			.successForwardUrl("/login_success_handler")
			
			//USA UMA CONTROLLER NORMAL AppDefaultController.java
			.failureForwardUrl("/login_failure_handler")
			
		.and()
		.logout()
			.permitAll()
			.logoutUrl("/doLogout")//ALTERA ROTA ABSTRATA EMBUTIDA NO FRAMEWORK P/ PROCESSO DE LOGOUT
			.logoutSuccessUrl("/logout_success")
		;
	}
	

}
