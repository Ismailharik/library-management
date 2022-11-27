<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*, metier.*" %>
<%@ taglib prefix ="s" uri="/struts-tags" %>
    
<!DOCTYPE html>
<html>
<head>

<title>Formulaire d'ajout d'emprunt</title>
</head>
<body>
<center>
	<div >
	 <p style="text-align:right"> 
	   		<a href="login.action">	
	   		<s:property value="#session.etudiant.getNom()" />
	   		: Se deconnecter ... </a>
	 </p>			
		<s:form method ="post" action="validerAjoutEmprunt">

			<s:textfield name="cne" id="cne" 
			     value= "%{#session.etudiant.CNE}" readonly="true"
				label="CNE" labelposition="left" >
			</s:textfield>
			
			<s:select id="codeExemplaire" name="codeExemplaire" label="Code Exemplaire"
				list="codeExemplairesDispo"/>
			
			<s:submit value = "valider"> </s:submit>
				
		</s:form>	
		
		<BR><BR>
		<a href="ConsultDisponible">Consulter les exemplaires disponible... </a>
			
	</div>
</center>

</body>
</html>