package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout implements IAcao {
	//@Override
	//protected void doPost (HttpServletRequest request, HttpServletResponse response) 
	//		throws ServletException, IOException{
		/*Cookie[] cookies = request.getCookies();
		
		Cookie cookie = new Cookies(request.getCookies()).buscaUsuarioLogado();
		cookie.setMaxAge(0); //Mata a sessão do doido.
		response.addCookie(cookie);*/
		
		//HttpSession session = request.getSession();
		//session.removeAttribute("usuarioLogado");
		
		//PrintWriter writer = response.getWriter();
		
		//writer.println("<html><body>Usuário " + cookie.getValue() + " desconectado.</body></html>");
		//writer.println("<html><body>Usuário " + session.getId() + " desconectado.</body></html>");
		
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/logout.html");
		dispatcher.forward(request, response);*/
		
	//}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("usuarioLogado");
		return "/WEB-INF/paginas/logout.html";
	}
}
