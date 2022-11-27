<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire d'autentification</title>
</head>
<body>
 	<center>
		<div id="formulaire">
		<s:form action="validerLogin" method="post">
			<s:textfield label="login"  name="cne" placeholder="CNE"></s:textfield>
			<s:textfield label="password"  name="motPasse"  placeholder="Password"></s:textfield>
			<s:submit value="OK"></s:submit >
		</s:form>
				
				<a href="inscription.action">S'inscrire ... </a><br/>
		</div>
</center>
 
</body>
</html>