<%@ page import="Handler.ReadFile"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="tab">
 	 <a href="Home.jsp">Home</a>
 	 <a href="SizeVariable.jsp">Size Variable</a>
 	 <a href="Inheritance.jsp">Inheritance</a>
 	 <a href="Coupling.jsp">Coupling</a>
  	 <a href="ControlStructures.jsp">Control Structures</a>
	</div>
	
	 <form action="FileUploadHandler" enctype="multipart/form-data" method="post">
 		<br>
 		Select<input type="file" name="file2" /><br>
 		<input type="submit" value="upload" />
 	</form>
	<%
		String file_name = (String) request.getParameter("filename");
	if (file_name != null) {
		out.println(" File uploaded successfuly");
	}
	%>



	
	<%
		ReadFile Obj = new ReadFile();
		out.print(Obj.read());
	%>

</body>
</html>