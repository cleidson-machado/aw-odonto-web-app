package br.com.odonto.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppDefaultController {
	
	@RequestMapping(path="/" , method=RequestMethod.GET)
	public String goHome() {
		
		//EXEMPLO VOLTANDO AO DIRETÓRIO PADRÃO ROOT DO APP
		//return "../indexAppRoot";
		
		//EXEMPLO USANDO SUB DIRETÓRIOS PARA OS MODEL VIEW
		//return "/cliente/index";
		
		//EXEMPLO USANDO NOVO / MODIFICADO DIRETÓRIO PADRÃO NO APP
		return "indexApp";
		
		//TESTES AFINS
		//return "/contratante/Index";		
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "/aLoginApp/login";
	}
	
	@PostMapping("/login_success_handler")
	public String loginSuccessHandler() {
		System.out.println("Login Success Handler...");
		//return "indexApp";
		return "redirect:/";
	}
	
	@PostMapping("/login_failure_handler")
	public String loginFailureHandler() {
		System.out.println("Login Failure Handler...");
		return "/aLoginApp/login_error";
	}

}
