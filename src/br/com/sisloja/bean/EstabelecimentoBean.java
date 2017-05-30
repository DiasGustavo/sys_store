package br.com.sisloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sisloja.dao.EstabelecimentoDAO;
import br.com.sisloja.dao.PessoaJuridicaDAO;
import br.com.sisloja.domain.Estabelecimento;
import br.com.sisloja.domain.PessoaJuridica;
import br.com.sisloja.util.FacesUtil;

@ManagedBean
@ViewScoped
public class EstabelecimentoBean {

	private Estabelecimento estabelecimentoCadastro;
	private List<Estabelecimento> listaEstabelecimentos;
	private List<Estabelecimento> listaEstabelecimentosFiltrados;
	
	private String acao;
	private Long codigo;
	private List<PessoaJuridica> listaPjuridicas;
	
	public Estabelecimento getEstabelecimentoCadastro() {
		if (estabelecimentoCadastro == null){
			estabelecimentoCadastro = new Estabelecimento();
		}
		return estabelecimentoCadastro;
	}
	public void setEstabelecimentoCadastro(Estabelecimento estabelecimentoCadastro) {
		this.estabelecimentoCadastro = estabelecimentoCadastro;
	}
	public List<Estabelecimento> getListaEstabelecimentos() {
		return listaEstabelecimentos;
	}
	public void setListaEstabelecimentos(List<Estabelecimento> listaEstabelecimentos) {
		this.listaEstabelecimentos = listaEstabelecimentos;
	}
	public List<Estabelecimento> getListaEstabelecimentosFiltrados() {
		return listaEstabelecimentosFiltrados;
	}
	public void setListaEstabelecimentosFiltrados(List<Estabelecimento> listaEstabelecimentosFiltrados) {
		this.listaEstabelecimentosFiltrados = listaEstabelecimentosFiltrados;
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
	public List<PessoaJuridica> getListaPjuridicas() {
		return listaPjuridicas;
	}
	public void setListaPjuridicas(List<PessoaJuridica> listaPjuridicas) {
		this.listaPjuridicas = listaPjuridicas;
	}
	
	public void novo(){
		estabelecimentoCadastro = new Estabelecimento();
	}

	public void salvar(){
		try{
			EstabelecimentoDAO edao = new EstabelecimentoDAO();
			edao.salvar(estabelecimentoCadastro);
			
			estabelecimentoCadastro = new Estabelecimento();
			
			FacesUtil.addMsgInfo("Estabelecimento salvo com sucesso.");
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao inserir o estabelecimento. " + ex.getMessage());
		}
		
	}
	
	public void listar(){
		try{
			EstabelecimentoDAO edao = new EstabelecimentoDAO();
			listaEstabelecimentos = edao.listar();
			
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("Não foi possível listar os estabelecimentos. " + ex.getMessage());
		}
	}
	
	public void carregarCadastro(){
		try{
			
			if (codigo != null){
				EstabelecimentoDAO edao = new EstabelecimentoDAO();
				estabelecimentoCadastro = edao.buscarPorCodigo(codigo);
			}else{
				estabelecimentoCadastro = new Estabelecimento();
			}
			PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
			listaPjuridicas = pjdao.listar();			
			
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao carregar os dados do estabelecimento" + ex.getMessage());
		}
	}
	
	public void excluir(){
		try{
			EstabelecimentoDAO edao = new EstabelecimentoDAO();
			edao.excluir(estabelecimentoCadastro);
									
			FacesUtil.addMsgInfo("Estabelecimento removido com sucesso.");
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao remover o estabelecimento. " + ex.getMessage());
		}
	}
	
	public void editar(){
		try{
			EstabelecimentoDAO edao = new EstabelecimentoDAO();
			edao.editar(estabelecimentoCadastro);
			
			FacesUtil.addMsgInfo("Estabelecimento editado com sucesso.");
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao editar os dados do estabelecimento. " + ex.getMessage());
		}
		
	}
}
