<%@ page import="Complexity.ControlStructures.ComplexityMeasureCs"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Line no</th>
      <th scope="col">Program statements</th>
      <th scope="col">Wtcs </th>
      <th scope="col">NC </th>
      <th scope="col">Ccspps </th>
      <th scope="col">Ccs </th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>class Pattern { </td>
      <td></td>
      <td></td>
      <td></td>
      <td>0</td>
      
    </tr>
    <tr>
      <th scope="row">2</th>
      <td> public static void main(String[] args) { </td>
      <td></td>
      <td></td>
      <td></td>
      <td>0</td>
      
    </tr>
    <tr>
      <th scope="row">3</th>
      <td> int rows = 5; </td>
      <td></td>
      <td></td>
      <td></td>
      <td>0</td>
      
    </tr>
     <tr>
      <th scope="row">4</th>
      <td> for(int i = 1; i <= rows; ++i) { </td>
      <td>3</td>
      <td>1</td>
      <td></td>
      <td>3</td>
     
    </tr>
    <tr>
      <th scope="row">5</th>
      <td> for(int j = 1; j <= i; ++j) { </td>
      <td>3</td>
      <td>1</td>
      <td>3</td>
      <td>6</td>
      
    </tr>
    <tr>
      <th scope="row">6</th>
      <td>System.out.print(j + " "); </td>
      <td></td>
      <td></td>
      <td></td>
      <td>0</td>
      
    </tr>
     <tr>
      <th scope="row">7</th>
      <td> } </td>
      <td></td>
      <td></td>
      <td></td>
      <td>0</td>
      
    </tr>
    <tr>
      <th scope="row">8</th>
      <td> System.out.println("");</td>
      <td></td>
      <td></td>
      <td></td>
      <td>0</td>
      
    </tr>
    <tr>
      <th scope="row">9</th>
      <td> } </td>
      <td></td>
      <td></td>
      <td></td>
      <td>0</td>
     
    </tr>
    <tr>
      <th scope="row">10</th>
      <td> } </td>
      <td></td>
      <td></td>
      <td></td>
      <td>0</td>
      
    </tr>
     <tr>
      <th scope="row">11</th>
      <td> } </td>
      <td></td>
      <td></td>
      <td></td>
      <td>0</td>
      
    </tr>
  </tbody>
</table>

<%
     {
	ComplexityMeasureCs Obj = new ComplexityMeasureCs();
        Obj.measureComplexity();
     }
    %>


</body>

</html>