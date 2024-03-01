package com.getAndload;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.entity.Employee;

public class projectionIncriteria {
    public static void main(String[] args) {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	System.out.println(sessionFactory);
	System.out.println("session factory object created successfully!!");

	Session session = sessionFactory.openSession();
	// Retrieve the average salary of employees in the Marketing department:
	Criteria criteria = session.createCriteria(Employee.class);
//	criteria.setProjection(Projections.avg("Salary"));
//	criteria.add(Restrictions.eq("Department", "Marketing"));
//	Double avgSalary = (Double) criteria.uniqueResult();
//	System.out.println("Avg Salary of Employee:"+avgSalary);

	// Retrieve distinct departments where employees are working:
//	criteria.setProjection(Projections.distinct(Projections.property("Department")));
//	List<String>dep =  criteria.list();
//	System.out.println(dep);

	// Count the total number of employees:
//	criteria.setProjection(Projections.rowCount());
//	Long totalCount = (Long) criteria.uniqueResult();
//	System.out.println("Totalcount of rowsS:"+totalCount);

	// Retrieve distinct department names with the count of employees in each
	// department:
	ProjectionList projectionList = Projections.projectionList()
		.add(Projections.groupProperty("Department"))
		.add(Projections.count("id"));
	criteria.setProjection(projectionList);
	List<Object[]> emp = criteria.list();
	for (Object[] row : emp) {
	    String dep = (String) row[0];
	    Long count = (Long) row[1];
	    System.out.println("Department:" + dep + ",Count:" + count);
	}

    }

}
