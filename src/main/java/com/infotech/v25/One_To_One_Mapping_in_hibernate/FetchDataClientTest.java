package com.infotech.v25.One_To_One_Mapping_in_hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.infotech.util.HibernateUtil;

public class FetchDataClientTest {

	public static void main(String[] args) {
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			employee = session.get(Employee.class, 1);
			System.out.println(employee);
			Address address = employee.getAddress();
			System.out.println(address);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}
}
