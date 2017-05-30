package br.com.sisloja.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sisloja.dao.EstabelecimentoDAO;
import br.com.sisloja.dao.PessoaJuridicaDAO;
import br.com.sisloja.domain.Estabelecimento;
import br.com.sisloja.domain.PessoaJuridica;

public class EstabelecimentoDAOTest {
	@Test
	//@Ignore
	public void salvar(){
		EstabelecimentoDAO edao = new EstabelecimentoDAO();
		Estabelecimento estabelecimento = new Estabelecimento();
		estabelecimento.setAtividade("comercio");
		
		PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
		PessoaJuridica pj = pjdao.buscarPorCodigo(1L);
		estabelecimento.setPj(pj);
		
		edao.salvar(estabelecimento);
		
		
	}
	@Test
	@Ignore
	public void listar(){
		EstabelecimentoDAO edao = new EstabelecimentoDAO();
		List<Estabelecimento> estabelecimentos = edao.listar();
		
		for (Estabelecimento estabelecimento: estabelecimentos){
			System.out.println(estabelecimento);
		}
	}
	@Test
	@Ignore
	public void buscarPorCodigo(){
		EstabelecimentoDAO edao = new EstabelecimentoDAO();
		Estabelecimento estabelecimento = edao.buscarPorCodigo(1L);
		
		System.out.println(estabelecimento);
	}
	@Test
	@Ignore
	public void editar(){
		EstabelecimentoDAO edao = new EstabelecimentoDAO();
		Estabelecimento estabelecimento = edao.buscarPorCodigo(1L);
		
		estabelecimento.setAtividade("serviços");
		
		PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
		PessoaJuridica pj = pjdao.buscarPorCodigo(1L);
		
		estabelecimento.setPj(pj);
		
		edao.editar(estabelecimento);
	}
	
	@Test
	@Ignore
	public void excluir(){
		EstabelecimentoDAO edao = new EstabelecimentoDAO();
		Estabelecimento estabelecimento = edao.buscarPorCodigo(1L);
		
		edao.excluir(estabelecimento);
	}

}
