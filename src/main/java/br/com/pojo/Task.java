package br.com.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;

@Entity
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "O título é obrigatório")
	private String title;
	@NotNull(message = "A descrição é obrigatória")
	private String description;
	@NotNull(message = "A prioridade é obrigatória")
	private Priorities priority;

	private Status status;

	@ManyToOne
	@JoinColumn(name = "responsible_id", nullable = false)
	private Responsible responsible;

	@Temporal(TemporalType.TIMESTAMP)
	@FutureOrPresent(message="A data não é válida")
	private Date deadline;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Priorities getPriority() {
		return priority;
	}

	public void setPriority(Priorities priority) {
		this.priority = priority;
	}

	public void setResponsible(Responsible responsible) {
		this.responsible = responsible;
	}

	public Responsible getResponsible() {
		return responsible;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;

	}

	@PrePersist
	public void prePersist() {
		if (status == null) // We set default value in case if the value is not set yet.
			status = Status.Andamento;
	}

}
