package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.presistencia.entidade.Usuario;

public class UsuarioDAO {
	
	private Connection con = ConexaoFactory.getConnection();

	public void cadastrar(Usuario usu) {
		// TODO Auto-generated method stub
		String sql = "insert into usuario (nome, login, senha) values (?, ?, ?)";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			
			preparador.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void alterar(Usuario usu) {
		// TODO Auto-generated method stub
		String sql = "update usuario set nome=? where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, usu.getNome());
			preparador.setInt(2, usu.getId());
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void excluir(Usuario usu) {
		// TODO Auto-generated method stub
		String sql = "delete from usuario where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setInt(1, usu.getId());
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void salvar(Usuario usu) {
		// TODO Auto-generated method stub
		if(usu.getId() != null){
			alterar(usu);
		}
		else{
			cadastrar(usu);
		}
		
	}
	
	public Usuario buscaPorId(Integer id){
		String sql = "select * from usuario where id = ?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setInt(1, id);
			ResultSet resultado = preparador.executeQuery();
			if(resultado.next()){
				Usuario usu = new Usuario();
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setLogin(resultado.getString("login"));
				usu.setSenha(resultado.getString("senha"));
				
				return usu;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Usuario> buscarTodos(){
		String sql = "select * from usuario";
		List<Usuario> list = new ArrayList<Usuario>();
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			ResultSet resultado = preparador.executeQuery();
			while(resultado.next()){
				Usuario usu = new Usuario();
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setLogin(resultado.getString("login"));
				usu.setSenha(resultado.getString("senha"));
				list.add(usu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
