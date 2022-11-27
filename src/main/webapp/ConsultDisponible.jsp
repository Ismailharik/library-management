<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>    
 
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="Style.css" />
<head>
<title>Formulaire d'ajout de news</title>
</head>
<body>
	 <p style="text-align:right"> 
	   		<a href="login.action">	
	   		<s:property value="#session.etudiant.getNom()"  />
	   		: Se deconnecter ... </a>
 	</p>
<s:if test="%{exemplairesDispo }">  
 <TABLE style="width:"50px">
	<TR>
		<TH >Code</TH> 
		<TH >Titre</TH>
		
		
	</TR>
	<s:iterator value="exemplairesDispo" var="exemplaire">
	<TR>  
	 	<TD>  <s:property value="#exemplaire[0]"/>  </TD>
	 	<TD>  <s:property value="#exemplaire[1]"/>  </TD>
		<!--<TD>  <s:property value="titre"/>  </TD>  -->
	</TR>
	</s:iterator>
	
</TABLE>
 
</s:if>
<s:else >
	   Aucune Emprunt 
</s:else>  
		<BR><BR>
		<a href="ajoutEmprunt">Emprunt un exemplaire de livre... </a>

</body>
</html>