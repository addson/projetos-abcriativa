package br.com.abcriativa.infusion2sms.dominio;

import java.io.Serializable;

public class Evidencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String descricao;
	private String tipo;
	private String data;
	private String urlDoArquivo;
	
	public Evidencia(String descricao, String tipo, String data,
			String urlDoArquivo) {
		super();
		this.descricao = descricao;
		this.tipo = tipo;
		this.data = data;
		this.urlDoArquivo = urlDoArquivo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public String getData() {
		return data;
	}

	public String getUrlDoArquivo() {
		return urlDoArquivo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setUrlDoArquivo(String urlDoArquivo) {
		this.urlDoArquivo = urlDoArquivo;
	}
	
	

		
}
