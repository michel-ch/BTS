<?php

include '_conf.php';
if ($connexion = mysqli_connect($serveurBDD, $userBDD, $mdpBDD, $nomBDD)) 
{
$requete = "SELECT * FROM CR GROUP BY DATE";
$resultat= mysqli_query($connexion,$requete);
			
while ($donnees= mysqli_fetch_assoc($resultat))
{		
$num = $donnees["num"];
$date= $donnees["date"];
$description= $donnees["description"];
$vu= $donnees["vu"];
$datetime= $donnees["datetime"];
$num_utilisateur= $donnees["num_utilisateur"];
}




?>

