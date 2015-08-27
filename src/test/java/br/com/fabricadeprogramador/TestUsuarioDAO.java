package br.com.fabricadeprogramador;

import java.util.List;

import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;
import br.com.fabricadeprogramador.presistencia.entidade.Usuario;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testAutenticar();
	}
	
	public static void testAutenticar() {
		// TODO Auto-generated method stub
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usu = new Usuario();
		usu.setLogin("jjj");
		usu.setSenha("123");
		Usuario retorno = usuarioDAO.autenticar(usu);
		System.out.println(retorno);
	}

	public static void testBuscarTodos() {
		// TODO Auto-generated method stub
		UsuarioDAO usuDAO = new UsuarioDAO();
		List<Usuario> list = usuDAO.buscarTodos();
		for(Usuario u: list){
			System.out.println(u);
		}
	}

	public static void testBuscaPorId() {
		// TODO Auto-generated method stub
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario usu = usuDAO.buscaPorId(4);
		System.out.println(usu);
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
	
	public static void testSalvar(){
		Usuario usu = new Usuario();
		usu.setId(3);
		usu.setNome("Maria da Silva");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usu);
		
		System.out.println("Salvo com sucesso");
	}

}
