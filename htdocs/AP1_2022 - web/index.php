<?php
session_start();

      if (isset($_POST['deco']))
            {
              session_destroy();
              //détruit la session après clique sur bouton deconnexion
              echo "<br><font color='red'><center><h3>Vous avez bien été deconnecté de votre session.</h3></center></font>";
            } 
?>
<html>
<head> <link href="style.css" media="all" rel="stylesheet" type="text/css"/> </head>
<title>Stage</title>
<body>

<div>
<form method="POST" action="accueil.php">
    <center><h2>
    <br><br>Identifiant :  <input type="text" name="login"><br><br>
    Mot de passe : <input type="password" name="mdp"><br><br>
    <input type="submit" name="envoi" value="Connexion"></h2></font></center>
</form>
</div>  

</body>
</html>
