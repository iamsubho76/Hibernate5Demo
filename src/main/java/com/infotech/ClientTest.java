package com.infotech;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.beginTransaction();
			/*
			 * persist() -> This method is used to save an entity/object into
			 * database and return a void. It will throw an exception if an
			 * entity already exists in the database.
			 */
			session.persist(getEmployee1());

			/*
			 * save() -> This method is used to save an entity/object into
			 * database and return generated primarykey. It will throw an
			 * exception if an entity already exists in the database.
			 */
			Integer id = (Integer) session.save(getEmployee2());
			System.out.println("Employee is created  with Id::" + id);

			// saveOrUpdate()->This method is used to either save or update an
			// entity in the database.
			session.saveOrUpdate(getEmployee3());

			createEmployee(session);
	    	//getEmployeebyId(session);
	    	//updateEmployeeById(session);
	    	//deleteEmployeeById(session);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	//start
	//Below three methods for save, update and saveOrUpdate example
	private static Employee getEmployee3() {
		Employee employee = new Employee();
		employee.setEmployeeName("Martin Bingel");
		employee.setEmail("martin.cs2017@gmail.com");
		employee.setSalary(80000.00);
		employee.setDoj(new Date());
		return employee;
	}

	private static Employee getEmployee1() {
		Employee employee = new Employee();
		employee.setEmployeeName("Frank Bingel");
		employee.setEmail("frank.cs2017@gmail.com");
		employee.setSalary(30000.00);
		employee.setDoj(new Date());
		return employee;
	}

	private static Employee getEmployee2() {
		Employee employee = new Employee();
		employee.setEmployeeName("Sean Bingel");
		employee.setEmail("sean.cs2017@gmail.com");
		employee.setSalary(60000.00);
		employee.setDoj(new Date());
		return employee;
	}
	//end
	
	//start
	//below example for CRUD operation
	private static void deleteEmployeeById(Session session) {
		Employee employee = session.get(Employee.class, 2);
		if(employee != null){
			session.beginTransaction();
			
			session.delete(employee);
			session.getTransaction().commit();
		}else{
			System.out.println("Employee doesn't exist with provideded Id..");
		}
	}

	private static void updateEmployeeById(Session session) {
		Employee employee = session.get(Employee.class, 2);
		if(employee != null){
			employee.setSalary(40000.00);
			session.beginTransaction();
			
			session.update(employee);
			session.getTransaction().commit();
		}else{
			System.out.println("Employee doesn't exist with provideded Id..");
		}
	}

	private static void getEmployeebyId(Session session) {
		Employee employee = session.get(Employee.class, 20);
		if(employee != null){
			System.out.println(employee);
		}else{
			System.out.println("Employee doesn't exist with provideded Id..");
		}
	}

	private static void createEmployee(Session session) {
		session.beginTransaction();
		Integer id =(Integer)session.save(getEmployee());
		System.out.println("Employee is created  with Id::"+id);
		session.getTransaction().commit();
	}
	
	private static Employee getEmployee(){
		Employee employee= new Employee();
		employee.setEmployeeName("Martin Bingel");
		employee.setEmail("martin.cs2017@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());
		return employee;
	}
	//end
}