<?php
session_start();

if (isset($_SESSION['login'])){

$login=$_SESSION['login'];
$num=$_SESSION['num'];
$nom=$_SESSION['nom'];
$type=$_SESSION['type'];
$email=$_SESSION['email'];
$mdp=$_SESSION['motdepasse'];

echo "Votre login : $login <br>";
echo "Votre numéro de compte : $num <br>";
echo "Votre nom : $nom <br>";
echo "$type <br>";
echo "$email <br>";
echo "$mdp <br>";

}

else {
echo "La connexion est perdue, veuillez revenir à la <a href='index.html'>page d'index</a> pour vous reconnecter."; 
}


?>
