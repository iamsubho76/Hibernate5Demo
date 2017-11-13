package com.infotech.v27.OneToManyMappingInHibernate;

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

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	private static void getEmployeeAndAdressByEmployeeId() {
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}