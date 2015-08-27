package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;
import br.com.fabricadeprogramador.presistencia.entidade.Usuario;

@WebServlet("/autenticador.do")
public class AutenticadorController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null){
			session.invalidate();
		}
		resp.sendRedirect("login.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		Usuario usu = new Usuario();
		usu.setLogin(login);
		usu.setSenha(senha);
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario usuAutenticado = usuDAO.autenticar(usu);
		if(usuAutenticado != null){
			HttpSession session = req.getSession();
			session.setAttribute("usuAutenticado", usuAutenticado);
			session.setMaxInactiveInterval(60*5);
			req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
		}
		else{
			resp.getWriter().print("<script>window.alert('Não encontrado!');location.href='login.html';</script>");
		}
		
	}

}
