package br.com.sisloja.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sisloja.dao.FornecedorDAO;
import br.com.sisloja.dao.PessoaJuridicaDAO;
import br.com.sisloja.domain.Fornecedor;
import br.com.sisloja.domain.PessoaJuridica;


public class FornecedorDAOTest {
	@Test
	@Ignore
	public void salvar(){
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setInsEstadual("1233");
		fornecedor.setInsMunicipal("fadfad");
		
		PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
		PessoaJuridica pj = pjdao.buscarPorCodigo(1L);
		
		fornecedor.setPj(pj);
		
		FornecedorDAO fdao = new FornecedorDAO();
		fdao.salvar(fornecedor);
		
		
	}
	@Test
	@Ignore
	public void listar(){
		FornecedorDAO fdao = new FornecedorDAO();
		
		List<Fornecedor> fornecedores = fdao.listar();
		
		for (Fornecedor fornecedor: fornecedores){
			System.out.println(fornecedor);
		}
	}
	@Test
	@Ignore
	public void buscarPorCodigo(){
		FornecedorDAO fdao = new FornecedorDAO();
		Fornecedor fornecedor = fdao.buscarPorCodigo(1L);
		
		System.out.println(fornecedor);
	}
	
	@Test
	@Ignore
	public void editar(){
		FornecedorDAO fdao = new FornecedorDAO();
		Fornecedor fornecedor = fdao.buscarPorCodigo(1L);
		
		fornecedor.setInsEstadual("123213");
		fornecedor.setInsMunicipal("12313");
		
		PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
		PessoaJuridica pj  = pjdao.buscarPorCodigo(1L);
		
		fornecedor.setPj(pj);
		
		fdao.editar(fornecedor);
	}
	@Test
	public void excluir(){
		FornecedorDAO fdao = new FornecedorDAO();
		Fornecedor fornecedor = fdao.buscarPorCodigo(1L);
		
		fdao.excluir(fornecedor);
	}
}
