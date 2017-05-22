<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="Page.css" rel="stylesheet">
</head>
<body>
		 <div class="container">
 		<form class="form-signin" action="ConnexionServlet" method="post">
       <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous conncter via ce formulaire.</p>

                <label for="text">Nom <span class="nom">*</span></label>
                <input type="text" id="email" name="nom" value="" size="20" maxlength="60" required/>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" required/>
                <br />

                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
            </fieldset>
        </form>
      <a href="inscription">S'inscrire</a>
    </div> <!-- /container -->

		
</body>
</html>