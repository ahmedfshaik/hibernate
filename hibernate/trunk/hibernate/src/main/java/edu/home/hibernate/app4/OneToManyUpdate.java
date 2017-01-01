package edu.home.hibernate.app4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyUpdate {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("app4\\hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//Team team = (Team) session.load(Team.class, new Integer(1));
		Team team = (Team) session.get(Team.class, new Integer(1));
		Player p3 = new Player();
		p3.setId(3);
		p3.setName("Yuvraj");
		p3.setAge((byte)34);
		p3.setTeam(team);
		team.getPlayers().add(p3);
		
		session.save(p3);
		session.update(team);
		
		tx.commit();

	}

}
