package br.com.persistence;

import br.com.pojo.Endereco;

public class EnderecoRN {

	private EnderecoDAO enderecoDAO;

	public EnderecoRN() {
		enderecoDAO = DAOFactory.createStreetDAO();
	}

	public boolean salvar(Endereco endereco) {
		return enderecoDAO.salvar(endereco);

	}

	public boolean atualizar(Endereco endereco) {
		return enderecoDAO.atualizar(endereco);

	}

	public void excluir(Endereco endereco) {
		enderecoDAO.excluir(endereco);

	}

}
