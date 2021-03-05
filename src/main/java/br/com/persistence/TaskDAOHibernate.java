package br.com.persistence;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.pojo.Task;

public class TaskDAOHibernate implements TaskDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	public boolean register(Task task) {
		try {
			Transaction tx = this.session.beginTransaction();
			this.session.saveOrUpdate(task);
			tx.commit();

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e);
			return false;

		}
	}

	public void delete(Task task) {
		Transaction tx = this.session.beginTransaction();
		this.session.delete(task);
		tx.commit();
	}

	public ArrayList<Task> list() {
		System.out.println(session.get(Task.class, 1));
		return (ArrayList<Task>) this.session.createQuery("SELECT a FROM Task a order by id ASC", Task.class)
				.getResultList();

	}

	@Override
	public ArrayList<Task> filterTasks(Task task) {
		/*
		 * System.out.println("description "+task.getDescription()); Criterion title =
		 * Restrictions.eq("t.title", task.getTitle()); Criterion description =
		 * Restrictions.eq("t.description", task.getTitle());
		 * 
		 */

		// Create CriteriaBuilder
		CriteriaBuilder builder = session.getCriteriaBuilder();

		// Create CriteriaQuery
		CriteriaQuery<Task> criteria = builder.createQuery(Task.class);

		Root<Task> myObjectRoot = criteria.from(Task.class);

		Example example = Example.create(task);

		example.excludeProperty("description");
		example.excludeProperty("title");

		List<Predicate> predicatess = new ArrayList<>();
		
		if (!task.getTitle().isEmpty()) {
			predicatess.add(builder.or(builder.equal(myObjectRoot.get("title"), task.getTitle()),
					builder.equal(myObjectRoot.get("description"), task.getDescription())

			));

		}

		if (task.getId() != 0) {
			predicatess.add(builder.and(builder.equal(myObjectRoot.get("id"), task.getId())));
		}

		if (!(task.getResponsible() == null)) {
			System.out.println("entrou no responsavel");
			predicatess.add(builder.and(builder.equal(myObjectRoot.get("responsible"), task.getResponsible())));
		}
		if (!(task.getStatus() == null)) {
			System.out.println("entrou no status");
			predicatess.add(builder.and(builder.equal(myObjectRoot.get("status"), task.getStatus())));
		}

		Predicate[] predicates = predicatess.toArray(new Predicate[predicatess.size()]);

		criteria.select(myObjectRoot).where(predicates);
		TypedQuery<Task> query = this.session.createQuery(criteria);
		return (ArrayList<Task>) query.getResultList();

	}

}
