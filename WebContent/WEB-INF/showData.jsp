<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="java.util.List"%>
<%@ page import="com.ibm.cio.data.Empleados"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class='table table-condensed table-hover'>
															<thead>
													<tr>
														<th>id</th>
														<th>nombre</th>
														<th>sexo</th>
														<th>cargo</th>
														<th>sueldo</th>
														<th>dpto</th>
														<th>ciudad</th>
														<th>zona</th>
														<th>ingreso</th>

													</tr>
												</thead>
												<tbody>
													<%
													List<Empleados> employees = (List) session.getAttribute("lista");
												for (Empleados employee : employees) {
													out.print("<tr><td>" + employee.getCodigo());
													out.print("<td>" + employee.getNombre());
													out.print("<td>" + employee.getSexo());
													out.print("<td>" + employee.getCargo().getCargo());
													out.print("<td>" + employee.getCargo().getSueldo());
													out.print("<td>" + employee.getDpto());
													out.print("<td>" + employee.getCiudad());
													out.print("<td>" + employee.getZona());
													out.print("<td>" + employee.getIngreso());
													out.print("</tr>");
													}
													%>
</body>
</html>