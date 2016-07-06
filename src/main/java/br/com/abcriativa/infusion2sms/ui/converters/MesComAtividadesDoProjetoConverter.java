package br.com.abcriativa.infusion2sms.ui.converters;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.abcriativa.infusion2sms.dominio.MesComAtividadesDoProjeto;

/**
 * @author Addson Bastos
 *
 */
@FacesConverter("mesComAtividadesDoProjetoConverter")
public class MesComAtividadesDoProjetoConverter implements Converter {

	private static Map<String, MesComAtividadesDoProjeto> mapMesComAtividadesDoProjeto = new HashMap<String, MesComAtividadesDoProjeto>();

	public static void clearMap() {
		mapMesComAtividadesDoProjeto.clear();
	}

	public static void addItem(String chave, MesComAtividadesDoProjeto value) {
		mapMesComAtividadesDoProjeto.put(chave, value);
	}

	public static MesComAtividadesDoProjeto getItem(String chave) {
		return mapMesComAtividadesDoProjeto.get(chave);
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2.equals("") || arg2.equals("undefined"))
			return null;

		return MesComAtividadesDoProjetoConverter.getItem(arg2);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if (obj == null || obj.equals(""))
			return null;

		MesComAtividadesDoProjeto value = (MesComAtividadesDoProjeto) obj;
		MesComAtividadesDoProjetoConverter.addItem(value.getDescricao(), value);
		return value.getDescricao();
	}

}
