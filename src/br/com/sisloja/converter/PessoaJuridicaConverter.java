package br.com.sisloja.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sisloja.dao.PessoaJuridicaDAO;
import br.com.sisloja.domain.PessoaJuridica;

@FacesConverter("pessoaJuridicaConverter")
public class PessoaJuridicaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent compenent, String valor) {
		try{
			Long codigo = Long.parseLong(valor);
			PessoaJuridicaDAO pdao = new PessoaJuridicaDAO();
			PessoaJuridica pessoaJuridica = pdao.buscarPorCodigo(codigo);
			return pessoaJuridica;
		}catch (RuntimeException ex){
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent compenent, Object objeto) {
		try{
			PessoaJuridica pessoaJuridica = (PessoaJuridica) objeto;
			Long codigo = pessoaJuridica.getId();
			return codigo.toString();
		}catch(RuntimeException ex){
			return null;
		}
	}

}
