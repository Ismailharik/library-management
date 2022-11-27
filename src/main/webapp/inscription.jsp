<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix ="s" uri="/struts-tags" %>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire d'inscription</title>
<style>
td{
margin-bottom:-210px
}
</style>
</head>
<body>
<center>

	<div style="width:50%;hight:300px">
		
		
		<table >
		<s:form  action ="validerInscription" method="post"  >
		  <tr>
		    <th>CN :</th>
		    <td><s:textfield name="cne" /></td>
</tr>
		  <tr>
		    <th>Nom : </th>
		    <td><s:textfield name="nom"/></td>
		  </tr>
		  <tr>
		    <th>Prenom</th>
		    <td><s:textfield name="prenom"/></td>
		  </tr>
		  <tr>
		    <th>Mot de passe</th>
		    <th><s:textfield name="motPasse"/></th>
		  </tr>
		  <s:submit></s:submit>
		  	</s:form>
		</table>
		
	
		
	</div>
</center>
		
</body>
</html>
