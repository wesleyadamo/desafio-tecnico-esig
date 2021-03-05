package br.com.persistence;

import java.util.ArrayList;

import br.com.pojo.Responsible;

public class ResponsibleRN {

	private ResponsibleDAO responsibleDAO;

	public ResponsibleRN() {
		responsibleDAO = DAOFactory.createResponsibleDAO();
	}

	public Responsible get(int id_responsavel) {
		return responsibleDAO.get(id_responsavel);

	}

	public boolean register(Responsible responsible) {
		return responsibleDAO.register(responsible);

	}

	public boolean update(Responsible responsible) {
		return responsibleDAO.update(responsible);

	}

	public void delete(Responsible responsible) {
		responsibleDAO.delete(responsible);

	}

	public ArrayList<Responsible> listar() {
		return responsibleDAO.list();

	}

}
