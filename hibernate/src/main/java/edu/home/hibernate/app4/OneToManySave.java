package edu.home.hibernate.app4;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManySave {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("app4\\hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Team team = new Team();
		team.setId(1);
		team.setName("Cricket");
		
		Player player1 = new Player();
		player1.setId(1);
		player1.setName("Kohli");
		player1.setAge((byte) 25);
		// p1.setTeam(t1); //required if inverse="true"
		Player player2 = new Player();
		player2.setId(2);
		player2.setName("Dhoni");
		player2.setAge((byte) 32);
		// p2.setTeam(t1); //required if inverse="true"
		Player player3 = new Player(); // duplicate player
		player3.setId(2);
		player3.setName("Dhoni");
		player3.setAge((byte) 32);
		// p3.setTeam(t1); //required if inverse="true"
		Set<Player> players = new HashSet<Player>();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		// one-to-many
		team.setPlayers(players);
		
		
		session.save(team);
		session.save(player1);
		session.save(player2);
		//session.save(p3);
		session.flush();
		tx.commit();
		session.close();
		//Adding new Player
		/*Team t = (Team)session.get(Team.class, new Integer(1));
		Player p3 = new Player();
		p3.setId(3);
		p3.setName("Yuvraj");
		p3.setAge((byte)34);
		p3.setTeam(t); //Many-to-one
		session.save(p3);
		tx.commit();*/
		//Retrieve records using parent table primary key with different lazy attribute
		/*Team t= (Team)session.get(Team.class, new Integer(1));
		System.out.println("*******");
		Set<Player> players = t.getPlayers();
		System.out.println("size::::::::"+players.size());
		session.flush();
		tx.commit();*/
	}

}
