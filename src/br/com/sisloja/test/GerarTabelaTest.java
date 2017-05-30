package br.com.sisloja.test;

import org.junit.Test;

import br.com.sisloja.util.HibernateUtil;

public class GerarTabelaTest {
	@Test
	public void gerar(){
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}

}
