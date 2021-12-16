<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String appRoot=request.getContextPath(); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Ajouter Utilisateur </title>
<link rel="stylesheet" type="text/css" href="<%=appRoot%>/css/design.css">
	<script src="<%=appRoot%>/js/script.js"></script> 
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
		    <li><a href="<%=appRoot%>/acceuil"> Acceuil </a> </li> 
		     <li><a href="<%=appRoot%>/list">Lister </a> </li> 
		      <li><a href="<%=appRoot%>/add"> Ajouter </a> </li> 
		        
		  </ul>
		</div>
		
  <div id="corps">
			<c:if test="${ !empty form }">
				<div id="statusMessageBox" class="alert alert-${ form.status ? 'succes' : 'danger' }">
					<span  id="control" onclick="hideMesageBox()" title="fermer"></span>
					${ form.statusMessage }
				</div>
			</c:if>
			<h1 id="titre-principal">Ajout d'un utilisateur</h1>
			<form action="" method="post">
					<div class="formItem">
						<label>Nom</label>
						<input type="text" name="nom" value="${form.utilisateur.nom }"><br/>
						<span class="erreur">${form.erreurs.nom}</span>
					</div>
					<div class="formItem">
						<label>Prenom</label>
						<input type="text" name="prenom" value="${ form.utilisateur.prenom }"><br/>
						<span class="erreur"> ${form.erreurs.nom}</span>
					</div>
					<div class="formItem">
						<label>Login</label>
						<input type="text" name="login" value="${form.utilisateur.login }"><br/>
						<span class="erreur">${form.erreurs.login}</span>
					</div>
					<div class="formItem">
						<label>Password</label>
						<input type="password" name="password"><br/>
						<span class="erreur" >${form.erreurs.password}</span>
					</div>
					<div class="formItem">
						<label>Password(bis)</label>
						<input type="password" name="passwordBis"><br/>
						<span class="erreur" >${form.erreurs.passwordBis}</span>
					</div>
					<div class="formItem">
						<label></label>
						<input type="submit" value="Ajouter">
					</div>
			</form>
	</div>
  
  <div id="pied">
		Copyright &copy; DD 2020 
		</div>
   

</body>
</html>