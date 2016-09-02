package com.ibm.cio.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.*;

import com.ibm.cio.coreu.HibernateUtil;
import com.ibm.cio.data.Cargos;
import com.ibm.cio.data.Empleados;


/**
 * Servlet implementation class SaveData
 */
@WebServlet("/SaveData.do")
public class SaveData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		HttpSession session = request.getSession();
		
		//Obtencion de valores del formulario
		String nombre = request.getParameter("nombre").toString();
		String sexo = request.getParameter("sexo").toString();
		int cargo = Integer.parseInt(request.getParameter("cargo").toString());
		String dpto = request.getParameter("dpto").toString();
		String ciudad = request.getParameter("ciudad").toString();
		String zona = request.getParameter("zona").toString();
		String ingreso = request.getParameter("ingreso").toString();
		
		// Creacion del objeto y seteo de parametros 
		
		System.out.println("guardo valores");
		
		Empleados empleado = new Empleados();
		Cargos cargo2 = getCargo(cargo);
		
		System.out.println("devolvio el CARGO");		
		empleado.setCargo(cargo2);
		empleado.setCiudad(ciudad);
		empleado.setCodigo(1234);
		empleado.setDpto(dpto);
		empleado.setNombre(nombre);
		empleado.setIngreso(ingreso);
		empleado.setSexo(sexo);
		empleado.setZona(zona);
		
		System.out.println("hizo el seteo");
		
		if(saveEmpleado(empleado)){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/infoSaved.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/error.jsp");
			rd.forward(request, response);
		}
	}
	
	public Cargos getCargo(int cargo){
		Cargos cargo2 = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			
			cargo2 = session.get(Cargos.class, cargo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cargo2;
	}
	
	public boolean saveEmpleado(Empleados empleado){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.save(empleado);
			session.getTransaction().commit();
			System.out.println("Exito!");
			session.close();
			return true;

		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		return false;
	}

}
