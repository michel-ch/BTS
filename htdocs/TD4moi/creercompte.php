<html>

<head>
<title>Création de compte</title>
</head>

<body>

<p><h4>Création de compte rendu</h4></p>

<form id="creationcompte" method="POST" action="creercompte.php">
<?php
echo "Date : ".date("d/m/Y");
$date =date("d/m/Y");
// echo "$date";
?>
<br>Texte : <textarea name="description" rows=20 cols=40></textarea><br>
<br><br>
<input type="submit" value="Créer le compte rendu">
</form>
</body>

</html>

<?php

$description =$_POST['description'];

include '_conf.php';
$connexion = mysqli_connect($serveurBDD, $userBDD, $mdpBDD, $nomBDD);
$create ="INSERT INTO `CR` (`num`, `date`, `description`, `vu`, `datetime`, `num_utilisateur`) VALUES (NULL, $date, $description, NULL, NULL, NULL);";
$resultat= mysqli_query($connexion,$create);





?>
