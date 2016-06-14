package entity;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class ConexaoTest {

	public static void main(String[] args) {
		
		
		
		Configuration config = new Configuration().
		setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect").
		setProperty("hibernate.connection.driver_class", "org.postgresql.Driver").
		setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/ebroker/georeferencia").
		setProperty("hibernate.connection.username", "postgres").
		setProperty("hibernate.connection.password", "123456").
		setProperty("hibernate.show_sql", "true");
		config.addClass(Mapa.class);
		SessionFactory factory = config.buildSessionFactory();   
 
		Mapa mapa = new Mapa();
		mapa.setIdCliente(1);
		mapa.setUrl("teste da url");
		mapa.setId(1);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(mapa);
		tx.commit();  
		session.close();

	}

}
