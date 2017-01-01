package edu.home.hibernate.app3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PKGeneratorClient {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("app3\\hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		// For inserting new record.
		Customer c = new Customer();
		// c.setCustomerPk(new Long(1));//No need to set
		c.setCustomerId("cust1");
		c.setCustomerName("Ramesh");
		c.setCustomerAddress("Aspire tech, Ameerpet");
		c.setBusinessType("Training Instistution");
		c.setCustomerPhone("7799 10 8899");
		session.save(c);
		session.flush();
		tx.commit();
		session.close();
	}

}
