package br.com.sisloja.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sisloja.dao.PessoaFisicaDAO;
import br.com.sisloja.domain.PessoaFisica;

@FacesConverter("pessoaFisicaConverter")
public class PessoaFisicaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try{
			Long codigo = Long.parseLong(valor);
			PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
			PessoaFisica pessoaFisica = pfdao.buscarPorCodigo(codigo);
			return pessoaFisica;
		}catch(RuntimeException ex){
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
		try{
			PessoaFisica pessoaFisica = (PessoaFisica) objeto;
			Long codigo = pessoaFisica.getId();
			return codigo.toString();
		}catch(RuntimeException ex){
			return null;
		}
	}

}
