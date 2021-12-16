<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.Utilisateur"%>
<%@page import="java.util.ArrayList"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion To Ges_User</title>
<link rel="stylesheet" type="text/css" href="./css/design.css" />
</head>
<body style="height: 100vh;width: 100%;overflow: hidden;display: flex;justify-content: center;align-items: center;">		 
		
		<div class="loginContainer" style="width: 60vh;height: 60vh;display: flex;flex-flow: column;border-radius: 5px;align-items: center;background-color: #eee;padding: 5vh 30px;">
		
				<h2>Bienvenue sur votre plateforme de Gestion des utilisateurs</h2>
				<br><br>
				<form method="POST" style="width: 100%;height: 100%;border:unset;display:flex;justify-content:center;align-items:center;flex-flow: column;"> 
				
				<div style="width: 80%;height: 50px;">
						<input type="text"	name="login" value="${login }" placeholder="Login." style="border: unset;outline: none;width: 100%;height: 100%;padding: 0px 10px;">
				</div>
				<br><br>
				<div style="width: 80%;height: 50px;">
						<input type="password" name="password" placeholder="Password." style="border: unset;outline: none;width: 100%;height: 100%;padding: 0px 10px;">
				</div>
				<br><br><br><br>
				<div style="width: 100%;display: flex;justify-content: center;align-items: center;">
						<button type="submit" style="padding: 15px 40px;background-color: white;border: #737373 1px solid;cursor: pointer;border-radius: 50px;">
								Connexion
						</button>
				</div>
				</form>				
		</div>
</body>
<body>

  <div id="pied">
		Copyright &copy; DD 2020 
		</div>
</body>
</html>