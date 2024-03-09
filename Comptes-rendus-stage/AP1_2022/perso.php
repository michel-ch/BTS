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
    </ul> </html> <?php
  }
  if ($_SESSION["type"] ==0)
  {
    ?>
    <html>
    <ul class="nav">
    <li><a href="accueil.php">Accueil</a></li>
    <li><a href="perso.php">Vos informations</a></li>
    <li><a href="cr.php">Compte rendus</a></li>
    <li><a href="ccr.php">Nouveau compte-rendu</a></li>
    </ul> </html> <?php
  }

if($connexion = mysqli_connect($serveurBDD,$userBDD,$mdpBDD,$nomBDD))
{
    $id=$_SESSION["id"];     
    $requete="SELECT * FROM utilisateur WHERE utilisateur.num=$_SESSION[id]";
    $requete2="SELECT DATE( NOW() ) AS now;";
    $resultat = mysqli_query($connexion, $requete);
    $resultat2 = mysqli_query($connexion, $requete2);
    while($donnees = mysqli_fetch_assoc($resultat))
      {
        $nom=$donnees['nom'];
        $prenom=$donnees['prenom'];
        $email=$donnees['email'];
        $tel=$donnees['tel'];
        $naissance=$donnees['naissance'];
        if ($donnees['option']==1) {
          $option="slam";
          }
        else {
          $option="sisr";
          }
        while($donnees = mysqli_fetch_assoc($resultat2)){
          $now=$donnees['now'];
          $age=((int)$now-(int)$naissance);
        }
    
      }
    echo "<font size=6 align='center'> Vos informations :<br>
    <div style='background-color:#aaa;'>Nomm = $nom<br></div>
    <div style='background-color:#ccc;'>Prenom = $prenom<br></div>
    <div style='background-color:#aaa;'>Email = $email<br></div>
    <div style='background-color:#ccc;'>Numéro de téléphone = 0$tel<br></div>
    <div style='background-color:#ccc;'>Age = $age<br></div>";
    if ($_SESSION["type"] ==0){
      $requete="SELECT tuteur.* FROM `utilisateur`,tuteur,stage WHERE tuteur.num=stage.num_tuteur AND utilisateur.num_stage=stage.num AND utilisateur.num=$_SESSION[id]";
      $resultat = mysqli_query($connexion, $requete);
      while($donnees = mysqli_fetch_assoc($resultat)){
        $num_tuteur=$donnees['num'];
        $nom_tuteur=$donnees['nom'];
        $prenom_tuteur=$donnees['prenom'];
        $tel_tuteur=$donnees['tel'];
        $email_tuteur=$donnees['email'];
      }
      $_SESSION["id"]=$id;
      echo"<a href='modif_info.php?variablenum=$id'>Modifier</a>";

      echo "<br>Informations de votre tuteur :  <br>
      <div style='background-color:#ccc;'>Nomm = $num_tuteur<br></div>
      <div style='background-color:#aaa;'>Nomm = $nom_tuteur<br></div>
      <div style='background-color:#ccc;'>Prenom = $prenom_tuteur<br></div>
      <div style='background-color:#aaa;'>Email = $email_tuteur<br></div>
      <div style='background-color:#ccc;'>Numéro de téléphone = 0$tel_tuteur<br></div>";
    }
    echo"</font>";

}
?>
