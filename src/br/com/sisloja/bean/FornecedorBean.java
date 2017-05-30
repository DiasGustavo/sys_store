package br.com.sisloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sisloja.dao.FornecedorDAO;
import br.com.sisloja.dao.PessoaJuridicaDAO;
import br.com.sisloja.domain.Fornecedor;
import br.com.sisloja.domain.PessoaJuridica;
import br.com.sisloja.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FornecedorBean {
	
	private Fornecedor fornecedorCadastro;
	private List<Fornecedor> listaFornecedores;
	private List<Fornecedor> listaFornecedoresFiltrados;
	
	private String acao;
	private Long codigo;
	
	private List<PessoaJuridica> listaPJuridicas;

	public Fornecedor getFornecedorCadastro() {
		if(fornecedorCadastro == null){
			fornecedorCadastro = new Fornecedor();
		}
		return fornecedorCadastro;
	}

	public void setFornecedorCadastro(Fornecedor fornecedorCadastro) {
		this.fornecedorCadastro = fornecedorCadastro;
	}

	public List<Fornecedor> getListaFornecedores() {
		return listaFornecedores;
	}

	public void setListaFornecedores(List<Fornecedor> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
	}

	public List<Fornecedor> getListaFornecedoresFiltrados() {
		return listaFornecedoresFiltrados;
	}

	public void setListaFornecedoresFiltrados(List<Fornecedor> listaFornecedoresFiltrados) {
		this.listaFornecedoresFiltrados = listaFornecedoresFiltrados;
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

	public List<PessoaJuridica> getListaPJuridicas() {
		return listaPJuridicas;
	}

	public void setListaPJuridicas(List<PessoaJuridica> listaPJuridicas) {
		this.listaPJuridicas = listaPJuridicas;
	}
	
	public void novo(){
		fornecedorCadastro = new Fornecedor();
	}

	public void salvar(){
		try{
			FornecedorDAO fdao = new FornecedorDAO();
			fdao.salvar(fornecedorCadastro);
			
			fornecedorCadastro = new Fornecedor();
			
			FacesUtil.addMsgInfo("Fornecedor salvo com sucesso.");
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao inserir o Fornecedor. " + ex.getMessage());
		}
		
	}
	
	public void listar(){
		try{
			FornecedorDAO fdao = new FornecedorDAO();
			listaFornecedores = fdao.listar();
			
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("Não foi possível listar os fornecedores. " + ex.getMessage());
		}
	}
	
	public void carregarCadastro(){
		try{
			
			if (codigo != null){
				FornecedorDAO fdao = new FornecedorDAO();
				fornecedorCadastro = fdao.buscarPorCodigo(codigo);
			}else{
				fornecedorCadastro = new Fornecedor();
			}
			PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
			listaPJuridicas = pjdao.listar();
			
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao carregar os dados do fornecedor. " + ex.getMessage());
		}
	}
	
	public void excluir(){
		try{
			FornecedorDAO fdao = new FornecedorDAO();
			fdao.excluir(fornecedorCadastro);
									
			FacesUtil.addMsgInfo("Fornecedor removida com sucesso.");
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao remover o fornecedor. " + ex.getMessage());
		}
	}
	
	public void editar(){
		try{
			FornecedorDAO fdao = new FornecedorDAO();
			fdao.editar(fornecedorCadastro);
			
			FacesUtil.addMsgInfo("Fornecedor editado com sucesso.");
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao editar os dados do fornecedor. " + ex.getMessage());
		}
		
	}
}
