<%-- 
    Document   : Modificar
    Created on : Mar 29, 2015, 4:17:40 PM
    Author     : EstebanVaio
--%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>.:: Modificar de personal ::.</title>
</head>

<body>
<form method="post" action="/RegPersonal/AdminDBServlet?prm=modificar">
  <h1> Incluir Personal </h1>
    
  <p>
    <label>Codigo:</label>
    <input type="text" name="txtCodigo"/>
  </p>
  <p>
    <label>Nombre:</label>
    <input type="text" name="txtNombre" />
  </p>
  <p>
    <label>Departamento:</label>
    <input type="text" name="txtDepartamento" />
  </p>
  <p>
    <input type="submit"  value="Modificar" />
    <input type="reset"  value="Limpiar" />
  </p>
</form>
</body>
</html>