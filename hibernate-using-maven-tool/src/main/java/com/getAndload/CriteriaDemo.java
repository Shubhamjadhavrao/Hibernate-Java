package com.getAndload;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.entity.Employee;

public class CriteriaDemo {

    public static void main(String[] args) {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	System.out.println(sessionFactory);
	System.out.println("session factory object created successfully!!");

	Session session = sessionFactory.openSession();
	String hql = "From Employee e Where e.Department='Marketing' ";
//	Query q = session.createQuery(hql);
//	List<Employee>empList =q.getResultList();

//	System.out.println(empList);
	Criteria criteria = session.createCriteria(Employee.class);
	// Retrieve employees in the Marketing department
//	criteria.add(Restrictions.eq("Department", "Marketing"));
//	List<Employee> emp = criteria.list();
//	System.out.println(emp);

	// Retrieve employees with salary greater than 50000
//	criteria.add(Restrictions.gt("Salary", 52000.0));
//	List<Employee> emp = criteria.list();
//	System.out.println(emp);

	// Retrieve employees with salary less than 50000
//	criteria.add(Restrictions.lt("Salary", 52000.0));
//	List<Employee> emp = criteria.list();
//	System.out.println(emp);

//	criteria.add(Restrictions.eq("id", 30));
//	Employee emp = (Employee) criteria.uniqueResult();
////	List<Employee> emp = criteria.list();
//	System.out.println(emp);

	// Retrieve employees with salary not equal to 50000
//	criteria.add(Restrictions.ne("Salary", 52000.0));
//	List<Employee> emp = criteria.list();
//	System.out.println(emp);

	// using Restrictions.like() and Restrictions.ilike()
//	criteria.add(Restrictions.like("Name", "Sarah Wang%",MatchMode.ANYWHERE));
//	List<Employee> emp = criteria.list();
//	System.out.println(emp);

	// Retrieve employees id between 10 and 20, working in either the Marketing or
	// Human Resources department, and earning a salary greater than 52000:
	criteria.add(Restrictions.between("id", 10,20));
	String[] department = new String[] {"Marketing","Sales"};
	criteria.add(Restrictions.in("Department", department));
	criteria.add(Restrictions.gt("Salary", 52000.0));
	List<Employee> emp = criteria.list();
	System.out.println("Employee:"+emp);

	session.close();
    }

}
