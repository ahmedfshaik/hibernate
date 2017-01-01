package edu.home.hibernate.app2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateRegistration {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("app2\\hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        
        //Method1: Updating persistent object with in same session
        /*Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Registration registration = (Registration) session.get(Registration.class, new Integer(1));
        registration.setAddress("Ameerpet53335, Hyd");
        session.update(registration);
        System.out.println("******");
        session.flush();
        transaction.commit();
        session.close();*/
        
        //Method2: Updating detached object using same session
        /*Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Registration registration = (Registration) session.get(Registration .class, new Integer(1));
        session.evict(registration);
        registration.setAddress("5555555, Hyd"); //modify detached object
        session.update(registration); //Re-attach back to the same session and update it.
        session.flush();
        transaction.commit();
        session.close();*/
        
        //Method3: Updating detached object from different session
        /*Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Registration registration = (Registration) session.get(Registration.class, new Integer(1));
        session.close();
        registration.setAddress("44444");
        Session sessionNew = sf.openSession();
        Transaction transaction2 = sessionNew.beginTransaction();
        sessionNew.update(registration); //Re-attach to the different session and update it
        transaction2.commit();
        sessionNew.close();*/
      
        
        //Method4: The update() vs merge() method
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Registration registration = (Registration) session.get(Registration.class, new Integer(1)); //persistant object
        Registration registration2 = new Registration();
        registration2.setRegid(1);
        registration2.setName("abc");
        registration2.setEmail("abc@aspirecareers.in");
        registration2.setMobile("7799208899");
        registration2.setAddress("Swathi manors, Ameerpet");
        session.update(registration2); //throws NoUniqueObjectException
        //s.merge(r1); //Will not throw any exception
        session.flush();
        transaction.commit();
        session.close();

    }

}
