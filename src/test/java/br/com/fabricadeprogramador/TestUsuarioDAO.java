package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;
import br.com.fabricadeprogramador.presistencia.entidade.Usuario;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testExcluir();
	}
	
	public static void testCadastrar(){
		Usuario usu = new Usuario();
		usu.setNome("Amon");
		usu.setLogin("amonroca");
		usu.setSenha("amon123");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);
		
		System.out.println("Cadastrado com sucesso");
	}
	
	public static void testAlterar(){
		Usuario usu = new Usuario();
		usu.setId(5);
		usu.setNome("Amon Goes Roca");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);
		
		System.out.println("Alterado com sucesso");
	}
	
	public static void testExcluir(){
		Usuario usu = new Usuario();
		usu.setId(5);
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);
		
		System.out.println("Excluido com sucesso");
	}

}
