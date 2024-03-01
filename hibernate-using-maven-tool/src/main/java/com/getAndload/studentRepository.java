package com.getAndload;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class studentRepository {

	public static void main(String[] args) {
		System.out.println("Project Started.....");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
//		System.out.println(factory);
		System.out.println("Session Factory object create successfully...!!");

		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
//                     <<<<  get method>>>>
//		 Student st = (Student)session.get(Student.class, 1);
//		 System.out.println(st.getAdddress());
//		                 <<<<load method>>>
		Student st = (Student) session.load(Student.class, 5);
//		System.out.println(st.getName());

//            <<<update method>>>
		Student st1 = new Student();
//		st1.setId(9);
//		st1.setName("krishna");
//		st1.setAdddress("keral");
//		st1.setMarks(90);
//		session.save(st1);
//		st1.setAdddress("mumbai");
//		session.update(st1); //Do not call directly update() method ,so call first save() method first....

//		      <<< saveOrUpdate() >>>
		Student s2 = new Student();
//		s2.setId(9);
//		s2.setName("Raj");
//		s2.setAdddress("keral");
//		s2.setMarks(85);
//		
//		session.saveOrUpdate(s2);
//		s2.setMarks(87);
//		session.saveOrUpdate(s2);

//		     <<<Merg Method() >>>
		Student s3 = new Student();
		s3.setId(4);
		s3.setName("Rajesh");
		s3.setAdddress("Mumbai");
		s3.setMarks(83.0);
		session.evict(s3);
		s3.setAdddress("A.Nagar");
//		session.merge(s3);

		Student mergstudent = (Student) session.merge(s3);

		txn.commit();
		session.close();

		System.out.println("Successfully Added.......");

	}

}
