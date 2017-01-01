package edu.home.hibernate.app7;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CacheClient {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("app7\\hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Player p1 = new Player();
        p1.setId(1);
        p1.setName("Sachin");
        p1.setAge((byte)34);
        Player p2 = new Player();
        p2.setId(2);
        p2.setName("Sourav");
        p2.setAge((byte)34);
        Set playerSet = new HashSet();
        playerSet.add(p1);
        playerSet.add(p2);
        // one-to-many
        Team t1 = new Team();
        t1.setId(1);
        t1.setName("Cricket");
        t1.setPlayers(playerSet);
        session.save(p1);
        session.save(p2);
        session.save(t1);
        // many-to-one
        Player p3 = new Player();
        p3.setId(3);
        p3.setName("Dravid");
        p3.setAge((byte)34);
        p3.setTeam(t1);
        session.save(p3);
        session.flush();
        tx.commit();
        session.close();
        // Fetch data from the database.
        Session s1 = sf.openSession();
        Transaction tx1 = s1.beginTransaction();
        Team t3 = (Team) s1.get(Team.class, new Integer(1));
        System.out.println("Team size::" + t3.getPlayers().size());
        tx1.commit();
        // Give time to hibernate framework to write into second level memory.
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        s1.close();
        Session s2 = sf.openSession();
        Transaction tx2 = s2.beginTransaction();
        Team t4 = (Team) s2.get(Team.class, new Integer(1));
        tx2.commit();
        s2.close();

    }

}
