package br.com.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.persistence.ResponsibleRN;
import br.com.pojo.Responsible;

@Named
@ViewScoped
public class ManagedResponsible implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Responsible responsible;

	public ManagedResponsible() {

		responsible = new Responsible();

	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
		Flash flashScope = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flashScope.setKeepMessages(true);

	}

	public String register() {
		ResponsibleRN responsibleRN = new ResponsibleRN();

		if (responsibleRN.register(responsible)) {
			addMessage("Sucesso", "Responsável adicionado com sucesso");
			return "index.jsf?faces-redirect=true";

		} else {
			addMessage("Erro", "Responsável não pode ser adicionado. Verifique os dados");
			return "";
		}

	}

	public Responsible getResponsible() {
		return responsible;
	}

	public void setResponsible(Responsible responsible) {
		this.responsible = responsible;
	}

}
