package br.com.sisloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sisloja.dao.EnderecoDAO;
import br.com.sisloja.dao.PessoaDAO;
import br.com.sisloja.domain.Endereco;
import br.com.sisloja.domain.Pessoa;
import br.com.sisloja.util.FacesUtil;

@ManagedBean
@ViewScoped
public class PessoaBean {
	
	private Pessoa pessoaCadastro;
	private List<Pessoa> listaPessoas;
	private List<Pessoa> listaPessoasFiltradas;
	
	private String acao;
	private Long codigo;
	private List<Endereco> listaEndereco;
	
	public Pessoa getPessoa() {
		if(pessoaCadastro == null){
			pessoaCadastro = new Pessoa();
		}
		return pessoaCadastro;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoaCadastro = pessoa;
	}
			
	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public List<Pessoa> getListaPessoasFiltradas() {
		return listaPessoasFiltradas;
	}

	public void setListaPessoasFiltradas(List<Pessoa> listaPessoasFiltradas) {
		this.listaPessoasFiltradas = listaPessoasFiltradas;
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
	
	public Pessoa getPessoaCadastro() {
		return pessoaCadastro;
	}

	public void setPessoaCadastro(Pessoa pessoaCadastro) {
		this.pessoaCadastro = pessoaCadastro;
	}
	
	public List<Endereco> getlistaEndereco() {
		return listaEndereco;
	}

	public void setlistaEndereco(List<Endereco> endereco) {
		this.listaEndereco = endereco;
	}

	public void novo(){
		pessoaCadastro = new Pessoa();
	}

	public void salvar(){
		try{
			PessoaDAO pdao = new PessoaDAO();
			pdao.salvar(pessoaCadastro);
			
			pessoaCadastro = new Pessoa();
			
			FacesUtil.addMsgInfo("Pessoa salva com sucesso.");
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao inserir a pessoa." + ex.getMessage());
		}
		
	}
	
	public void listar(){
		try{
			PessoaDAO pdao = new PessoaDAO();
			listaPessoas = pdao.listar();
			
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("Não foi possível listar as pessoas" + ex.getMessage());
		}
	}
	
	public void carregarCadastro(){
		try{
			
			if (codigo != null){
				PessoaDAO pdao = new PessoaDAO();
				pessoaCadastro = pdao.buscarPorCodigo(codigo);
			}else{
				pessoaCadastro = new Pessoa();
			}
			EnderecoDAO edao = new EnderecoDAO();
			listaEndereco = edao.listar();
			
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao carregar os dados da pessoa" + ex.getMessage());
		}
	}
	
	public void excluir(){
		try{
			PessoaDAO pdao = new PessoaDAO();
			pdao.excluir(pessoaCadastro);
									
			FacesUtil.addMsgInfo("Pessoa removida com sucesso.");
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao remover a pessoa." + ex.getMessage());
		}
	}
	
	public void editar(){
		try{
			PessoaDAO pdao = new PessoaDAO();
			pdao.editar(pessoaCadastro);
			
			FacesUtil.addMsgInfo("Pessoa editada com sucesso.");
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao editar os dados da pessoa." + ex.getMessage());
		}
		
	}
		
}
