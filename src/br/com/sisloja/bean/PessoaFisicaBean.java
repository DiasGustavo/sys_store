package br.com.sisloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sisloja.dao.PessoaDAO;
import br.com.sisloja.dao.PessoaFisicaDAO;
import br.com.sisloja.domain.Pessoa;
import br.com.sisloja.domain.PessoaFisica;
import br.com.sisloja.util.FacesUtil;

@ManagedBean
@ViewScoped
public class PessoaFisicaBean {
	
	private PessoaFisica pfisicaCadastro;
	private List<PessoaFisica> listaPFisicas;
	private List<PessoaFisica> listaPFisicasFiltradas;
	
	private String acao;
	private Long codigo;	
	private List<Pessoa> listaPessoas;

	public PessoaFisica getPfisicaCadastro() {
		if (pfisicaCadastro == null){
			pfisicaCadastro = new PessoaFisica();
		}
		return pfisicaCadastro;
	}

	public void setPfisicaCadastro(PessoaFisica pfisicaCadastro) {
		this.pfisicaCadastro = pfisicaCadastro;
	}

	public List<PessoaFisica> getListaPFisicas() {
		return listaPFisicas;
	}

	public void setListaPFisicas(List<PessoaFisica> listaPFisicas) {
		this.listaPFisicas = listaPFisicas;
	}

	public List<PessoaFisica> getListaPFisicasFiltradas() {
		return listaPFisicasFiltradas;
	}

	public void setListaPFisicasFiltradas(List<PessoaFisica> listaPFisicasFiltradas) {
		this.listaPFisicasFiltradas = listaPFisicasFiltradas;
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

	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}
	
	public void novo(){
		pfisicaCadastro = new PessoaFisica();
	}

	public void salvar(){
		try{
			PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
			pfdao.salvar(pfisicaCadastro);
			
			pfisicaCadastro = new PessoaFisica();
			
			FacesUtil.addMsgInfo("Pessoa Física salva com sucesso.");
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao inserir a pessoa física. " + ex.getMessage());
		}
		
	}
	
	public void listar(){
		try{
			PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
			listaPFisicas = pfdao.listar();
			
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("Não foi possível listar as pessoas físicas. " + ex.getMessage());
		}
	}
	
	public void carregarCadastro(){
		try{
			
			if (codigo != null){
				PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
				pfisicaCadastro = pfdao.buscarPorCodigo(codigo);
			}else{
				pfisicaCadastro = new PessoaFisica();
			}
			PessoaDAO pdao = new PessoaDAO();
			listaPessoas = pdao.listar();
			
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao carregar os dados da pessoa física. " + ex.getMessage());
		}
	}
	
	public void excluir(){
		try{
			PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
			pfdao.excluir(pfisicaCadastro);
									
			FacesUtil.addMsgInfo("Pessoa física removida com sucesso.");
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao remover a pessoa física. " + ex.getMessage());
		}
	}
	
	public void editar(){
		try{
			PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
			pfdao.editar(pfisicaCadastro);
			
			FacesUtil.addMsgInfo("Pessoa Física editada com sucesso.");
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao editar os dados da pessoa física. " + ex.getMessage());
		}
		
	}
}
