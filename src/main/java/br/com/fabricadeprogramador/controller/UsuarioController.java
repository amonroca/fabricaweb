package br.com.fabricadeprogramador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;
import br.com.fabricadeprogramador.presistencia.entidade.Usuario;

@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet{
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String acao = req.getParameter("acao");
		if(acao.equals("exc")){
			String id = req.getParameter("id");
			Usuario usu = new Usuario();
			if(id != null)
				usu.setId(Integer.parseInt(id));
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuDAO.excluir(usu);
			resp.sendRedirect("usucontroller.do?acao=lis");
		}
		else if(acao.equals("lis")){
			UsuarioDAO usuDAO = new UsuarioDAO();
			List<Usuario> list = usuDAO.buscarTodos();
			req.setAttribute("list", list);
			RequestDispatcher dispacher =  req.getRequestDispatcher("WEB-INF/listausu.jsp");
			dispacher.forward(req, resp);
		}
		else if(acao.equals("alt")){
			String id = req.getParameter("id");
			UsuarioDAO usuDAO = new UsuarioDAO();
			Usuario usu = usuDAO.buscaPorId(Integer.parseInt(id));
			req.setAttribute("usu", usu);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formusuario.jsp");
			dispatcher.forward(req, resp);
		}
		else if(acao.equals("cad")){
			Usuario usu = new Usuario();
			usu.setId(0);
			usu.setLogin("");
			usu.setNome("");
			usu.setSenha("");
			req.setAttribute("usu", usu);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formusuario.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		Usuario usu = new Usuario();
		if(id != null)
			usu.setId(Integer.parseInt(id));
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usu);
		resp.getWriter().print("<h1>Sucesso</h1>");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
}
