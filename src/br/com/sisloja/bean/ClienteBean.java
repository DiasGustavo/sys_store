package br.com.sisloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sisloja.dao.EnderecoDAO;
import br.com.sisloja.dao.PessoaDAO;
import br.com.sisloja.dao.PessoaFisicaDAO;
import br.com.sisloja.domain.Endereco;
import br.com.sisloja.domain.Pessoa;
import br.com.sisloja.domain.PessoaFisica;
import br.com.sisloja.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ClienteBean {
	//dados dos endereços
	private Endereco enderecoCadastro;
	private List<Endereco> listaEnderecos;
	private List<Endereco> listaEnderecosFiltrados;
	//dados das pessoas
	private Pessoa pessoaCadastro;
	private List<Pessoa> listaPessoas;
	private List<Pessoa> listaPessoasFiltradas;
	//dados das pessoas fisicas
	private PessoaFisica pfisicaCadastro;
	private List<PessoaFisica> listaPFisicas;
	private List<PessoaFisica> listaPFisicasFiltradas;	
	
	private String acao;
	private Long codigo;
	private List<Pessoa> listaPessoa;
	
	public Endereco getEnderecoCadastro() {
		return enderecoCadastro;
	}
	public void setEnderecoCadastro(Endereco enderecoCadastro) {
		this.enderecoCadastro = enderecoCadastro;
	}
	public List<Endereco> getListaEnderecos() {
		return listaEnderecos;
	}
	public void setListaEnderecos(List<Endereco> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}
	public List<Endereco> getListaEnderecosFiltrados() {
		return listaEnderecosFiltrados;
	}
	public void setListaEnderecosFiltrados(List<Endereco> listaEnderecosFiltrados) {
		this.listaEnderecosFiltrados = listaEnderecosFiltrados;
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
		enderecoCadastro = new Endereco();
	}
	
	//dados das pessoas
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
	
	public Pessoa getPessoaCadastro() {
		return pessoaCadastro;
	}

	public void setPessoaCadastro(Pessoa pessoaCadastro) {
		this.pessoaCadastro = pessoaCadastro;
	}
	
	//dados das pessoas fisicas
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
	
	public void salvar(){
		try{
			
			EnderecoDAO edao = new EnderecoDAO();
			edao.salvar(enderecoCadastro);
			
			PessoaDAO pdao = new PessoaDAO();
			pdao.salvar(pessoaCadastro);
			
			PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
			pfdao.salvar(pfisicaCadastro);
			
			FacesUtil.addMsgInfo("Cliente salva com sucesso.");
			
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("Não foi possível cadastrar o cliente:  " + ex.getMessage());
		}
	}
}
