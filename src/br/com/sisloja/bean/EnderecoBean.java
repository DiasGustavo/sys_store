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
public class EnderecoBean {

	private Endereco enderecoCadastro;
	private List<Endereco> listaEnderecos;
	private List<Endereco> listaEnderecosFiltrados;
	
	private String acao;
	private Long codigo;
	private List<Pessoa> listaPessoa;
	
	public Endereco getEnderecoCadastro() {
		if (enderecoCadastro == null){
			enderecoCadastro = new Endereco(); 
		}
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
	
	public void salvar(){
		try{
			EnderecoDAO edao = new EnderecoDAO();
			edao.salvar(enderecoCadastro);
			
			FacesUtil.addMsgInfo("Endereço salvo com sucesso.");
		}catch (RuntimeException ex){
			FacesUtil.addMsgError("Erro ao inserir o endereço." + ex.getMessage());
		}
	}
	
	public void listar(){
		try{
			EnderecoDAO edao = new EnderecoDAO();
			listaEnderecos = edao.listar();
			
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("Não foi possível listar os endereços " + ex.getMessage());
		}
	}
	
	public void carregarCadastro(){
		try{
			if (codigo != null){
				EnderecoDAO edao = new EnderecoDAO();
				enderecoCadastro = edao.buscarPorCodigo(codigo);
			}else{
				enderecoCadastro = new Endereco();
			}
			
			PessoaDAO pdao = new PessoaDAO();
			listaPessoa = pdao.listar();
			
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("Erro ao carregar os dados do endereco " + ex.getMessage());
		}
	}
	
	public void excluir(){
		try{
			EnderecoDAO edao = new EnderecoDAO();
			edao.excluir(enderecoCadastro);
			
			FacesUtil.addMsgInfo("Endereço removido com sucesso.");
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("Erro ao remover o endereço. " + ex.getMessage());
		}
	}
	
	public void editar(){
		try{
			EnderecoDAO edao = new EnderecoDAO();
			edao.editar(enderecoCadastro);
			
			FacesUtil.addMsgInfo("Endereço editado com sucesso.");
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("Erro ao editar os dados do endereço. " + ex.getMessage());
		}
	}
}
