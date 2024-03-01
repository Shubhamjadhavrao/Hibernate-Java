package com.getAndload;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class studentRepository2 {

	public static void main(String[] args) {
		System.out.println("Project Started.....");
		Student s1 = new Student("Yash", "Karjat", 75.2);
		Student s2 = new Student("Lucky", "NaviMumbait", 68);
     	       Student s3 = new Student("Shubham", "Nasik", 70);
		

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = null;
		Transaction txn = null;

		try {
			 session = factory.openSession();
			txn = session.beginTransaction();
//			String hql = "INSERT INTO Student (name, address, marks)  SELECT name, address, marks FROM Student";
			 String hql = "FROM Student ";
//			String hql1 = "Update Student set name =:x Where id =:i";
			Query query = session.createQuery(hql);
//			query.setParameter("x", "Rajesh");
//			query.setParameter("i", 3);

			List res = query.getResultList();
			System.out.println("Rows affected: " + res);
			System.out.println(res);
//			session.save(res);
			txn.commit();
//			session.close();
		} catch (Exception e) {
			if (txn != null) {
				
				txn.rollback();
			}
			e.printStackTrace();
		}

		System.out.println("Successfully Added.......");

	}

}
