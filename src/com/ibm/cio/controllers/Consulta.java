package com.ibm.cio.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.ibm.cio.coreu.HibernateUtil;
import com.ibm.cio.data.Empleados;

/**
 * Servlet implementation class Consulta
 */
@WebServlet("/Consulta.do")
public class Consulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consulta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session sessionHibernate = sessionFactory.openSession();
		
		Criteria criteria = sessionHibernate.createCriteria(Empleados.class);
		criteria.add(Restrictions.eq("sexo","FEMENINO"));
		criteria.createAlias("cargo", "c");
		criteria.add(Restrictions.gt("c.sueldo", 1000));
		List<Empleados> employees = criteria.list();
		
		HttpSession session = request.getSession();
		session.setAttribute("lista", employees);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/showData.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
