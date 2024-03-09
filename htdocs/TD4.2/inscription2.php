<?php

$login = $_POST['login'];
$password = $_POST['password'];
$repassword = $_POST['repassword'];
$nom = $_POST['nom'];
$prenom = $_POST['prenom'];
$email = $_POST['email'];
$date = $_POST['date'];
$sexe = $_POST['sexe'];
$bac = $_POST['bac'];


if (empty($login) || empty($password) || empty($repassword) || empty($nom) || empty($prenom) || empty($email) || empty($date) || empty($sexe) || empty($bac)) {
echo " Veuillez remplir tous les champs";
}
else
{
if ($password!=$repassword)
{
echo "Les mots de passes saisis ne sont pas identiques. Veuillez resaisir des mots de passes identiques.";
}
else
{
echo "$login;$password;$repassword;$nom;$prenom;$email;$date;$sexe;$bac<br>";
}

}


include '_conf.php';

if ($connexion = mysqli_connect($serveurBDD, $userBDD, $mdpBDD, $nomBDD)) 
{
echo "Félicitation, vous êtes connecté à la BDD";
}
else 
{
echo "Erreur";
}

$requete="INSERT INTO `ADHERENT` (`id`, `nom`, `prenom`, `email`, `login`, `password`, `dateNaissance`, `Sexe`, `Annee_BAC`) VALUES (NULL, '$nom', '$prenom', '$email', '$login', '$password', '$date', '$sexe', '$bac');";

mysqli_query($connexion,$requete);





?>
