package com.infotech;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.model.Address;
import com.infotech.util.HibernateUtil;

public class SaveDataClientTest_V24 {
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			createEmployee(session);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	private static void createEmployee(Session session) {
		session.beginTransaction();
		Integer id = (Integer) session.save(getEmployee());
		System.out.println("Employee is created  with Id::" + id);
		session.getTransaction().commit();

	}

	private static Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeName("Barry Bingel");
		employee.setEmail("barry.cs2017@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());

		Address address1 = new Address();
		address1.setCity("Chennai");
		address1.setPincode(9087727L);
		address1.setState("Tamilnadu");
		address1.setStreet("Park Street");

		Address address2 = new Address();
		address2.setCity("Pune");
		address2.setPincode(90870988L);
		address2.setState("MH");
		address2.setStreet("XYZ Street");

		employee.getAddressList().add(address1);
		employee.getAddressList().add(address2);

		return employee;
	}
}
