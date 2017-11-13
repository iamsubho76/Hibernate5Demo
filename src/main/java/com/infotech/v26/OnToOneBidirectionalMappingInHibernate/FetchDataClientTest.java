package com.infotech.v26.OnToOneBidirectionalMappingInHibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.infotech.util.HibernateUtil;

public class FetchDataClientTest {

	public static void main(String[] args) {
		// getEmployeeAndAdressByEmployeeId();
		getEmployeeAndAdressByAddressId();

	}

	private static void getEmployeeAndAdressByAddressId() {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Address address = session.get(Address.class, 1);
			System.out.println(address);
			System.out.println(address.getEmployee());
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	private static void getEmployeeAndAdressByEmployeeId() {
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