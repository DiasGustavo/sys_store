package br.com.sisloja.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sisloja.dao.EstabelecimentoDAO;
import br.com.sisloja.dao.FuncionarioDAO;
import br.com.sisloja.dao.PessoaFisicaDAO;
import br.com.sisloja.domain.Estabelecimento;
import br.com.sisloja.domain.Funcionario;
import br.com.sisloja.domain.PessoaFisica;

public class FuncionarioDAOTest {
	@Test
	//@Ignore
	public void salvar(){
		FuncionarioDAO fdao = new FuncionarioDAO();		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setLogin("admin");
		funcionario.setSenha("200820e3227815ed1756a6b531e7e0d2");
		funcionario.setFuncao("gerente");
		
		PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
		PessoaFisica pf = pfdao.buscarPorCodigo(1L);
		
		funcionario.setPf(pf);
		
		EstabelecimentoDAO edao = new EstabelecimentoDAO();
		Estabelecimento estabelecimento = edao.buscarPorCodigo(1L);
		
		funcionario.setEstabelecimento(estabelecimento);
		
		fdao.salvar(funcionario);
		
	}
	@Test
	@Ignore
	public void listar(){
		FuncionarioDAO fdao = new FuncionarioDAO();
		List<Funcionario> funcionarios = fdao.listar();
		
		for(Funcionario funcionario: funcionarios){
			System.out.println(funcionario);
		}
	}
	@Test
	@Ignore
	public void buscarPorCodigo(){
		FuncionarioDAO fdao = new FuncionarioDAO();
		Funcionario funcionario = fdao.buscarPorCodigo(1L);
		
		System.out.println(funcionario);
	}
	
	@Test
	@Ignore
	public void editar(){
		FuncionarioDAO fdao = new FuncionarioDAO();
		Funcionario funcionario = fdao.buscarPorCodigo(1L);
		
		funcionario.setLogin("Gustavo");
		funcionario.setSenha("123456");
		
		fdao.editar(funcionario);
	}
	@Test
	@Ignore
	public void excluir(){
		FuncionarioDAO fdao = new FuncionarioDAO();
		Funcionario funcionario = fdao.buscarPorCodigo(1L);
		
		fdao.excluir(funcionario);
	}
	@Test
	@Ignore
	public void autenticar(){
		FuncionarioDAO fdao = new FuncionarioDAO();
		Funcionario funcionario = fdao.autenticar("admin", "qwe123");
		
		System.out.println(funcionario);
	}
}
