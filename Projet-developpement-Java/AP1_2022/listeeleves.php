<?php
session_start();
?>

<html>
<head> <link href="style.css" media="all" rel="stylesheet" type="text/css"/>
<title>Vos informations</title>
</head>
<body> </html>
<?php
include '_conf.php';
if ($_SESSION["type"] ==1) //si connexion en prof
  {

    ?>
    <html>
    <ul class="nav">
    <li><a href="accueil.php">Accueil</a></li>
    <li><a href="perso.php">Vos informations</a></li>
    <li><a href="cr.php">Compte rendus</a></li>
    <li><a href="listeeleves.php">Liste eleves</a></li>
    </ul> 
    <table border=1><tr>
    <table border=1><tr>
                  <th> Numero élève </th>
                  <th> Nom élève </th>
                  <th> Prenom élève </th>
                  <th> Téléphone élève </th>
                  <th> Login élève </th>
                  <th> Email élève </th>
                  <th> Option </th>
                  <th> Numéro stage élève </th>
                  <th> Numéro tuteur</th>
                  <th> Nom tuteur </th>
                  <th> Prenom tuteur </th>
                  <th> Téléphone tuteur </th>
                  <th> Email tuteur </th>
                  <th> Suppression </th>
                  </tr> </html> <?php

    if($connexion = mysqli_connect($serveurBDD,$userBDD,$mdpBDD,$nomBDD))
    {
      error_reporting(0); // not show errors
      
    $requete="SELECT utilisateur.*,tuteur.num  AS numerotuteur,tuteur.nom AS tuteurnom,tuteur.prenom AS tuteurprenom,tuteur.tel AS tuteurtel,tuteur.email AS tuteuremail FROM tuteur,utilisateur,stage WHERE utilisateur.type=0 AND utilisateur.num_stage=stage.num AND tuteur.num=stage.num_tuteur GROUP BY utilisateur.num ORDER BY utilisateur.num ASC"; //recupere tous les comptes rendus par date decroissante
    $resultat = mysqli_query($connexion, $requete);
    while($donnees = mysqli_fetch_assoc($resultat))
    {
        $num_eleve=$donnees['num'];
        $nom_eleve=$donnees['nom'];
        $prenom_eleve=$donnees['prenom'];
        $tel_eleve=$donnees['tel'];
        $login_eleve=$donnees['login'];
        $email_eleve=$donnees['email'];
        $stage_eleve=$donnees['num_stage'];
        $numero_tuteur=$donnees['numerotuteur'];
        $nom_tuteur=$donnees['tuteurnom'];
        $prenom_tuteur=$donnees['tuteurprenom'];
        $tel_tuteur=$donnees['tuteurtel'];
        $email_tuteur=$donnees['tuteuremail'];
            if ($donnees['option']==1)
            {
            $option="slam";
            }
            else 
            {
            $option="sisr";
            }
        
            echo "<tr><td><center>$num_eleve</center></td>
            <td><center>$nom_eleve</center></td>
            <td><center>$prenom_eleve</center></td>
            <td><center>0$tel_eleve</center></td>
            <td><center>$login_eleve</center></td>
            <td><center>$email_eleve</center></td>
            <td><center>$option</center></td>
            <td><center>$stage_eleve</center></td>
            <td><center>$numero_tuteur</center></td>
            <td><center>$nom_tuteur</center></td>
            <td><center>$prenom_tuteur</center></td>
            <td><center>0$tel_tuteur</center></td>
            <td><center>$email_tuteur</center></td>
            <td><form method='POST' action='listeeleves.php'><center>
            <input type='hidden' name='ideleve' value=$num_eleve>
            <button type=submit name='suppression'> Suppression </button>
            </center></form></td>
            </tr>";
    }
}
echo "</table><br>";
  }
else
  {
    
    echo "Vous ne disposez pas des permissions pour accéder à cette page.";
  }

 /// CREATION DE FONCTION PHP POUR SUPPRESION ELEVE
 if(isset($_POST['ideleve'])) {
  $eleve=$_POST['ideleve'];

  $requete="SELECT num_tuteur,utilisateur.num_stage FROM stage, utilisateur,tuteur WHERE utilisateur.num = $eleve AND utilisateur.num_stage=stage.num AND stage.num_tuteur=tuteur.num"; //recupere tous les comptes rendus
  //echo "$requete\n";
  $resultat = mysqli_query($connexion, $requete);
  $donnees = mysqli_fetch_assoc($resultat);
  $numero_tuteur=$donnees['num_tuteur'];
  $stage_eleve=$donnees['num_stage'];

  echo "tuteur : $numero_tuteur et stage : $stage_eleve\r";

  $requete_suppression = "DELETE FROM cr WHERE `cr`.`num_utilisateur`= $eleve";
  //echo "$requete_suppression\n";
  $resultat= mysqli_query($connexion,$requete_suppression);

  $requete_suppression = "DELETE FROM utilisateur WHERE `utilisateur`.`num`= $eleve";
  //echo "$requete_suppression\n";
  $resultat= mysqli_query($connexion,$requete_suppression);

  $requete_suppression = "DELETE FROM stage WHERE `stage`.`num`= $stage_eleve";
  //echo "$requete_suppression\n";
  $resultat= mysqli_query($connexion,$requete_suppression);

  $requete_suppression = "DELETE FROM tuteur WHERE `tuteur`.`num`= $numero_tuteur";
  //echo "$requete_suppression\n";
  $resultat= mysqli_query($connexion,$requete_suppression);

  if (!mysqli_query($connexion,$requete_suppression)){
    echo "<br>Erreur : ".mysqli_error($connexion)."<br>";
  }
  else{
    echo "La suppresion de l'élève a été bien faite.";
  }
}
?>
