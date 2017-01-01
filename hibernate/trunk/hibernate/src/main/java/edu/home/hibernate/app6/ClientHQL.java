package edu.home.hibernate.app6;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientHQL {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("app6\\hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
       /* Employee e1 = new Employee();
        e1.setEname("Naveen");
        e1.setAge(24);
        e1.setSal(10000);
        session.saveOrUpdate(e1);
        
        Employee e2 = new Employee();
        e2.setEname("Srini");
        e2.setAge(34);
        e2.setSal(100000);
        session.saveOrUpdate(e2);
        
        Customer c1 = new Customer();
        c1.setCustomerId("cust1");
        c1.setCustomerName("Ramesh");
        c1.setCustomerAddress("KPHB");
        c1.setCustomerPhone("123456");
        c1.setBusinessType("edu");
        session.saveOrUpdate(c1);
        
        Customer c2 = new Customer();
        c2.setCustomerId("cust2");
        c2.setCustomerName("Ravi");
        c2.setCustomerAddress("Ameerpet");
        c2.setCustomerPhone("654321");
        c2.setBusinessType("edu");
        session.saveOrUpdate(c2);
        
        session.flush();
        tx.commit();*/
        // SQL QUERY
        /*SQLQuery query = session.createSQLQuery("SELECT * FROM PUBLIC.CUST");
        ScrollableResults rs = query.scroll();
        while (rs.next()) {
        	System.out.println(rs.get());
            //System.out.println(rs.get(0) + "\t" + rs.get(1) + "\t" + rs.get(2));
        }*/

        // HQL QUERY
       /* Query hqlquery = session.createQuery("select c from Customer c");
        List<Customer> customers = hqlquery.list();
        for (Customer c: customers) {
            System.out.println("CUSTOMERID:" + c.getCustomerId());
            System.out.println("CUSTOMERNAME:" + c.getCustomerName());
            System.out.println("ADDRESS:" + c.getCustomerAddress());
        }*/
        // ORM approach using Value Object (VO)
        /*Query query1 = session.createQuery("select new CustomerVO(c.customerPk,c.customerName, c.customerAddress) from Customer c");
        List<CustomerVO> list1 = query1.list();
        for (CustomerVO c: list1) {
            System.out.println(c.getCustomerPk());
            System.out.println(c.getCustomerName());
            System.out.println(c.getCustomerAddress());
        }*/
        // Generic Approach using Object[]
       /* Query query2 = session.createQuery("select c.customerPk, c.customerName,c.customerAddress from Customer c");
        List<Object[]> list2 = query2.list();
        Iterator<Object[]> ite1 = list2.iterator();
        while (ite1.hasNext()) {
            Object[] obj = ite1.next();
            long customerPk = (Long) obj[0];
            String customerName = (String) obj[1];
            String customerAddress = (String) obj[2];
            System.out.println("CUSTOMERPK::::" + customerPk);
            System.out.println("CUSTOMERNAME::::" + customerName);
            System.out.println("CUSTOMERADDRESS:::" + customerAddress);
        }*/
        // NAMED QUERIES
        Query q = session.getNamedQuery("ByEmpSal");
        q.setLong(0, 10000);
        List<Employee> emps = q.list();
        System.out.println(emps.size());

    }

}
