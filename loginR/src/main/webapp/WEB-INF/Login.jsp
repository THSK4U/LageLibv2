<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="<%= request.getContextPath() %>/Login" method="post">
   <table style="with: 80%">
    <tr>
     <td>username</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>password</td>
     <td><input type="text" name="password" /></td>
    </tr>
   </table>
   <input type="Login" value="Login" />
  </form>
</body>
</html>