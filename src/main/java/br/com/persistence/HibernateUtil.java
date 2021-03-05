package br.com.persistence;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import br.com.pojo.Endereco;
import br.com.pojo.Responsible;
import br.com.pojo.Task;

import org.hibernate.SessionFactory;

public class HibernateUtil {
	private static final SessionFactory	sessionFactory	= buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");

			StandardServiceRegistryBuilder registradorServico = new StandardServiceRegistryBuilder();
			registradorServico.applySettings(cfg.getProperties());
			StandardServiceRegistry servico = registradorServico.build();
			
			cfg.addAnnotatedClass(Responsible.class);
			cfg.addAnnotatedClass(Endereco.class);
			cfg.addAnnotatedClass(Task.class);

			
			return cfg.buildSessionFactory(servico);
	} catch (Throwable e) {
			System.out.println("Criação inicial do objeto SessionFactory falhou. Erro: " + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}