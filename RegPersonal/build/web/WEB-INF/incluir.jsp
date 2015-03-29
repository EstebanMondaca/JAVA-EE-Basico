<%-- 
    Document   : incluir
    Created on : Mar 29, 2015, 4:12:04 PM
    Author     : EstebanVaio
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>.:: Registro de personal ::.</title>
</head>

<body>
<form method="post" action="/RegPersonal/AdminDBServlet?prm=incluir">
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
    <input type="submit"  value="Incluir" />
    <input type="reset"  value="Limpiar" />
  </p>
</form>
</body>
</html>