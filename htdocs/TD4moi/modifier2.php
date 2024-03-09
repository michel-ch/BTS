<?php

session_start();

if (isset($_SESSION['id'])){


include '_conf.php';
$connexion = mysqli_connect($serveurBDD, $userBDD, $mdpBDD, $nomBDD);

$id = $_SESSION['id'];

$login = $_POST['login'];
$password = $_POST['password'];
$repassword = $_POST['repassword'];
$nom = $_POST['nom'];
$prenom = $_POST['prenom'];
$email = $_POST['email'];
$date = $_POST['date'];
$sexe = $_POST['sexe'];
$bac = $_POST['bac'];

echo "Votre identifiant : $id<br><br>";

if (empty($login))
{
echo "Aucun login n'a été saisi<br><br>";
}
else 
{
$update ="UPDATE `UTILISATEUR` SET `login` = '$login' WHERE `UTILISATEUR`.`id`='$id'";
$resultat= mysqli_query($connexion,$update);
# echo "$update<br><br>";
echo "Voici votre nouveau login : $login<br><br>";
}
if ($password!=$repassword)
{
echo "Les mots de passes saisis ne sont pas identiques. Veuillez resaisir des mots de passes identiques.";
}

else 
{

}
if (empty($password))
{
echo "Aucun mot de passe n'a été saisi<br><br>";

}
else
{
$update ="UPDATE `UTILISATEUR` SET `password` = '$password' WHERE `UTILISATEUR`.`id`='$id'";
$resultat= mysqli_query($connexion,$update);
echo "Voici votre nouveau mot de passe : $password<br><br>";
}

if ($password!=$repassword)
{
echo "Les mots de passes saisis ne sont pas identiques. Veuillez resaisir des mots de passes identiques.";
}

if (empty($nom))
{
echo "Aucun nom n'a été saisi<br><br>";

}
else
{
$update ="UPDATE `UTILISATEUR` SET `nom` = '$nom' WHERE `UTILISATEUR`.`id`='$id'";
$resultat= mysqli_query($connexion,$update);
echo "Voici votre nouveau nom : $nom<br><br>";
}

if (empty($prenom))
{
echo "Aucun prenom n'a été saisi<br><br>";

}
else
{
$update ="UPDATE `UTILISATEUR` SET `prenom` = '$prenom' WHERE `UTILISATEUR`.`id`='$id'";
$resultat= mysqli_query($connexion,$update);
echo "Voici votre nouveau prenom : $prenom<br><br>";
}

if (empty($email))
{
echo "Aucun email n'a été saisi<br><br>";
}
else
{
$update ="UPDATE `UTILISATEUR` SET `email` = '$email' WHERE `UTILISATEUR`.`id`='$id'";
$resultat= mysqli_query($connexion,$update);
echo "Voici votre nouveau email : $email<br><br>";
}

if (empty($date))
{
echo "Aucune date n'a été saisie<br><br>";
}
else
{
$update ="UPDATE `ADHERENT` SET `dateNaissance` = '$date' WHERE `ADHERENT`.`id`='$id'";
$resultat= mysqli_query($connexion,$update);
echo "Voici votre nouvelle date de naissance : $date<br><br>";
}

if (empty($sexe))
{
echo "Aucun sexe n'a été saisi<br><br>";
}
else
{
$update ="UPDATE `UTILISATEUR` SET `Sexe` = '$sexe' WHERE `UTILISATEUR`.`id`='$id'";
$resultat= mysqli_query($connexion,$update);
echo "Voici votre nouveau sexe : $sexe<br><br>";
}

if (empty($bac))
{
echo "Aucun bac n'a été saisi<br><br>";
}
else
{
$update ="UPDATE `UTILISATEUR` SET `Annee_BAC` = '$bac' WHERE `UTILISATEUR`.`id`='$id'";
$resultat= mysqli_query($connexion,$update);
echo "Voici votre nouvelle année de bac : $bac<br><br>";
}

}

?>
