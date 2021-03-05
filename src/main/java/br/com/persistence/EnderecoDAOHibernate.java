package br.com.persistence;

import org.hibernate.Session;

import br.com.pojo.Endereco;

public class EnderecoDAOHibernate implements EnderecoDAO {

	private Session session;

	public void setSession(Session session) {

		this.session = session;

	}

	public boolean salvar(Endereco endereco) {
		try {
			this.session.save(endereco);
			return true;

		} catch (Exception e) {
			return false;

		}
	}

	public boolean atualizar(Endereco endereco) {
		try {
			this.session.update(endereco);
			return true;

		} catch (Exception e) {
			return false;

		}
	}

	public void excluir(Endereco endereco) {
		this.session.delete(endereco);

	}

}
