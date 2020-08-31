package br.com.odonto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassWordGenerator {
	
	public static void main (String[] args) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassWord = "kabala";
		String encodedPassWord = encoder.encode(rawPassWord);//GERA UMA NOVA CODIFICAÇÃO A CADA MOMENTO!
		
		System.out.println(encodedPassWord);
		
	}

}
