package br.com.sisloja.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sisloja.dao.PessoaDAO;
import br.com.sisloja.dao.PessoaFisicaDAO;
import br.com.sisloja.domain.Pessoa;
import br.com.sisloja.domain.PessoaFisica;

public class PessoaFisicaDAOTest {
	@Test
	//@Ignore
	public void salvar(){
		PessoaDAO pdao = new PessoaDAO();
		Pessoa pessoa = pdao.buscarPorCodigo(1L);
		
		PessoaFisica pessoaFisica = new PessoaFisica();
		pessoaFisica.setCpf("065.544.724-52");
		pessoaFisica.setRg("123112");
		
		pessoaFisica.setPessoa(pessoa);
		
		PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
		pfdao.salvar(pessoaFisica);
	}
	@Test
	@Ignore
	public void listar(){
		PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
		List<PessoaFisica> pfisicas = pfdao.listar();
		
		for(PessoaFisica pfisica: pfisicas){
			System.out.println(pfisica);
		}
	}
	@Test
	@Ignore
	public void buscarPorCodigo(){
		PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
		PessoaFisica pfisica = pfdao.buscarPorCodigo(1L);
		
		System.out.println(pfisica);
	}
	@Test
	@Ignore
	public void excluir(){
		PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
		PessoaFisica pfisica = pfdao.buscarPorCodigo(1L);
		
		pfdao.excluir(pfisica);
	}
	@Ignore
	@Test
	public void editar(){
		PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
		PessoaFisica pfisica = pfdao.buscarPorCodigo(2L);
		
		pfisica.setCpf("000.000.000-00");
		
		PessoaDAO pdao = new PessoaDAO();
		Pessoa pessoa = pdao.buscarPorCodigo(1L);
		
		pfisica.setPessoa(pessoa);
		
		pfdao.editar(pfisica);
		
	}
}
