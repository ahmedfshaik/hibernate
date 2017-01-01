package edu.home.hibernate.app5;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientOneToOne {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("app5\\hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		Employee employee = new Employee();
		employee.setEname("xyz");
		employee.setAge(30);
		employee.setSalary(new BigDecimal(1000.25));
		employee.setMobile(7799208899L);
		employee.setAddress("Aspire Tech, Swaathi Manor's, Ameerpet");
		
		EmployeePan ep = new EmployeePan();
		ep.setPanno(20);
		ep.setEmployee(employee);
		// Set<EmployeePan> epSet = new HashSet<EmployeePan>();
		// epSet.add(ep);
		// e.setEmployeePan(epSet);
		s.save(ep);
		tx.commit();

	}

}
