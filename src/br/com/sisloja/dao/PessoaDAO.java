package br.com.sisloja.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sisloja.domain.Pessoa;
import br.com.sisloja.util.HibernateUtil;

public class PessoaDAO {

	public void salvar(Pessoa pessoa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(pessoa);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = null;
		List<Pessoa> pessoas = null;
		try{
			consulta = sessao.getNamedQuery("Pessoa.listar");
			pessoas = consulta.list();
			
		}catch (RuntimeException ex){
			throw ex;
		}
		return pessoas;
	}
	
	public Pessoa buscarPorCodigo(Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = null;
		Pessoa pessoa = null;
		try{
			consulta = sessao.getNamedQuery("Pessoa.buscarPorCodigo");
			consulta.setLong("id", id);
			pessoa = (Pessoa)consulta.uniqueResult();
			
		}catch (RuntimeException ex){
			throw ex;
		}
		return pessoa;
	}
	
	
	public void excluir(Pessoa pessoa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(pessoa);
			transacao.commit();
			
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}
	
	public void excluir(Long id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			Pessoa pessoa = buscarPorCodigo(id);
			sessao.delete(pessoa);
			transacao.commit();
			
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}
	//com validação em tela
	public void editar(Pessoa pessoa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			
			// Pessoa pessoaEditar = buscarPorCodigo(pessoa.getId());
			// pessoaEditar.setEmail(pessoa.getEmail());
			// pessoaEditar.setNome(pessoa.getNome());
			// pessoaEditar.setTelefone(pessoa.getTelefone());
			
			sessao.update(pessoa);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}
}
