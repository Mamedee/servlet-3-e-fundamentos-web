package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String uri = request.getRequestURI();
		
		//String usuario = getUsuario(request);
		
		/*Cookie cookie = new Cookies(request.getCookies()).buscaUsuarioLogado();
		if (cookie != null) {
			cookie.setMaxAge(10*60);
			response.addCookie(cookie);
		}*/
		
		//HttpSession session = request.getSession();
		String usuario = getUsuario(request);
		
		System.out.println("Usuário " + usuario + " acessando " + uri);
		filterChain.doFilter(request, resp);
	}

	private String getUsuario(HttpServletRequest request) {
		Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
		
		if (usuarioLogado == null) {
			return "<deslogado>";
		}
		else {
			return usuarioLogado.getEmail();
		}
	}

	/*private String getUsuario(HttpServletRequest request) {
		
		String usuario = "<deslogado>";
		
		Cookie cookie = new Cookies(request.getCookies()).buscaUsuarioLogado();
		
		if (cookie == null) return "<deslogado>";
		
		return cookie.getValue();
	}*/

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
