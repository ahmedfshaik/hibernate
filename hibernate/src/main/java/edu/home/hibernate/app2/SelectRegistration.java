package edu.home.hibernate.app2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SelectRegistration {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("app2\\hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        Registration registration = (Registration) s.load(Registration.class, new Integer(1));
        //Registration registration = (Registration) s.get(Registration.class, new Integer(1));
        System.out.println("*****");
        System.out.println(registration.getAddress());
        tx.commit();

    }

}
