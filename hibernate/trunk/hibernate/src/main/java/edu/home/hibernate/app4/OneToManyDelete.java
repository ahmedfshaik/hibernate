package edu.home.hibernate.app4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyDelete {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("app4\\hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		// cascade="delete"
		 Team team = (Team) session.get(Team.class, new Integer(1));
		 session.delete(team);

		// cascade="delete-orphan"
		/*Player player1 = (Player) session.get(Player.class, new Integer(1));
		Team team = (Team) session.get(Team.class, new Integer(1));
		team.getPlayers().remove(player1);
		session.saveOrUpdate(team);*/

		tx.commit();

	}

}
