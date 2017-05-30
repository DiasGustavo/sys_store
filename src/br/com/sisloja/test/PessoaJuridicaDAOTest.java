package br.com.sisloja.test;

import org.junit.Test;

import br.com.sisloja.dao.PessoaDAO;
import br.com.sisloja.dao.PessoaJuridicaDAO;
import br.com.sisloja.domain.Pessoa;
import br.com.sisloja.domain.PessoaJuridica;

public class PessoaJuridicaDAOTest {
	@Test
	public void salvar(){
		PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
		PessoaJuridica pj = new PessoaJuridica();
		
		pj.setCnpj("92.461.867/0001-62");
		pj.setRazaoSocial("sousa");
		pj.setNomeFantazia("teste");
		
		PessoaDAO pdao = new PessoaDAO();
		Pessoa pessoa = pdao.buscarPorCodigo(2L);
		
		pj.setPessoa(pessoa);
		
		pjdao.salvar(pj);
		
				
	}
}
