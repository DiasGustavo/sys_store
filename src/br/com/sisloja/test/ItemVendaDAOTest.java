package br.com.sisloja.test;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.sisloja.dao.ItemVendaDAO;
import br.com.sisloja.dao.ProdutoDAO;
import br.com.sisloja.dao.VendaDAO;
import br.com.sisloja.domain.ItemVenda;
import br.com.sisloja.domain.Produto;
import br.com.sisloja.domain.Venda;

public class ItemVendaDAOTest {
	@Test
	public void salvar(){
		ItemVendaDAO idao = new ItemVendaDAO();
		ItemVenda item = new ItemVenda();
		item.setDescricao("baixo");
		item.setQuantidade(20);
		item.setValorUnitario(new BigDecimal(3.90));
		
		
		VendaDAO vdao = new VendaDAO();
		Venda venda = vdao.buscarPorCodigo(1L);
		
		item.setVenda(venda);
		
		ProdutoDAO pdao = new ProdutoDAO();
		Produto produto = pdao.buscarPorCodigo(1L);
		
		item.setProduto(produto);
		
		idao.salvar(item);
		
	}
}
