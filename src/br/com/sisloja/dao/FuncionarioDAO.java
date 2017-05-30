package br.com.sisloja.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sisloja.domain.Funcionario;
import br.com.sisloja.util.HibernateUtil;

public class FuncionarioDAO {
	public void salvar(Funcionario funcionario){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.save(funcionario);
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
	public List<Funcionario> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Funcionario> funcionarios = null;
		try{
			Query consulta = sessao.getNamedQuery("Funcionario.listar");
			funcionarios = consulta.list();
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return funcionarios;
	}
	
	public Funcionario buscarPorCodigo(Long id){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Funcionario funcionario = null;
		try{
			Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo");
			consulta.setLong("id", id);
			funcionario = (Funcionario) consulta.uniqueResult();
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return funcionario;
	}
	
	public void editar(Funcionario funcionario){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(funcionario);
			transacao.commit();
		}catch(RuntimeException ex){
			if (transacao != null){
				transacao.rollback();
			}
		}finally{
			sessao.close();
		}
	}
	
	public void excluir(Funcionario funcionario){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(funcionario);
			transacao.commit();
		}catch(RuntimeException ex){
			if (transacao != null){
				transacao.rollback();
			}
		}finally{
			sessao.close();
		}
	}
	
	public Funcionario autenticar(String login, String senha){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Funcionario funcionario = null;
		try{
			Query consulta = sessao.getNamedQuery("Funcionario.autenticar");
			consulta.setString("login", login);
			consulta.setString("senha",senha);
			funcionario = (Funcionario) consulta.uniqueResult();
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return funcionario;
	}
}
