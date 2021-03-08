package br.com.persistence;

public class DAOFactory {

	public static TaskDAO createTaskDAO() {
		TaskDAOHibernate taskDAO = new TaskDAOHibernate();
		taskDAO.setSession(HibernateUtil.getSessionFactory().openSession());
		return taskDAO;
	}

	public static ResponsibleDAO createResponsibleDAO() {
		ResponsibleDAOHibernate responsibleDAO = new ResponsibleDAOHibernate();
		responsibleDAO.setSession(HibernateUtil.getSessionFactory().openSession());
		return responsibleDAO;
	}

}
