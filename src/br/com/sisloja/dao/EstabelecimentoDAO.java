package br.com.sisloja.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sisloja.domain.Estabelecimento;
import br.com.sisloja.util.HibernateUtil;

public class EstabelecimentoDAO {
	
	public void salvar(Estabelecimento estabelecimento){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.save(estabelecimento);
			transacao.commit();
		}catch(RuntimeException ex){
			if(transacao != null){
				transacao.rollback();
			}
		}finally{
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Estabelecimento> listar (){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List <Estabelecimento> estabelecimentos = null;
		try{
			Query consulta = sessao.getNamedQuery("Estabelecimento.listar");
			estabelecimentos = consulta.list();
		}catch (RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return estabelecimentos;
	}
	
	public Estabelecimento buscarPorCodigo(Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Estabelecimento estabelecimento = null;
		
		try{
			Query consulta = sessao.getNamedQuery("Estabelecimento.buscarPorCodigo");
			consulta.setLong("id", id);
			estabelecimento = (Estabelecimento) consulta.uniqueResult();
			
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return estabelecimento;
	}
	
	public void editar(Estabelecimento estabelecimento){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(estabelecimento);
			transacao.commit();
		}catch(RuntimeException ex){
			if(transacao != null){
				transacao.rollback();
			}			
		}finally{
			sessao.close();
		}
	}
	
	public void excluir(Estabelecimento estabelecimento){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(estabelecimento);
			transacao.commit();
		}catch(RuntimeException ex){
			if(transacao != null){
				transacao.rollback();
			}
		}finally{
			sessao.close();
		}
	}
}
