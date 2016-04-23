package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet  {
	
	//static Map<String, String> USUARIOS_LOGADOS = new HashMap<>();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		if (usuario == null) {
			writer.println("<html><body>Usuário ou senha inválida.</body></html>");
		} else {
			
			//String codigoAleatorio = "" + System.currentTimeMillis() + "/" + Math.random();
			//USUARIOS_LOGADOS.put(codigoAleatorio, email);
			
			//Cookie cookie = new Cookie("usuarioLogado", codigoAleatorio);
			//cookie.setMaxAge(10*60); //Define a duração do cookie sem prorrogação.
			//resp.addCookie(cookie);
			
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			writer.println("<html><body>Usuário logado: " + usuario.getEmail() + "</body></html>");
		}
	}
	
}
