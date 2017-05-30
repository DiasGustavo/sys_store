package br.com.sisloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sisloja.dao.ProdutoDAO;
import br.com.sisloja.domain.Produto;
import br.com.sisloja.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	private Produto produtoCadastro;
	private List<Produto> listaProdutos;
	private List<Produto> listaProdutosFiltrados;
	
	private String acao;
	private Long codigo;
	public Produto getProdutoCadastro() {
		return produtoCadastro;
	}
	public void setProdutoCadastro(Produto produtoCadastro) {
		this.produtoCadastro = produtoCadastro;
	}
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
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public void novo(){
		produtoCadastro = new Produto();
	}
	
	public void salvar(){
		try{
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.salvar(produtoCadastro);
			
			FacesUtil.addMsgInfo("Produto salvo com sucesso.");
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("Erro ao inserir o produto." + ex.getMessage());
		}
	}
	
	public void listar(){
		try{
			ProdutoDAO pdao = new ProdutoDAO();
			listaProdutos = pdao.listar();
			
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Não foi possível listar os produtos. " + ex.getMessage());
		}
	}
	
	public void carregarCadastro(){
		try{
			if(codigo != null){
				ProdutoDAO pdao = new ProdutoDAO();
				produtoCadastro = pdao.buscarPorCodigo(codigo);
			}else {
				produtoCadastro = new Produto();
			}
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("Erro ao carregar os dados do produto. " + ex.getMessage());
		}
	}
	
	public void excluir(){
		try{
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.excluir(produtoCadastro);
			
			FacesUtil.addMsgInfo("Produto removido com sucesso.");
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("Erro ao remover o produto. " + ex.getMessage());
		}
	}
	
	public void editar(){
		try{
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.editar(produtoCadastro);
			
			FacesUtil.addMsgInfo("Produto editado com sucesso.");
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao editar os dados do produto. " + ex.getMessage());
		}
	}
}
