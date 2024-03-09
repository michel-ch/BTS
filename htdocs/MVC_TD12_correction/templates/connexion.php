       <form method="post">
        <div>
  	        <label for="author">Identifiant</label><br />
  	        <input type="text" id="login" name="login" />
        </div>
        <div>
  	        <label for="comment">Mot de passe</label><br />
  	        <input type ="password" id="pwd" name="pwd"></input>
        </div>
        <div><br>
  	        <input type="submit" value="Connexion" />
        </div>
      </form>

<?php
require_once('src/model.php');

if (!empty($_POST['login'])|| !empty($_POST['pwd'])) {
    $login = $_POST['login'];
    $pwd = $_POST['pwd'];
        if (connexion($login,$pwd)==true) {
            connexion($login,$pwd);
            $name=$donneeconnexion[0];
            echo $name;

        }
        else {
            echo "Identifiant ou mot de passe incorrect";
        }
    }
else {
    echo "<br>Veuillez remplir les champs";
}
?>

