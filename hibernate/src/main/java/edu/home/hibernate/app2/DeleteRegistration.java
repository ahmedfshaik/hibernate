package edu.home.hibernate.app2;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteRegistration {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("app2\\hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		// Method1: delete transient object with identifier value.
		/*Registration registration = new Registration();
		registration.setRegid(1);
		session.delete(registration);
		session.flush();
		transaction.commit();
		session.close();*/
		
		
		// Method2: delete persistent object.
		/*Registration registration =(Registration)session.load(Registration.class, new Integer(2));
		session.delete(registration);
		session.flush();
		transaction.commit();
		session.close();*/
		
		// Method3: delete detached object using same session.
		/*Registration registration =(Registration)session.load(Registration.class, new Integer(3));
		session.evict(registration);
		session.delete(registration);
		session.flush();
		transaction.commit();
		session.close();*/
		
		
		// Method4: Delete detached object from different session.
		/*Registration registration = (Registration)session.load(Registration.class, new Integer(6));
		System.out.println("after...");
		session.close();
		Session s1 = sf.openSession();
		Transaction tx1 = s1.beginTransaction();
		s1.delete(registration);
		s1.flush();
		tx1.commit();
		s1.close();*/
		
		// Method5: Batch operations
		Query q = session.createQuery("FROM Registration r where r.regid <=100 ");
		List<Registration> regList = q.list();
		int count = 0;
		for (Registration registration : regList) {
			count++;
			session.delete(registration);
			if (count++ % 1000 == 0) { // The batch size is generally configured
										// in hibernate.cfg.xml file.
				session.flush();
				count = 0;
			}
		}
		session.flush(); // call flush() method now for bulk deletion.
		transaction.commit();
		session.close();

	}

}
