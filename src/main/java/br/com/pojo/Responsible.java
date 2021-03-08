package br.com.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Responsible implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true)
	private String name;

	@OneToMany(mappedBy = "responsible")
	private Set<Task> tasks;

	@Column(unique = true)
	@NotNull(message = "A prioridade é obrigatória")
	private String cpf;

	@Column(name = "rg", unique = true)
	private String rg;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNomeFormatado() {
		String[] nome = this.getName().split(" ");
		String retorno = nome.length > 1 ? nome[0] + " " + nome[nome.length - 1] : nome[0];

		return retorno;

	}

}