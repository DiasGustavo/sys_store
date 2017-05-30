package br.com.sisloja.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sisloja.domain.PessoaJuridica;
import br.com.sisloja.util.HibernateUtil;

public class PessoaJuridicaDAO {

	public void salvar(PessoaJuridica  pJuridica){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.save(pJuridica);
			transacao.commit();
		}catch(RuntimeException ex){
			if (transacao != null){
				transacao.rollback();
			}
			throw ex;
		}finally{
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaJuridica> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List <PessoaJuridica> pjuridicas = null;
		
		try{
			Query consulta = sessao.getNamedQuery("PessoaJuridica.listar");
			pjuridicas = consulta.list();
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return pjuridicas;
	}
	
	public PessoaJuridica buscarPorCodigo(Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		PessoaJuridica pjuridica = null;
		
		try{
			Query consulta = sessao.getNamedQuery("PessoaJuridica.buscarPorCodigo");
			consulta.setLong("id", id);
			pjuridica = (PessoaJuridica) consulta.uniqueResult();
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return pjuridica;
	}
	
	public void editar(PessoaJuridica pJuridica){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(pJuridica);
			transacao.commit();
		}catch(RuntimeException ex){
			if (transacao != null){
				transacao.rollback();
			}
			throw ex;
		}finally{
			sessao.close();
		}
	}
	
	public void excluir(PessoaJuridica pJuridica){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(pJuridica);
			transacao.commit();
		}catch(RuntimeException ex){
			if (transacao != null){
				transacao.rollback();
			}
			throw ex;
		}finally{
			sessao.close();
		}
	}
}
