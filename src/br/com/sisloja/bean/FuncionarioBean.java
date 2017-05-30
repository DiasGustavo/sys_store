package br.com.sisloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.sisloja.dao.EstabelecimentoDAO;
import br.com.sisloja.dao.FuncionarioDAO;
import br.com.sisloja.dao.PessoaFisicaDAO;
import br.com.sisloja.domain.Estabelecimento;
import br.com.sisloja.domain.Funcionario;
import br.com.sisloja.domain.PessoaFisica;
import br.com.sisloja.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean {

	Funcionario funcionarioCadastro;
	List<Funcionario> listaFuncionarios;
	List<Funcionario> listaFuncionariosFiltrados;
	
	private String acao;
	private Long codigo;
	
	private List<PessoaFisica> listaPfisicas;
	private List<Estabelecimento> listaEstabelecimentos;
	
	public Funcionario getFuncionario(){
		if (funcionarioCadastro == null){
			funcionarioCadastro = new Funcionario();
		}
		return funcionarioCadastro;
	}
	
	public void setFuncionario(Funcionario funcionario){
		this.funcionarioCadastro = funcionario;
	}
	
	public Funcionario getFuncionarioCadastro() {
		return funcionarioCadastro;
	}
	public void setFuncionarioCadastro(Funcionario funcionarioCadastro) {
		this.funcionarioCadastro = funcionarioCadastro;
	}
	public List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}
	public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}
	public List<Funcionario> getListaFuncionariosFiltrados() {
		return listaFuncionariosFiltrados;
	}
	public void setListaFuncionariosFiltrados(List<Funcionario> listaFuncionariosFiltrados) {
		this.listaFuncionariosFiltrados = listaFuncionariosFiltrados;
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
	public List<PessoaFisica> getListaPfisicas() {
		return listaPfisicas;
	}

	public void setListaPfisicas(List<PessoaFisica> listaPfisicas) {
		this.listaPfisicas = listaPfisicas;
	}

	public List<Estabelecimento> getListaEstabelecimentos() {
		return listaEstabelecimentos;
	}

	public void setListaEstabelecimentos(List<Estabelecimento> listaEstabelecimentos) {
		this.listaEstabelecimentos = listaEstabelecimentos;
	}

	public void novo(){
		funcionarioCadastro = new Funcionario();
	}
	
	public void salvar(){
		try{
			FuncionarioDAO fdao = new FuncionarioDAO();
			funcionarioCadastro.setSenha(DigestUtils.md5Hex(funcionarioCadastro.getSenha()));
			fdao.salvar(funcionarioCadastro);
			
			FacesUtil.addMsgInfo("Funcionário adicionado com sucesso.");
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("Erro ao inserir o funcionário " + ex.getMessage());
		}
	}
	
	public void listar(){
		try{
			FuncionarioDAO fdao = new FuncionarioDAO();
			listaFuncionarios = fdao.listar();
			
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("Não foi possível listar os funcionários " + ex.getMessage());
		}
	}
	
	public void carregarCadastro (){
		try{
			if(codigo != null){
				FuncionarioDAO fdao = new FuncionarioDAO();
				funcionarioCadastro = fdao.buscarPorCodigo(codigo);
			}else{
				funcionarioCadastro = new Funcionario();
			}
			PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
			listaPfisicas = pfdao.listar();
			
			EstabelecimentoDAO edao = new EstabelecimentoDAO();
			listaEstabelecimentos = edao.listar();
			
		}catch( RuntimeException ex){
			FacesUtil.addMsgError("Erro ao carregar os dados do funcionário " + ex.getMessage());
		}
	}
	
	public void excluir(){
		try{
			FuncionarioDAO fdao = new FuncionarioDAO();
			fdao.excluir(funcionarioCadastro);
			
			FacesUtil.addMsgInfo("Funcionário removido com sucesso.");
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("Erro ao remover o funcionário. " + ex.getMessage());
		}
	}
	
	public void editar(){
		try{
			FuncionarioDAO fdao = new FuncionarioDAO();
			funcionarioCadastro.setSenha(DigestUtils.md5Hex(funcionarioCadastro.getSenha()));
			fdao.editar(funcionarioCadastro);
			
			FacesUtil.addMsgInfo("Funcionário editado com sucesso.");
		}catch(RuntimeException ex){
			FacesUtil.addMsgError("Erro ao editar os dados do funcionário. " + ex.getMessage());
		}
	}
}
