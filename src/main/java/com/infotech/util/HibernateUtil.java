package com.infotech.util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	private static Configuration cfg = null;
	static {
		if (sessionFactory == null) {
			try {
				URL resource = HibernateUtil.class.getResource("/hibernate_oracle.cfg.xml");
				// Create StandardServiceRegistry
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure(new File(resource.toURI())).build();
				// Create MetadataSources
				MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
				// Create Metadata
				Metadata metadata = metadataSources.getMetadataBuilder().build();
				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				e.printStackTrace();
				if (standardServiceRegistry != null) {
					StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
				}
			}
		}
	}

	// Utility method to return SessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}