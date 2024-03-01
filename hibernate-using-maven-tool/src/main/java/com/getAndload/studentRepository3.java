package com.getAndload;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class studentRepository3 {

    public static void main(String[] args) {
	System.out.println("Project Started.....");
	Student s1 = new Student("Yash", "Karjat", 75.2);
	Student s2 = new Student("Lucky", "NaviMumbait", 68);
	Student s3 = new Student("Shambhu", "Nasik", 70);

	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	Session session = null;
	Transaction txn = null;

	try {
	    session = factory.openSession();
	    txn = session.beginTransaction();
	    List<Object> totalStudent = session.createNamedQuery("GET_Students_COUNT").getResultList();
	    System.out.println("Total Students: " + totalStudent.get(0));

	    Student student = (Student) session.createNamedQuery("GET_STUDENT_BY_ID", Student.class)
		    .setParameter("id", 1).getSingleResult();

	    System.out.println(student.getName());

	    List<Student> list = session.createNamedQuery("GET_ALL_STUDENTS", Student.class).getResultList();
	    for (Student student1 : list) {
		System.out.println("Id:" + student1.getName() + "\tMarks:" + student1.getMarks() + "\tAddress:"
			+ student1.getAdddress());
	    }

	    txn.commit();
	} catch (Exception e) {
	    if (txn != null) {

		txn.rollback();
	    }
	    e.printStackTrace();
	}

	System.out.println("Successfully Added.......");

    }

}
