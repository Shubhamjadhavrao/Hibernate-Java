package com.hiber;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.entity.Department;
import com.entity.Employee;

public class StudentRepository {

	public static void main(String[] args) throws IOException {
		System.out.println("Project Started.....");
//		Address ad = new Address();
//		ad.setAddressId(3);
//		ad.setName("Ram");
//		ad.setCity("Mumbai");
		Employee em = new Employee("Shubham", "IT", 60000);
		Department dep = new Department();
		dep.setName("IT");
		FileInputStream fis = new FileInputStream("src/main/java/img.jpeg");
	    byte[] data = new byte[fis.available()];
	    fis.read(data);
		dep.setImage(data);

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		System.out.println("session factory object created successfully!!");



		
//		Student st = new Student();
//		st.setId(109);
//		st.setName("Ram");
//		st.setAddress("Pune");
////		
	

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
//		session.save(st);
//		session.save(ad);
		session.save(em);
		session.save(dep);
		tx.commit();

		session.close();
		System.out.println("Successfully Added.......");

//		System.out.println(factory.isClosed());
	}

}
