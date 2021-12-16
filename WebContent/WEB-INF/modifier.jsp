<%@page import="beans.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
	String appRoot = request.getContextPath();
	
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Modifier Utilisateur</title>
	<link rel="stylesheet" type="text/css" href="<%= appRoot  %>/css/design.css">
</head>
<body>
	<div id="entete">Gestion des utilisateurs</div>
	<div id="menu">
		<ul>
			<li><a href="/">Accueil</a></li>
			<li><a href="users/list">Lister</a></li>
			<li><a href="users/add">modifier</a></li>
		</ul>
	</div>
	<div id="corps">
	<h1 id="titre-principal">Modification d'un utilisateur</h1>
	<form action="" method="post">
		<div class="formItem">
			<label>Nom complet</label>
			<input type="text" name="prenom" value="<c:out value="${utilisateur.nom }" />">
		</div>
		<div class="formItem">
			<label>Login</label>
			<input type="text" name="login" value="<c:out value="${utilisateur.login }" />">
		</div>
		<div class="formItem">
			<label>Password</label>
			<input type="password" name="password" value="<c:out value="${utilisateur.password }" />">
		</div>
		<div class="formItem">
			<label></label>
			<input type="submit" value="modifier">
		</div>
	</form>
	</div>
	<div id="pied">footer</div>
</body>