package br.com.sisloja.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sisloja.domain.ItemVenda;
import br.com.sisloja.util.HibernateUtil;

public class ItemVendaDAO {
	
	public void salvar(ItemVenda item){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.save(item);
			transacao.commit();
		}catch(RuntimeException ex){
			if (transacao != null){
				transacao.rollback();
			}
		}finally{
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemVenda> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = null;
		List<ItemVenda> itens = null;
		try{
			consulta = sessao.getNamedQuery("ItemVenda.listar");
			itens = consulta.list();
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return itens;
	}
	
	public ItemVenda buscarPorCodigo(Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = null;
		ItemVenda item = null;
		try{
			consulta = sessao.getNamedQuery("ItemVenda.buscarPorCodigo");
			consulta.setParameter("id", id);
			item = (ItemVenda) consulta.uniqueResult();
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return item;
	}
	
	public void editar(ItemVenda item){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(item);
			transacao.commit();
		}catch(RuntimeException ex){
			if (transacao != null){
				transacao.rollback();
			}
		}finally{
			sessao.close();
		}
	}
	
	public void excluir(ItemVenda item){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(item);
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
