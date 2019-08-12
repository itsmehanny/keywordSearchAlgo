<%@ page import ="java.util.*" %>
<%@ page import ="com.keyword.pojo.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<body>
			<h1>Keyword Search Algorithm</h1>
			<br></br> <br></br>
				<h3>Case Insensitive Search Algorithm</h1>
				<form action="/keywordSearchAlgorithm/" method="get">
					<input type="text" name="inputString" /> 
					<input type="submit" value="search" />
				</form>
			</body>
			
			<br></br> <br></br>
			<table border="1" cellpadding="5">
            <tr>
                <th>MovieID</th>
                <th>Movie Name</th>
                <th>Comment</th>
            </TR>
            <% 
            List result= (List) request.getAttribute("searchResults");
			Iterator it = result.iterator();
			while(it.hasNext()){
			    RecordObject obj= (RecordObject) it.next();
	   		%>
	            <Tr>
	                <td> <%= obj.getMovieId() %></td> 
	                <td> <%= obj.getMovieName() %></td>
	                <td> <%= obj.getComment() %></td>
	               	<td>
		              <form action="/keywordSearchAlgorithm/" method="post">
		                <input type="hidden" name="recordId" value="<%= obj.getMovieId() %>">
						<input type="submit" value="delete" />
					 </form>
				 </td>
	             
	            </Tr>
	            <% } %>
			
        </table>
	</head>
</html>