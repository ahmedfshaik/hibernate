package edu.home.hibernate.app1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertStudent {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("app1\\hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        // Open session
        Session s = sf.openSession();
        // Begin transaction
        Transaction tx = s.beginTransaction();
        // Create student object
        Student s1 = new Student();
        s1.setSno(1);
        s1.setSname("abc");
        s1.setEmail("abc@aspire.com");
        s1.setMobile(7799108899L);
        s.save(s1);
        s.flush();
        tx.commit();// Commit transaction
        s.close();// close session
    }
}
