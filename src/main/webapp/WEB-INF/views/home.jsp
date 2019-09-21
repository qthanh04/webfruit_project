<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    

<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th>
<th>Name</th>
</tr>  

 <c:forEach var="product" items="${product}">   
   <tr>  
   <td>${product.id}</td>  
   <td>${product.name}</td>  
   </tr>  
   </c:forEach>   
 </table> 

</body>
</html>
