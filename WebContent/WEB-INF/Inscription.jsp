<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="Page.css" rel="stylesheet">
    </head>
    <body>
    <div class="container">
        <form method="post" action="inscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

                <label for="text">E-mail <span class="nom">*</span></label>
                <input type="text" id="email" name="nom" value="" size="20" maxlength="60" required/>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" required/>
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20"  required/>
                <br />

               

                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
                
            </fieldset>
        </form>
        </div>
    </body>
</html>