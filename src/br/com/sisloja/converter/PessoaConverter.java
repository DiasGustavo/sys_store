package br.com.sisloja.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sisloja.dao.PessoaDAO;
import br.com.sisloja.domain.Pessoa;

@FacesConverter("pessoaConverter")
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		System.out.println("getAsObject: " + valor);
		try{
			Long codigo = Long.parseLong(valor);
			PessoaDAO pdao = new PessoaDAO();
			Pessoa pessoa = pdao.buscarPorCodigo(codigo);
			
			return pessoa;
		}catch (RuntimeException ex){
			return null;
		}
		
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
		System.out.println("getAsString: " + objeto);
		try{
			Pessoa pessoa = (Pessoa) objeto;
			Long codigo = pessoa.getId();
			return codigo.toString();
		}catch(RuntimeException ex){
			return null;
		}
		
	}

}
