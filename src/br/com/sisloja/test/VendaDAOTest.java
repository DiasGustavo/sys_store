package br.com.sisloja.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sisloja.dao.FuncionarioDAO;
import br.com.sisloja.dao.VendaDAO;
import br.com.sisloja.domain.Funcionario;
import br.com.sisloja.domain.Venda;

public class VendaDAOTest {
	@Test
	@Ignore
	public void salvar(){
		VendaDAO vdao = new VendaDAO();
		Venda venda = new Venda();
		
		venda.setValorTotal(new BigDecimal(2.50));
		
		FuncionarioDAO fdao = new FuncionarioDAO();
		Funcionario funcionario = fdao.buscarPorCodigo(2L);
		
		venda.setFuncionario(funcionario);
		vdao.salvar(venda);
	}
	@Test
	@Ignore
	public void listar(){
		VendaDAO vdao = new VendaDAO();
		List<Venda> vendas = vdao.listar();
		
		for(Venda venda: vendas){
			System.out.println(venda);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		VendaDAO vdao = new VendaDAO();
		Venda venda = vdao.buscarPorCodigo(1L);
		
		System.out.println(venda);
	}
	@Test
	@Ignore
	public void editar(){
		VendaDAO vdao = new VendaDAO();
		Venda venda = vdao.buscarPorCodigo(1L);
		
		venda.setValorTotal(new BigDecimal(2.00));
		
		vdao.editar(venda);
	}
	@Test
	@Ignore
	public void excluir(){
		VendaDAO vdao = new VendaDAO();
		Venda venda = vdao.buscarPorCodigo(2L);
		
		vdao.excluir(venda);
	}
}
