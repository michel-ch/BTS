<?php
session_start();
?>

<html>
<head> <link href="style.css" media="all" rel="stylesheet" type="text/css"/>
<title>Page de modification de compte rendu</title>
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
else
  {
    ?>
    <html>
    <ul class="nav">
    <li><a href="accueil.php">Accueil</a></li>
    <li><a href="perso.php">Vos informations</a></li>
    <li><a href="cr.php">Compte rendus</a></li>
    <li><a href="ccr.php">Nouveau compte-rendu</a></li>
    </ul> </html> 
  

<?php
include '_conf.php';

$id=$_SESSION["id"];
$num=$_GET['variablenum'];

if($connexion = mysqli_connect($serveurBDD,$userBDD,$mdpBDD,$nomBDD))
{
    if (isset($_POST['description']))
    {
      $description = $_POST['description'];
      if (empty($description))
        {
          echo "<br><font color=red>Aucune description n'a été saisi<br></font>";
        }
        else
        {
          $requete ="UPDATE `cr` SET `description` = '$description' WHERE cr.num=$num";
          $resultat= mysqli_query($connexion,$requete);
          if (!mysqli_query($connexion,$requete)) 
          {
            echo "<br>Erreur : ".mysqli_error($connexion)."<br>";
          }
          else
            {
              echo " <br><center> <font color=limegreen> Nouvelle description insérée ! </font> </center><br>";
            }
        }

    }
    
}
    $requete="SELECT * FROM cr WHERE cr.num_utilisateur = $id AND cr.num=$num";
    $resultat = mysqli_query($connexion, $requete);
    while($donnees = mysqli_fetch_assoc($resultat))
      {
        $description=$donnees['description'];
        $date=$donnees['date'];
        echo "<br><FORM method='post' action='modif.php'>
        <label for='num'>Numéro du compte rendu : </label>";
        echo "$num<br><br>";
        echo "<label for='description'>Description du compte rendu : </label><br><br>";
        echo "<textarea name='description' rows=40 cols=80 placeholder='$description'></textarea><br><br>";
        echo "<input type='submit' name='modifer' value='Modifier'>";
        echo "</FORM>";

      }
}
?>
