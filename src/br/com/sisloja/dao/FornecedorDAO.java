package br.com.sisloja.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sisloja.domain.Fornecedor;
import br.com.sisloja.util.HibernateUtil;

public class FornecedorDAO {
	public void salvar(Fornecedor fornecedor){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.save(fornecedor);
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
	public List<Fornecedor> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List <Fornecedor> fornecedores = null;
		try{
			Query consulta = sessao.getNamedQuery("Fornecedor.listar");
			fornecedores = consulta.list();
			
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return fornecedores;
	}
	
	public Fornecedor buscarPorCodigo (Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Fornecedor fornecedor = null;
		try{
			Query consulta = sessao.getNamedQuery("Fornecedor.buscarPorCodigo");
			consulta.setLong("id", id);
			fornecedor = (Fornecedor)consulta.uniqueResult();
			
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return fornecedor;
	}
	
	public void editar(Fornecedor fornecedor){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.update(fornecedor);
			transacao.commit();
		}catch(RuntimeException ex){
			if (transacao != null){
				transacao.rollback();
			}
		}finally{
			sessao.close();
		}
	}
	
	public void excluir (Fornecedor fornecedor){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(fornecedor);
			transacao.commit();
		}catch(RuntimeException ex){
			if (transacao != null){
				transacao.rollback();
			}
		}finally{
			sessao.close();
		}
	}
}
