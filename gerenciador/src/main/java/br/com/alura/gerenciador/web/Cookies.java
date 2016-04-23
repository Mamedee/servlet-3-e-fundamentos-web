package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Cookies {
	private Cookie[] cookies;
	
	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;
	}
	
	public Cookie buscaUsuarioLogado() {
		
		if (cookies == null) {
			return null;
		}
		
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuario.logado")) {
				//Define o tempo máximo do cookie. Porém, como está no filtro,
				//a cada requisição do usuário, há uma renovação do cookie, prorrogando por mais 10 min.
				//cookie.setMaxAge(10*60);
				//resp.addCookie(cookie);
				return cookie;
			}
		}
		
		return null;
	}
}
