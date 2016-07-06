package br.com.abcriativa.infusion2sms.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Projeto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String descricao;

	private List<Atividade> atividades = new ArrayList<Atividade>();
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((atividades == null) ? 0 : atividades.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		if (atividades == null) {
			if (other.atividades != null)
				return false;
		} else if (!atividades.equals(other.atividades))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

	public void adicionarMesesComAtividadesDoProjeto(
			List<MesComAtividadesDoProjeto> mesesComAtividadesNoProjeto) {
		
		
	}

	@Override
	public String toString() {
		return this.descricao;
	}
	
	
	
	
}
