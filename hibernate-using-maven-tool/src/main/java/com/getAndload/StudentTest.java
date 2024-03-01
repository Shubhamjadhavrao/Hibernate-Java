package com.getAndload;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentTest {

	public static void main(String[] args) {
		System.out.println("Project Started.....");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
//		System.out.println(factory);
		System.out.println("Session Factory object create successfully...!!");

		Student st = new Student();
		st.setId(1);
		st.setName("Ram");
		st.setAdddress("Nasik");
		st.setMarks(70);
		

		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		session.save(st); // persistent state
		
//		session.evict(st);//Detached State

		txn.commit();
		session.close();

		System.out.println("Successfully Added.......");

	}

}
