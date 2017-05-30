package br.com.sisloja.main;

import br.com.sisloja.util.HibernateUtil;

public class GeraTabela {

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();

	}

}
