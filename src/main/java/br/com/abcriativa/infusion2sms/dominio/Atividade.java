package br.com.abcriativa.infusion2sms.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Atividade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String descricao;
	String tipo;
	String periodo;
	String executor;
	private List<Evidencia> evidencias = new ArrayList<Evidencia>();
	
	public Atividade(String descricao, String tipo, String periodo,
			String executor) {
		super();
		this.descricao = descricao;
		this.tipo = tipo;
		this.periodo = periodo;
		this.executor = executor;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public String getPeriodo() {
		return periodo;
	}

	public String getExecutor() {
		return executor;
	}

	public void adicionarEvidencia(Evidencia evidencia) {

		this.evidencias .add(evidencia);
	}
	
	
	
	
	
}
