<%@ page import ="java.util.*" %>
<%@ page import ="com.keyword.pojo.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<body>
				<h1>Upload File:</h1>
		 
				<div>
		            <h3> Choose File to Upload in Server </h3>
		            <form action="/keywordSearchAlgorithm/" method="post" enctype="multipart/form-data">
		                <input type="file" name="file" />
		                <input type="submit" value="upload" />
		            </form>          
        		</div>
				
			
			<h2>Keyword Search Algorithm</h2>
			<br></br> <br></br>
				<h3>Case Insensitive Search Algorithm</h3>
				<form action="/keywordSearchAlgorithm/" method="get">
					<input type="text" name="inputString" /> 
					<input type="submit" value="search" />
				</form>
			</body>
	</head>
</html>