package br.com.sisloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sisloja.dao.PessoaDAO;
import br.com.sisloja.dao.PessoaJuridicaDAO;
import br.com.sisloja.domain.Pessoa;
import br.com.sisloja.domain.PessoaJuridica;
import br.com.sisloja.util.FacesUtil;

@ManagedBean
@ViewScoped
public class PessoaJuridicaBean {

	private PessoaJuridica pjuridicaCadastro;
	private List<PessoaJuridica> listaPjuridica;
	private List<PessoaJuridica> listaPjuridicaFiltrada;
	
	private String acao;
	private Long codigo;
	private List<Pessoa> listaPessoa;
	
	public PessoaJuridica getPjuridicaCadastro() {
		if (pjuridicaCadastro == null){
			pjuridicaCadastro = new PessoaJuridica();
		}
		return pjuridicaCadastro;
	}
	public void setPjuridicaCadastro(PessoaJuridica pjuridica) {
		this.pjuridicaCadastro = pjuridica;
	}
	public List<PessoaJuridica> getListaPjuridica() {
		return listaPjuridica;
	}
	public void setListaPjuridica(List<PessoaJuridica> listaPjuridica) {
		this.listaPjuridica = listaPjuridica;
	}
	public List<PessoaJuridica> getListaPjuridicaFiltrada() {
		return listaPjuridicaFiltrada;
	}
	public void setListaPjuridicaFiltrada(List<PessoaJuridica> listaPjuridicaFiltrada) {
		this.listaPjuridicaFiltrada = listaPjuridicaFiltrada;
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
	
	public List<Pessoa> getListaPessoa() {
		return listaPessoa;
	}
	public void setListaPessoa(List<Pessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}
	public void novo(){
		pjuridicaCadastro = new PessoaJuridica();
	}
	
	public void salvar(){
		try{
			PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
			pjdao.salvar(pjuridicaCadastro);
			
			pjuridicaCadastro = new PessoaJuridica();
			
			FacesUtil.addMsgInfo("Pessoa Jur�dica salva com sucesso.");
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao inserir a pessoa jur�dica. " + ex.getMessage());
		}
		
	}
	
	public void listar(){
		try{
			PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
			listaPjuridica = pjdao.listar();
			
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("N�o foi poss�vel listar as pessoas jur�dicas. " + ex.getMessage());
		}
	}
	
	public void carregarCadastro(){
		try{
			
			if (codigo != null){
				PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
				pjuridicaCadastro = pjdao.buscarPorCodigo(codigo);
			}else{
				pjuridicaCadastro = new PessoaJuridica();
			}
			PessoaDAO pdao = new PessoaDAO();
			listaPessoa = pdao.listar();
			
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao carregar os dados da pessoa jur�dica. " + ex.getMessage());
		}
	}
	
	public void excluir(){
		try{
			PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
			pjdao.excluir(pjuridicaCadastro);
									
			FacesUtil.addMsgInfo("Pessoa juridica removida com sucesso.");
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao remover a pessoa jur�dica. " + ex.getMessage());
		}
	}
	
	public void editar(){
		try{
			PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
			pjdao.editar(pjuridicaCadastro);
			
			FacesUtil.addMsgInfo("Pessoa Jur�cia editada com sucesso.");
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao editar os dados da pessoa jur�dica. " + ex.getMessage());
		}
		
	}
	
}
