package br.com.abcriativa.infusion2sms.ui.converters;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.abcriativa.infusion2sms.dominio.Projeto;

/**
 * @author Addson Bastos
 *
 */
@FacesConverter("projetoConverter")
public class ProjetoConverter implements Converter {

	private static Map<String, Projeto> mapProjeto = new HashMap<String, Projeto>();

	public static void clearMap() {
		mapProjeto.clear();
	}

	public static void addItem(String chave, Projeto value) {
		mapProjeto.put(chave, value);
	}

	public static Projeto getItem(String chave) {
		return mapProjeto.get(chave);
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2.equals("") || arg2.equals("undefined"))
			return null;

		return ProjetoConverter.getItem(arg2);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if (obj == null || obj.equals(""))
			return null;

		Projeto value = (Projeto) obj;
		ProjetoConverter.addItem(value.getDescricao(), value);
		return value.getDescricao();
	}

}
