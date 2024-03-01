package com.getAndload;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//@Entity
//@Table(name = "Student")
////Using @NamedQuery for single JPQL or HQL
//@NamedQuery(name = "GET_Students_COUNT", query = "select count(1) from Student")
//
////Using @NamedQueries for multiple (Group queries)JPQL or HQL
//@NamedQueries({
//    @NamedQuery(name = "GET_STUDENT_BY_ID", query = "from Student where id=:id"),
//	@NamedQuery(name = "GET_ALL_STUDENTS", query = "from Student") })
//
////@NamedNativeQuery works very similar to @NamedQuery except we need to write the native SQL statements instead of HQL.
//@NamedNativeQueries({ 
//    @NamedNativeQuery(name = "GET_STUDENT_BY_NAME", query = "select * from student where id=:id"),
//	@NamedNativeQuery(name = "GET_ALL_Address", query = "select * from student",resultClass=Student.class) })

public class Student {
    @Id
//	@GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    @Column
    private String Name;
    @Column
    private String Adddress;
    @Column
    private double marks;

    public Student() {
	super();
	// TODO Auto-generated constructor stub
    }

    public Student(String name, String adddress, double marks) {
	super();

	Name = name;
	Adddress = adddress;
	this.marks = marks;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return Name;
    }

    public void setName(String name) {
	Name = name;
    }

    public String getAdddress() {
	return Adddress;
    }

    public void setAdddress(String adddress) {
	Adddress = adddress;
    }

    public double getMarks() {
	return marks;
    }

    public void setMarks(double marks) {
	this.marks = marks;
    }

    @Override
    public String toString() {
	return "Student [id=" + id + ", Name=" + Name + ", Adddress=" + Adddress + ", marks=" + marks + "]";
    }

}
