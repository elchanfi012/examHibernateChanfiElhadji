<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<h1>Bienvenue sur le dasboard</h1>
	
	<h2> Liste de marques</h2>
	
	 	<div style="display:inline-block;">
	 		<c:forEach items="${ requestScope.marques}" var="marque">
				<p> ${ marque }</p>
			</c:forEach>
	 	</div>
	 	
	 	<div style="display:inline-block;">
	 		<c:forEach items="${ requestScope.nbCarsMarques}" var="nbCarsMarque">
				<p> ${ nbCarsMarque }</p>
			</c:forEach>
	 	</div>
	<h2> Nombre de vehicules dans la bdd</h2>	
		<p>Nb vehicules : ${ requestScope.nbCars }</p>
		
	<h2> Les 10 derniers voitures ajoutées</h2>
		<c:forEach items="${ requestScope.tenLatestCars}" var="car">
				<p> 
					${ car.marque }  ${ car.modele } ajouteé le 
					<fmt:formatDate pattern="dd/MM/yyyy" value="${ car.dateAjout }"/>
				</p>
		</c:forEach>
</body>
</html>