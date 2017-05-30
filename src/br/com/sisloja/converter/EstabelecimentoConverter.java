package br.com.sisloja.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sisloja.dao.EstabelecimentoDAO;
import br.com.sisloja.domain.Estabelecimento;

@FacesConverter("estabelecimentoConverter")
public class EstabelecimentoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try{
			Long codigo = Long.parseLong(valor);
			EstabelecimentoDAO edao = new EstabelecimentoDAO();
			Estabelecimento estabelecimento = edao.buscarPorCodigo(codigo);
			return estabelecimento;
		}catch(RuntimeException ex){
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
		try{
			Estabelecimento estabelecimento = (Estabelecimento) objeto;
			Long codigo = estabelecimento.getId();
			return codigo.toString();
		}catch(RuntimeException ex){
			return null;
		}
	}

}
