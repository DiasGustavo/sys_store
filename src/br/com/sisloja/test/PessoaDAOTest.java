package br.com.sisloja.test;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sisloja.dao.EnderecoDAO;
import br.com.sisloja.dao.PessoaDAO;
import br.com.sisloja.domain.Endereco;
import br.com.sisloja.domain.Pessoa;

public class PessoaDAOTest {
	@Test
	//@Ignore
	public void salvar(){
		Pessoa p1 = new Pessoa();
				
		p1.setNome("software.com");
		p1.setTelefone("(083)9999-8888");
		p1.setEmail("teste@teste.com");
		
		p1.setSexo("M");
		p1.setStatus("A");
		
		p1.setDataNascimento(new Date());
		
		EnderecoDAO edao = new EnderecoDAO();
		Endereco endereco = edao.buscarPorCodigo(1L);
		
		p1.setEndereco(endereco);
				
		PessoaDAO dao = new PessoaDAO();
		dao.salvar(p1);
		
	}
	@Test
	@Ignore
	public void listar(){
		PessoaDAO dao = new PessoaDAO();
		List<Pessoa> pessoas = dao.listar();
		
		for (Pessoa pessoa:pessoas){
			System.out.println(pessoa);
		}
	}
	@Test
	@Ignore
	public void buscarPorCodigo(){
		PessoaDAO dao = new PessoaDAO();
		Pessoa p1 = dao.buscarPorCodigo(2L);
		
		System.out.println(p1);
	}
	@Test
	@Ignore
	public void excluir(){
		PessoaDAO dao = new PessoaDAO();
		
		Pessoa p1 = dao.buscarPorCodigo(2L);
		dao.excluir(p1);
	}
	
	@Test
	@Ignore
	public void excluirPorCodigo(){
		PessoaDAO dao = new PessoaDAO();
		
		dao.excluir(1L);
	}
	
	@Test
	@Ignore
	public void editar(){
		PessoaDAO dao = new PessoaDAO();
		Pessoa pessoa = dao.buscarPorCodigo(2L);
		
		pessoa.setEmail("testeemail");
		pessoa.setNome("francisco");
		pessoa.setTelefone("21");
		
		dao.editar(pessoa);
	}
}
