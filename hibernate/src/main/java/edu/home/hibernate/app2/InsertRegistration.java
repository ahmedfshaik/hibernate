package edu.home.hibernate.app2;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertRegistration {

    public static void main(String[] args) {
        
    	Configuration cfg = new Configuration();
        cfg.configure("app2\\hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Registration registration = new Registration();
        //registration.setRegid(3);
        registration.setName("xyz");
        registration.setEmail("xyz@aspirecareers.in");
        registration.setMobile("7799108899");
        registration.setAddress("Swathi manors, Ameerpet");
        
        
        
        // This method guarantee to return an identifier hence return type is Serializable
        //Serializable  serializable =session.save(registration);
        //System.out.println("Registration:"+registration.getRegid()+"Serial:"+serializable);
        
        // This method does not guarantee to return identifier hence return type is void
        session.persist(registration);
        System.out.println("Registration:"+registration.getRegid());
        
        
        
        
        session.flush();
       // tx.commit();
        System.out.println(session.contains(registration)); // true
        
        
        
        
        // Only specified object is removed from the session. The state becomes detached.
        session.evict(registration);
        // All objects are detached i.e., removed from the session
        // s.clear(); 
        System.out.println(session.contains(registration)); // false
        
        
        
        
        
        System.out.println("Saving detached object");
        // throws PersistentObjectException: detached entity passed to persist: null
        //session.persist(registration); 
        
        Serializable  serializable =session.save(registration);
        System.out.println("Registration:"+registration.getRegid()+"Serial:"+serializable);
        registration.setName("update");
        session.flush();
        tx.commit();
        System.out.println(session.contains(registration));
        session.close();
    }

}
