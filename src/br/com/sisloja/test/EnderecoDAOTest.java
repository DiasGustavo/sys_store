package br.com.sisloja.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sisloja.dao.EnderecoDAO;
import br.com.sisloja.domain.Endereco;

public class EnderecoDAOTest {
	@Test
	//@Ignore
	public void salvar(){
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua felizardo leite");
		endereco.setNumero(30);
		endereco.setCep("58700-030");
		endereco.setComplemento("casa");
		endereco.setCidade("Patos");
		endereco.setEstado("Paraíba");
		endereco.setBairro("centro");

		
		EnderecoDAO edao = new EnderecoDAO();
		edao.salvar(endereco);
		
	}
	@Test
	@Ignore
	public void listar(){
		EnderecoDAO edao = new EnderecoDAO();
		List<Endereco> enderecos = edao.listar();
		
		for (Endereco endereco:enderecos){
			System.out.println(endereco);
		}
		
	}
	@Test
	@Ignore
	public void buscarPorCodigo(){
		EnderecoDAO edao = new EnderecoDAO();
		Endereco endereco = edao.buscarPorCodigo(1L);
		
		System.out.println(endereco);
	}
	
	@Test
	@Ignore
	public void excluir(){
		EnderecoDAO edao = new EnderecoDAO();
		Endereco endereco = edao.buscarPorCodigo(1L);
		
		edao.excluir(endereco);
	}
	@Test
	@Ignore
	public void editar(){
		EnderecoDAO edao = new EnderecoDAO();
		Endereco endereco = edao.buscarPorCodigo(2L);
		
		endereco.setLogradouro("Rua do Prado");
		endereco.setNumero(0);
		endereco.setComplemento("casa");
		endereco.setBairro("Centro");
		endereco.setCep("58700-001");
		endereco.setCidade("Patos");
		endereco.setEstado("PB");
			
		
		edao.editar(endereco);
	}

}
