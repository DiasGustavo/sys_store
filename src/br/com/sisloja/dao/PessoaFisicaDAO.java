package br.com.sisloja.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sisloja.domain.PessoaFisica;
import br.com.sisloja.util.HibernateUtil;

public class PessoaFisicaDAO {
	public void salvar(PessoaFisica pFisica){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.save(pFisica);
			transacao.commit();
		}catch (RuntimeException ex){
			if (transacao != null){
				transacao.rollback();
			}
			throw ex;
		}finally{
			sessao.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<PessoaFisica> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<PessoaFisica> pfisicas = null;
		
		try{
			Query consulta = sessao.getNamedQuery("PessoaFisica.listar");
			pfisicas = consulta.list();
		}catch (RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return pfisicas;
	}
	
	public PessoaFisica buscarPorCodigo(Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		PessoaFisica pfisica = null;
		
		try{
			Query consulta = sessao.getNamedQuery("PessoaFisica.buscarPorCodigo");
			consulta.setLong("id", id);
			pfisica = (PessoaFisica)consulta.uniqueResult();
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return pfisica;
	}
	
	public void editar (PessoaFisica pFisica){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.update(pFisica);
			transacao.commit();
		}catch (RuntimeException ex){
			if (transacao != null){
				transacao.rollback();
			}
			throw ex;
		}finally{
			sessao.close();
		}
	}
	
	public void excluir(PessoaFisica pFisica){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(pFisica);
			transacao.commit();
		}catch (RuntimeException ex){
			if (transacao != null){
				transacao.rollback();
			}
			throw ex;
		}finally{
			sessao.close();
		}
	}
}
