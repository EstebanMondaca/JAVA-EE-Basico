<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>.:: Registro de personal ::.</title>
</head>

<body>
<form method="post" action="/RegPersonal/LoginServlet">
  <h1> Ingreso del Usuario </h1>
    
  <p>
    <label>Login:</label>
    <input type="text" name="txtLogin"/>
  </p>
  <p>
    <label>Password:</label>
    <input type="password" name="txtPassword" />
  </p>
  <p>
    <input type="submit"  value="Ingresar" />
    <input type="reset"  value="Limpiar" />
  </p>
</form>
</body>
</html>