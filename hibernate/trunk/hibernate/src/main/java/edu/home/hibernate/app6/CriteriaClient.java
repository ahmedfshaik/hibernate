package edu.home.hibernate.app6;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class CriteriaClient {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("app6\\hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Employee empTO = new Employee();
        empTO.setEname("abc");
        empTO.setAge(30);
        empTO.setSal(new Long(1000));
        session.saveOrUpdate(empTO);
        
        Employee empTO1 = new Employee();
        empTO1.setEname("xyz");
        empTO1.setAge(33);
        empTO1.setSal(new Long(2000));
        session.saveOrUpdate(empTO1);
        
        session.flush();
        tx.commit();
        Criteria crit = session.createCriteria(Employee.class).add(Restrictions.between("sal", new Long(1700), new Long(2200)));
        List list = crit.list();
        System.out.println("SIZE:::::::" + list.size());
        /*
         * Criteria crit =
         * session.createCriteria(Employee.class).add(Restrictions.like("ename","x%"));
         * List<Employee> employees = crit.list(); System.out.println(employees.size());
         */

    }

}
