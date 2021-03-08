package br.com.persistence;

import java.util.ArrayList;

import br.com.pojo.Task;

public class TaskRN {

	private TaskDAO taskDAO;

	public TaskRN() {
		taskDAO = DAOFactory.createTaskDAO();
	}

	public boolean register(Task tarefa) {
		return taskDAO.register(tarefa);

	}

	public void delete(Task tarefa) {
		taskDAO.delete(tarefa);

	}

	public ArrayList<Task> list() {
		return taskDAO.list();

	}

	public ArrayList<Task> filterTasks(Task task) {
		
		return taskDAO.filterTasks(task);
	}

}
