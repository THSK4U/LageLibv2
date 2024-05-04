<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Employee Register Form</h1>
  <form action="Registration" method="post">
   <table style="with: 80%">
    <tr>
     <td>First Name</td>
     <td><input type="text" name="prenom_mb" /></td>
    </tr>
    <tr>
     <td>Last Name</td>
     <td><input type="text" name="nom_mb" /></td>
    </tr>
    <tr>
     <td>UserName</td>
     <td><input type="text" name=username /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
     <td>Address</td>
     <td><input type="text" name="ladresse" /></td>
    </tr>
    <tr>
     <td>Numéro Téléphone</td>
     <td><input type="text" name="numérotéléphone" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>