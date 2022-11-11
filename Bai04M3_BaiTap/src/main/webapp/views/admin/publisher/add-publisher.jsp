<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="me"%>

<me:tranghome title="Add new publisher">
	<jsp:attribute name="content">
	<h2>Add New Publisher</h2><br>
	<p>${message}</p>
	<form action="AddNewPublisherServlet" method="post" style="margin-left:20px;">
		<p><label>Name</label><input type="text" name="publisherName">
		<p><input type="submit" value="Save" name="btnSave" style="background-color: blue; border: none; color: white;"></p>
	</form>
	
	</jsp:attribute>
	
</me:tranghome>