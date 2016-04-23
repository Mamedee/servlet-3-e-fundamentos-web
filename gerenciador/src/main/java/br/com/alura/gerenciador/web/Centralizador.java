package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/centralizador")
public class Centralizador extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String acao = request.getParameter("acao");
		
		if (acao == null) {
			throw new IllegalArgumentException("Você esqueceu de passar a tarefa.");
		}
		
		String classe = "br.com.alura.gerenciador.web." + acao;
		
		try {
			Class<?> type = Class.forName(classe);
			IAcao instancia = (IAcao) type.newInstance();
			String pagina = instancia.executa(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
	}
}
