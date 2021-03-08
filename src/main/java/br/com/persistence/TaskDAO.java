package br.com.persistence;

import java.util.ArrayList;

import br.com.pojo.Task;

public interface TaskDAO {
	
	public boolean register(Task task) ;

	public void delete(Task task);

	public ArrayList<Task> list();
	
	public ArrayList<Task> filterTasks(Task task);
	
	
}
