package com.infotech;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class FetchDataClientTest_V24 {
	public static void main(String[] args) {
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			employee = session.get(Employee.class, 1);
			System.out.println(employee);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		if (employee != null) {
			employee.getAddressList().forEach(System.out::println);
		}
	}
}
