<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/SaveData.do" method="post">
<label>Nombre</label>
<input type="text" name="nombre" id="nombre">
<br><br>
<label>Sexo</label>
<select name="sexo">
<option value="Femenino">Femenino</option>
<option value="Masculino">Masculino</option>
</select>
<br><br>
<label>Cargo</label>
<select name="cargo">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select>
<br><br>
<label>Departamento</label>
<select name="dpto">
<option value="Finanzas">Finanzas</option>
<option value="General">General</option>
<option value="Ventas">Ventas</option>
<option value="Produccion">Produccion</option>
</select>
<br><br>
<label>Ciudad</label>
<input type="text" name="ciudad">
<br><br>
<label>Zona</label>
<input type="text" name="zona">
<br><br>
<label>Ingreso</label>
<input type="text" name="ingreso">
<br> <br>
<input type="submit" value="Save Data :D">
</form>
</body>
</html>