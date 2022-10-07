package pos_java_jdbc.pos_java_jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc{
	
	@Test
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setNome("jorgin");
		userposjava.setEmail("jorgin.teste@gmail.com");
		
		userPosDAO.salvar(userposjava);
	}
	
	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();
			
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("-------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			Userposjava userposjava = dao.buscar(4L);
			System.out.println(userposjava);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initAtualizar() {
		try {
			UserPosDAO dao = new UserPosDAO();
		
			Userposjava objetoBanco = dao.buscar(2L);
			
			objetoBanco.setNome("Nome atualizado");
			
			dao.atualizar(objetoBanco);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initDeletar() {
		
		try {
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(5L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBancoTelefone() {
		Telefone telefone = new Telefone();
		telefone.setNumero("18681616");
		telefone.setTipo("celular");
		telefone.setUsuario(7L);
		
		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
	}
	
	@Test
	public void testeCarregaFonesUser() {
		UserPosDAO dao = new UserPosDAO();
		
		List<BeanUserFone> list = dao.listaUserFone(7L);
		
		for (BeanUserFone beanUserFone : list) {
			System.out.println(beanUserFone);
			System.out.println("--------------------------------");
		}
	}
	
	@Test
	public void testeDeleteUserFone() {
		UserPosDAO dao = new UserPosDAO();
		dao.deleteFonesPorUser(7L);
	}
}
