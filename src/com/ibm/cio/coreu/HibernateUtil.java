/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.cio.coreu;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Administrator
 */
public class HibernateUtil {
	  private static final SessionFactory sessionFactory;      
	  static {    
		  try {      
		  // Create the SessionFactory from hibernate.cfg.xml     
		  sessionFactory = new Configuration().configure().buildSessionFactory(); 
		  System.out.println("se creo la session");
		  } catch (Throwable ex) {      
			  // Log the exception.      
			  System.err.println("SessionFactory creation failed." + ex);      
			  throw new ExceptionInInitializerError(ex);    
			  }  
	  }  
	  public static SessionFactory getSessionFactory() {    
		  return sessionFactory;  
		  }  
	  public static void shutdown() {    
		  // Close caches and connection pools    
		  getSessionFactory().close();  
		  }
		
	  }
