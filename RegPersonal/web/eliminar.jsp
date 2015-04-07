<%-- 
    Document   : eliminar
    Created on : Mar 29, 2015, 4:21:27 PM
    Author     : EstebanVaio
--%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>.:: Eliminar Personal ::.</title>
</head>

<body>
<form method="post" action="/RegPersonal/AdminDBServlet?prm=eliminar">
  <h1> Eliminar Personal </h1>
    
  <p>
    <label>Codigo:</label>
    <input type="text" name="txtCodigo"/>
  </p>
  <p>
    <input type="submit"  value="Eliminar" />
    <input type="reset"  value="Limpiar" />
  </p>
</form>
</body>
</html>
