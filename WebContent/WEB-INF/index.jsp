<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="beans.Utilisateur"%>
<%@page import="java.util.ArrayList"%>

<%-- <% String appRoot=request.getContextPath(); 
ArrayList<Utilisateur> utilisateurs = (ArrayList<Utilisateur>) request.getAttribute("utilisateurs");
System.out.println(utilisateurs);
 --%>
<%-- <% String appRoot=request.getContextPath(); %> --%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <jsp:useBean id="utilisateurs" scope="request" type="ArrayList<Utilisateur>"/>
 --%>
 

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Gestion des Utilisateurs </title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/design.css"/>" >
	<script src=" <c:url value="./js/script.js"/>"> </script> 
	<!-- Font Awesome -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.1/mdb.min.css"
  rel="stylesheet"
/>
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.1/mdb.min.js"
></script>
	<style>
			.alert-danger
			{
				background-color: #ff4444;color:white;padding: 20px 0px 20px 15px;font-size: 22px;
			}
			
			.alert-success
			{
				background-color: #00C851;color:white;padding: 20px 0px 20px 15px;font-size: 22px;
			}
	</style>
	</head>
	<body>
		<div id="entete" >Gestion des Utilisateurs</div>
		 
		<div id="menu">
		  <ul>
		    <li><a href="<c:url value="/acceuil"/>"> Acceuil </a> </li> 
		    <c:choose>
		    	<c:when test="${!empty sessionScope.utilisateur }"> 
			     <li><a href="<c:url value="/list"/>">Lister </a> </li> 
			      <li><a href="<c:url value="/add"/>"> Ajouter </a> </li> 
			       <li><a href="<c:url value="/logout"/>"> Disconnect </a> </li> 
			      
		       </c:when>
		       <c:otherwise>
		          <li><a href="<c:url value="/login"/>"> Connect </a> </li> 
		       </c:otherwise>
		       
		      </c:choose> 
		  </ul>
		</div>
		 <div id="corps">
		<c:if  test="${status}">
		 <div id="statusMessagBox" class="alert alert-success">
		 <span id="control" onclick="hideMessageBox()" title="Fermer"></span> 
		 ${param.message}
		 </div>
		</c:if>
			<br/>
		   <h1 id="titre-principal">Liste des Utilisateurs</h1>
		 
		     <c:choose> 
		       <c:when test="${ empty requestScope.utilisateurs }">
		       <p style="background-color: #ffbb33;color:white;padding: 20px 0px 20px 15px;font-size: 22px;"> La liste est vide </p>
		       </c:when>
		    
		       <c:when test="${ !empty requestScope.utilisateurs }">
		    
		          
		      		<table class="table table-striped" style="width: 80%; margin-left: 10%;">
		      		
					    <tr class="text-white"> 
					       <th class="text-white">ID </th>
					       <th class="text-white">Nom Complet</th>
					       <th class="text-white">Login</th>
					       <th class="text-white" colspan="2">Actions</th>
					    </tr>
					    <c:forEach items="${requestScope.utilisateurs}" var="utilisateur"> 
					  	 <jsp:useBean id="utilisateur" scope="request" class="beans.Utilisateur"/>
					  	  
								<tr>  
						    	<td> <c:out value="${utilisateur.id }"/> </td> 
						    	<td>  <c:out value="${utilisateur.nom }"/> </td>  
						     
								 <td>  <c:out value="${utilisateur.login }"/></td>  
								
							     <td>  <a href="update?id=<c:out value="${utilisateur.id }"/>"> Modifier</a> </td> 
							     <td>  <a href="delete?id=<c:out value="${utilisateur.id }"/>"> Supprimer</a> </td>  
						    </tr>
						    
						    </c:forEach>
						
		     		  
					   
				    </table>
				    </c:when>
				   </c:choose>
		    
		   
		</div> 
		

						  
					 
		
		
		<div id="pied">
		Copyright &copy; DD 2020 
		</div>
	</body>
</html>
