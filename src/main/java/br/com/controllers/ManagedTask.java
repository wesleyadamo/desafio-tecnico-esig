package br.com.controllers;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.com.persistence.ResponsibleRN;
import br.com.persistence.TaskRN;
import br.com.pojo.Prioridades;
import br.com.pojo.Responsible;
import br.com.pojo.Status;
import br.com.pojo.Task;

@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped
public class ManagedTask implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Task task;
	private Responsible responsible;
	private ArrayList<Task> tasks;

	private Integer filterNumber;

	public ManagedTask() {
		TaskRN tarefaRN = new TaskRN();

		tasks = tarefaRN.list();

		Flash flashScope = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		boolean existeKey = flashScope.containsKey("tarefa");
		task = existeKey ? (Task) flashScope.get("tarefa") : new Task();

		responsible = new Responsible();

	}

	public Prioridades[] getPriority() {

		return Prioridades.values();
	}

	public Status[] getStatus() {

		return Status.values();
	}

	public ArrayList<Responsible> getResponsibles() {

		return new ResponsibleRN().listar();
	}

	public String searchTask() {

		task.setDescription(task.getTitle());
		ResponsibleRN resp = new ResponsibleRN();
		task.setResponsible(resp.get(responsible.getId()));
		task.setId(filterNumber == null ? 0 : filterNumber);

		System.out.println("id task " + task.getId());

		TaskRN t = new TaskRN();
		this.tasks = t.filterTasks(task);

		return "";
	}

	public ArrayList<Task> getTasks() {
		return this.tasks;
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);

		FacesContext.getCurrentInstance().addMessage(null, message);
		Flash flashScope = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flashScope.setKeepMessages(true);

	}

	public String register() {
		ResponsibleRN res = new ResponsibleRN();
		responsible = res.get(responsible.getId());

		if (task.getId() == 0)
			addMessage("Sucesso", "Tarefa cadastrada com sucesso!");
		else
			addMessage("Sucesso", "Tarefa editada com sucesso!");

		task.setResponsible(responsible);

		TaskRN t = new TaskRN();
		t.register(task);

		return "index.jsf?faces-redirect=true";

	}

	public String edit() {
		Flash flashScope = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flashScope.put("tarefa", task);
		return "cadastrar-tarefa.jsf?faces-redirect=true";

	}

	public String delete() {
		TaskRN t = new TaskRN();

		t.delete(task);
		addMessage("Sucesso", "Tarefa removida com sucesso!");

		return "index.jsf?faces-redirect=true";

	}

	public String complete() {

		task.setStatus(Status.Concluida);
		TaskRN t = new TaskRN();
		t.register(task);

		addMessage("Sucesso", "Tarefa concluída com sucesso!");

		return "index.jsf?faces-redirect=true";

	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Responsible getResponsible() {
		return responsible;
	}

	public void setResponsible(Responsible responsible) {
		this.responsible = responsible;
	}

	public Integer getFilterNumber() {
		return filterNumber;
	}

	public void setFilterNumber(Integer filterNumber) {
		this.filterNumber = filterNumber;
	}

}
