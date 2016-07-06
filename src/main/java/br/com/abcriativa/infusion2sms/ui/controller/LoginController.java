package br.com.abcriativa.infusion2sms.ui.controller;

import java.io.Serializable;
import java.security.Principal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String usuario;

	public String getUsuario() {
		
		if (usuario == null) {
			
			Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
	        if (principal != null) {
	        	usuario = principal.getName();
	        }
		}
		
		return usuario;
	}
	
	public String obterContextPath() {
		return "";
	}

	
	
	
}
