package br.com.persistence;

import java.util.ArrayList;

import br.com.pojo.Responsible;

public interface ResponsibleDAO {
	
	public boolean register(Responsible responsible) ;

	public boolean update(Responsible responsible);

	public void delete(Responsible responsible);
	
	public Responsible get(int id);
	
	public ArrayList<Responsible> list();
		


}
