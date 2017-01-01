package edu.home.hibernate.app4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManySelect {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("app4\\hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//Team team = (Team) session.load(Team.class, new Integer(1));
		Team team = (Team) session.get(Team.class, new Integer(1));
		System.out.println("*****");
		System.out.println(team.getPlayers());
		tx.commit();

	}

}
