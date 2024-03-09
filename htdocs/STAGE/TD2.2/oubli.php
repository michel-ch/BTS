<html>
<head>
<title>oubli mot de passe</title>
</head>
<body>


<?php 
if (isset($_POST['email']))
{
     $lemail=$_POST['email'];
     echo "le formulaire a été envoyé avec comme email la valeur :$lemail";

    //Q5 insérer une ligne dans la BDD avec votre email

    //6 connexion BDD


include '_conf.php';
$connexion = mysqli_connect($serveurBDD, $userBDD, $mdpBDD, $nomBDD);

    //7. faire requête SQL
//A faire après la sélection BDD
$requete="Select * from UTILISATEUR WHERE email='$lemail'";
//echo "<hr>$requete<hr>";
$resultat = mysqli_query($connexion, $requete);
$login=0;
	while($donnees = mysqli_fetch_assoc($resultat))
	{
		$login =$donnees['login']; //mettre le nom du champ dans la table
		$mdp =$donnees['motdepasse'];	
	}


    //8 



}
else
{

}
?>
<FORM method="POST" action=oubli.php>Login : <input name="email"><br>
<input type="submit" value="Envoyer"><br><br>
</FORM>
<?php

?>

</body>
</html>
