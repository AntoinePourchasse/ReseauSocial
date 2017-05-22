<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="NewMessage">
            <fieldset>
                <legend>Ecrire un message</legend>
                <p>Titre <input type = "text" name="titre"> <br>
                <input type="radio" name="chooseone" value=0 checked><label for="public">Public</label><br> 
               <input type="radio" name="chooseone" value=1><label for="Prive"> Privé</label><br>  
				
				Message <br>
				<input type="textarea" row="3" name="contenu">
                </p>
                <input type = submit value="Valider">
                </fieldset>
            </form>
</body>
</html>