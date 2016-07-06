package br.com.abcriativa.infusion2sms.dominio;

import java.io.Serializable;

public class MesComAtividadesDoProjeto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;
	
	private String mesAno;

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMesAno() {
		return mesAno;
	}

	public void setMesAno(String mesAno) {
		this.mesAno = mesAno;
	}

	@Override
	public String toString() {
		return "Atividades do projeto em " + descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((mesAno == null) ? 0 : mesAno.hashCode());
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
		MesComAtividadesDoProjeto other = (MesComAtividadesDoProjeto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (mesAno == null) {
			if (other.mesAno != null)
				return false;
		} else if (!mesAno.equals(other.mesAno))
			return false;
		return true;
	}
	
	
	
	
}
