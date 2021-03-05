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

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Responsible implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String birthdate;

	private String fone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;
	
	@OneToMany(mappedBy="responsible")
    private Set<Task> tasks;

	private String naturalidade;

	@Column(unique = true)
	private String cpf;

	@Column(unique = true)
	private String email;

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

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getRGFormatado() {

		// return rg.substring(0, 5) + "*****";
		return "";
	}

	public String getCPFFormatado() {

		// return cpf.substring(0, 5) + "*****";
		return "";
	}

	public String getEnderecoCompleto() {
		StringBuilder endereco = new StringBuilder();

		/*
		 * if (!getEndereco().isEmpty()) endereco.append(getEndereco()); if
		 * (!getBairro().isEmpty()) endereco.append("<br/>" + getBairro() + ",&nbsp;" +
		 * getNumero()); else endereco.append("<br/>" + getNumero()); return
		 * endereco.toString();
		 */
		return "";
	}

}