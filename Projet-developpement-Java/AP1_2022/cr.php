<?php
session_start();
?>        
<html>
<head> <link href="style.css" media="all" rel="stylesheet" type="text/css"/> </head>
<title>Liste compte rendu</title>
<body>

<?php
include '_conf.php';
if (isset($_POST['update'])) //recupere données de ccr.php
      {
        $date=$_POST['date'];
        $note=$_POST['note'];
        if ($_POST['note']==0){
        $note=0;
        }
        $contenu= addslashes($_POST['contenu']);
        $id=$_SESSION["id"];
        $connexion = mysqli_connect($serveurBDD,$userBDD,$mdpBDD,$nomBDD);
        $requete="INSERT INTO cr (date,datetime,description,num_utilisateur,note) VALUES ('$date',NOW(),'$contenu','$id',$note);"; //crée nouveau compte rendu avec infos recuperees
        echo "<br>$requete<hr>";
        if(!mysqli_query($connexion,$requete)) // si requete php retourne faux
            {
            echo "erreur";
            }
        else //si possibilité de faire la requete :
            {
           echo "Nouveau compte-rendu créé<br>";
            }
        }

if ($_SESSION["type"] ==1) //si connexion en prof
  {
  
    echo"<ul class='nav'>
    <li><a href='accueil.php'>Accueil</a></li>
    <li><a href='perso.php'>Vos informations</a></li>
    <li><a href='cr.php'>Compte rendus</a></li>
    <li><a href='listeeleves.php'>Liste eleves</a></li>
    </ul>";

if($connexion = mysqli_connect($serveurBDD,$userBDD,$mdpBDD,$nomBDD))
      {
    $requete="SELECT cr.* FROM cr,utilisateur WHERE utilisateur.num = cr.num_utilisateur ORDER BY cr.date DESC"; //recupere tous les comptes rendus par date decroissante
        $resultat = mysqli_query($connexion, $requete);
        while($donnees = mysqli_fetch_assoc($resultat))
          {
            $num=$donnees['num'];
            $contenu=$donnees['description'];
            $date=$donnees['date'];
            $notedata=$donnees['note'];
            $numutilisateur=$donnees['num_utilisateur'];
            $_SESSION["date"]=$date;
            
            /// CONNEXION BASE DONNEE POUR EXTRACTION NOM PRENOM
            /*if ($connexion = mysqli_connect($serveurBDD,$userBDD,$mdpBDD,$nomBDD))
            {
            $requete="SELECT * FROM utilisateur";
            $resultat = mysqli_query($connexion, $requete);
            while($donnees = mysqli_fetch_assoc($resultat))
                {
                $nom=$donnees['nom'];
                $prenom=$donnees['prenom'];
                echo "<br>";
                echo "<div class='header'><div class='row'>
                <div style='background-color:#aaa;'>Compte rendu numéro = $num<br></div>
                <div style='background-color:#ddd;'>Date de la création = $date<br></div>
                <div style='background-color:#fff;'>Numéro rédacteur = $numutilisateur<br></div>
                <div style='background-color:#aaa;'>Nom rédacteur = $nom<br></div>
                <div style='background-color:#ddd;'>Prénom rédacteur = $prenom<br></div>
                <br>$contenu<br><br>";
                }
            }
            else {*/
            echo "<br>";
            echo "<div class='header'><div class='row'>
            <div style='background-color:#aaa;'>Compte rendu numéro = $num<br></div>
            <div style='background-color:#ddd;'>Date de la création = $date<br></div>
            <div style='background-color:#fff;'>Numéro rédacteur = $numutilisateur<br></div>
            <div style='background-color:#ccc;'>Note = $notedata<br></div>
            <br>$contenu<br><br>";
/// <div style='background-color:#aaa;'>Nom rédacteur = $nom<br></div> si ajout nom
// <div style='background-color:#ddd;'>Prénom rédacteur = $prenom<br></div> si ajout prenom
/// }
         }
    }
}
else //si connexion en eleve
  { 
    ?>
    
    <ul class="nav">
    <li><a href="accueil.php">Accueil</a></li> 
    <li><a href="perso.php">Vos informations</a></li>
    <li><a href="cr.php">Compte rendus</a></li>
    <li><a href="ccr.php">Nouveau compte-rendu</a></li>
    </ul>  <?php

       
        $id=$_SESSION["id"];
        $connexion = mysqli_connect($serveurBDD,$userBDD,$mdpBDD,$nomBDD);
        $requete="SELECT cr.* FROM cr,utilisateur WHERE utilisateur.num = cr.num_utilisateur AND utilisateur.num=$_SESSION[id] ORDER BY cr.date DESC"; //recupere tous les comptes rendus par date decroissante
        $resultat = mysqli_query($connexion, $requete);
        while($donnees = mysqli_fetch_assoc($resultat))
          {
            $num=$donnees['num'];
            $contenu=$donnees['description'];
            $date=$donnees['date'];
            $_SESSION["date"]=$date;
            $notedata=$donnees['note'];

            echo "<br>";
            echo "<div class='header'><div class='row'>
<div style='background-color:#aaa;'>Compte rendu numéro = $num<br></div>
<div style='background-color:#ddd;'>Date de la création = $date<br></div>
<div style='background-color:#ccc;'>Note = $notedata<br></div>
<br>$contenu<br><br>
</div> <a href='modif.php?variablenum=$num'>Modifier</a> </td> </tr> </tbody> </table> <br></div><br>";  //affiche tous les compte rendus du plus recent au plus ancien + lien pour modifier

          }
    }

 
?>
