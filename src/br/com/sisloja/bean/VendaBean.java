package br.com.sisloja.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.sisloja.dao.FuncionarioDAO;
import br.com.sisloja.dao.ItemVendaDAO;
import br.com.sisloja.dao.ProdutoDAO;
import br.com.sisloja.dao.VendaDAO;
import br.com.sisloja.domain.Funcionario;
import br.com.sisloja.domain.ItemVenda;
import br.com.sisloja.domain.Produto;
import br.com.sisloja.domain.Venda;
import br.com.sisloja.util.FacesUtil;

@ManagedBean
@ViewScoped
public class VendaBean {
	
	private Venda vendaCadastro;
	private List<Produto> listaProdutos;
	private List<Produto> listaProdutosFiltrados;
	
	@ManagedProperty(value = "#{autenticacaoBean}")
	private AutenticacaoBean autenticacaoBean;

	private List<ItemVenda> listaItens;

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public List<Produto> getListaProdutosFiltrados() {
		return listaProdutosFiltrados;
	}

	public void setListaProdutosFiltrados(List<Produto> listaProdutosFiltrados) {
		this.listaProdutosFiltrados = listaProdutosFiltrados;
	}

	public List<ItemVenda> getListaItens() {
		if (listaItens == null) {
			listaItens = new ArrayList<>();
		}
		return listaItens;
	}

	public void setListaItens(List<ItemVenda> listaItens) {
		this.listaItens = listaItens;
	}
		
	public Venda getVendaCadastro() {
		if (vendaCadastro == null){
			vendaCadastro = new Venda();
			vendaCadastro.setValorTotal(new BigDecimal("0.00"));
		}
		return vendaCadastro;
	}

	public void setVendaCadastro(Venda vendaCadastro) {
		this.vendaCadastro = vendaCadastro;
	}
	
	public AutenticacaoBean getAutenticacaoBean() {
		return autenticacaoBean;
	}

	public void setAutenticacaoBean(AutenticacaoBean autenticacaoBean) {
		this.autenticacaoBean = autenticacaoBean;
	}

	public void listarProdutos() {
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			listaProdutos = pdao.listar();

		} catch (RuntimeException ex) {
			FacesUtil.addMsgError("Não foi possível listar os produtos. " + ex.getMessage());
		}
	}

	public void adicionarItens(Produto produto) {

		int posicaoEncontrada = -1;

		for (int pos = 0; pos < listaItens.size() && posicaoEncontrada < 0; pos++) {
			ItemVenda itemTemp = listaItens.get(pos);
			if (itemTemp.getProduto().equals(produto)) {
				posicaoEncontrada = pos;
			}
		}

		ItemVenda item = new ItemVenda();
		item.setProduto(produto);

		if (posicaoEncontrada < 0) {
			item.setQuantidade(1);
			item.setValorUnitario(produto.getPrecoVenda());
			listaItens.add(item);
		} else {
			ItemVenda itemTemp = listaItens.get(posicaoEncontrada);
			item.setQuantidade(itemTemp.getQuantidade() + 1);
			item.setValorUnitario(produto.getPrecoVenda().multiply(new BigDecimal(item.getQuantidade())));
			listaItens.set(posicaoEncontrada, item);
		}
		
		vendaCadastro.setValorTotal(vendaCadastro.getValorTotal().add(produto.getPrecoVenda()));
	}

	public void remover(ItemVenda item) {
		int posicaoEncontrada = -1;

		for (int pos = 0; pos < listaItens.size() && posicaoEncontrada < 0; pos++) {
			ItemVenda itemTemp = listaItens.get(pos);
			if (itemTemp.getProduto().equals(item.getProduto())) {
				posicaoEncontrada = pos;
			}
		}
		
		if (posicaoEncontrada > -1){
			listaItens.remove(posicaoEncontrada);
			vendaCadastro.setValorTotal(vendaCadastro.getValorTotal().subtract(item.getValorUnitario()));
		}
	}
	
	public void carregarDadosVenda(){
		FuncionarioDAO fdao = new FuncionarioDAO();
		Funcionario funTemp = fdao.buscarPorCodigo(autenticacaoBean.getFuncionarioLogado().getId());
		vendaCadastro.setFuncionario(funTemp);
	}
	
	public void salvar(){
		try{
			VendaDAO vdao = new VendaDAO();
			Long codigoVenda = vdao.salvar(vendaCadastro);
			
			Venda vendaTemp = vdao.buscarPorCodigo(codigoVenda);
			
			for(ItemVenda itemVenda : listaItens){
				itemVenda.setVenda(vendaTemp);
				
				ItemVendaDAO ivdao = new ItemVendaDAO();
				ivdao.salvar(itemVenda);
			}
			
			vendaCadastro = new Venda();
			vendaCadastro.setValorTotal(new BigDecimal("0.00"));
			
			listaItens = new ArrayList<>(); 
			
			FacesUtil.addMsgInfo("Venda salva com sucesso.");
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("Erro ao salvar a venda: " + ex.getMessage());
		}
	}
}
