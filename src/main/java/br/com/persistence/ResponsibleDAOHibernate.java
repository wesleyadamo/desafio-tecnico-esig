package br.com.persistence;

import java.util.ArrayList;

import org.hibernate.Session;

import br.com.pojo.Responsible;
import br.com.pojo.Task;

public class ResponsibleDAOHibernate implements ResponsibleDAO {

	private Session session;

	public void setSession(Session session) {

		this.session = session;

	}

	public boolean register(Responsible responsible) {
		try {
			this.session.save(responsible);
			return true;

		} catch (Exception e) {
			return false;

		}
	}

	public boolean update(Responsible responsible) {
		try {
			this.session.update(responsible);
			return true;

		} catch (Exception e) {
			return false;

		}
	}

	public void delete(Responsible responsible) {
		this.session.delete(responsible);

	}

	@Override
	public ArrayList<Responsible> list() {
		System.out.println(session.get(Task.class, 1));
		return (ArrayList<Responsible>) this.session.createQuery("SELECT a FROM Responsible a", Responsible.class)
				.getResultList();

	}

	@Override
	public Responsible get(int id) {
		return this.session.find(Responsible.class, id);
	}

}
