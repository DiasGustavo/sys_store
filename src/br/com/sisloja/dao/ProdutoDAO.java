package br.com.sisloja.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sisloja.domain.Produto;
import br.com.sisloja.util.HibernateUtil;

public class ProdutoDAO {
	
	public void salvar (Produto produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.save(produto);
			transacao.commit();
		}catch (Exception ex){
			if(transacao != null){
				transacao.rollback();
			}
			throw ex;
		} finally{
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = null;
		List<Produto> produtos = null;
		try{
			consulta = sessao.getNamedQuery("Produto.listar");
			produtos = consulta.list();
		}catch(RuntimeException ex){
			throw ex;
		} finally {
			sessao.close();
		}
		return produtos;
	}
	
	public Produto buscarPorCodigo(Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = null;
		Produto produto = null;
		try{
			consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
			consulta.setLong("id", id);
			produto = (Produto)consulta.uniqueResult();
			
		}catch(RuntimeException ex){
			throw ex;
		} finally {
			sessao.close();
		}
		return produto;
	}
	
	public void excluir (Produto produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(produto);
			transacao.commit();
		}catch (Exception ex){
			if(transacao != null){
				transacao.rollback();
			}
			throw ex;
		} finally{
			sessao.close();
		}
	}
	
	public void excluir (Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			Produto produto = buscarPorCodigo(id);
			sessao.save(produto);
			transacao.commit();
		}catch (Exception ex){
			if(transacao != null){
				transacao.rollback();
			}
			throw ex;
		} finally{
			sessao.close();
		}
	}
	
	//com validação em tela
	public void editar(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();

			// Caso não valide em tela precisa fazer a editação a mão. 
			// Pessoa pessoaEditar = buscarPorCodigo(pessoa.getId());
			// pessoaEditar.setEmail(pessoa.getEmail());
			// pessoaEditar.setNome(pessoa.getNome());
			// pessoaEditar.setTelefone(pessoa.getTelefone());

			sessao.update(produto);
			transacao.commit();
		} catch (Exception ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}
}
