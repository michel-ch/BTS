<?php
session_start(); 
?>
<html>
<head> <link href="style.css" media="all" rel="stylesheet" type="text/css"/> </head>
<body>
   

<?php

include '_conf.php';

if (isset($_POST['envoi'])) //reçois données rentrée lors de la connexion
{
   
    $login = $_POST['login'];
    $mdp =  md5($_POST['mdp']);

    $connexion = mysqli_connect($serveurBDD,$userBDD,$mdpBDD,$nomBDD);
    $requete="Select * from utilisateur WHERE login = '$login' AND motdepasse= '$mdp'"; //recupere données utilisateur 
    //echo "<br> ma req SQL : $requete <br>";
    $resultat = mysqli_query($connexion, $requete);
    $trouve=0;
    while($donnees = mysqli_fetch_assoc($resultat)) // Impression resultat requete
      {
   
        $trouve=1;
        $type=$donnees['type'];
        $login=$donnees['login'];
        $id=$donnees['num'];
     // echo "je créé mes sessions !!!";
        $_SESSION["id"]=$id; //relie variable avec session
        $_SESSION["login"]=$login;
        $_SESSION["type"]=$type;
    
      }

    if($trouve==0)
    {
        echo "<br><br><center><h2>Votre identifiant ou votre mot de passe incorrect<br><br>
        <a href='index.php'>Retour à l'accueil</a></h2></center>";
    }
}
if (isset($_SESSION["login"]))
 
    {
        if($_SESSION["type"]==0)/// SI ELEVE
        {
          ?>
         <ul class="nav">
        <li><a href="accueil.php">Accueil</a></li>
        <li><a href="perso.php">Vos informations</a></li>
        <li><a href="cr.php">Compte rendus</a></li>
        <li><a href="ccr.php">Nouveau compte-rendu</a></li>
        </ul>
 
            <?php
            echo "<head><title>Accueil</title></head><body><br>Bienvenue sur le compte élève <br> <br>";
            echo "Vous êtes connecté en tant que ".$_SESSION["login"]."<br> <br>";
           echo "<FORM method='post' action='index.php'> <button type=submit name='deco'> DECONNEXION </button> </form>";
        }
        else /// SI PROF
        {
?>
              <ul class="nav">
        <li><a href="accueil.php">Accueil</a></li>
        <li><a href="perso.php">Vos informations</a></li>
        <li><a href="cr.php">Compte rendus</a></li>
        <li><a href="listeeleves.php">Liste eleves</a></li>
        </ul> </html>
<?php
            echo "<br>";
            echo "vous êtes un prof<br>";
            echo "<br>";
            echo "Vous êtes connecté en tant que ".$_SESSION["login"]."<br> <br>";
            echo "<table border=1><tr>
                  <th> Numero élève </th>
                  <th> Nom élève </th>
                  <th> Prenom élève </th>
                  <th> Téléphone élève </th>
                  <th> Prenom </th>
                  <th> Email </th>
                  <th> Option </th>
                  <th> Note </th></tr>";
            if($connexion = mysqli_connect($serveurBDD,$userBDD,$mdpBDD,$nomBDD))
            {
                $requete="SELECT cr.num AS `numCR`, `date`, utilisateur.num AS `numutilisateur`, nom, prenom, email, utilisateur.option,cr.note FROM cr,utilisateur WHERE utilisateur.num = cr.num_utilisateur ORDER BY `date` DESC , cr.num ASC LIMIT 5;"; //recupere tous les comptes rendus par date decroissante
                $resultat = mysqli_query($connexion, $requete);
                while($donnees = mysqli_fetch_assoc($resultat))
                {
                    $num=$donnees['numCR'];
                    $date=$donnees['date'];
                    $numutilisateur=$donnees['numutilisateur'];
                    $note=$donnees['note'];
                    echo "<tr><td><FORM method='post' action='cr.php' ><button type=submit name='compte' >$num </button></FORM></td>
                    <td> $date </td>
                    <td>$numutilisateur</td>";
                    
                 
                        $nom=$donnees['nom'];
                        $prenom=$donnees['prenom'];
                        $email=$donnees['email'];
                        if ($donnees['option']==1)
                        {
                        $option="slam";
                        }
                        else 
                        {
                        $option="sisr";
                        }
                    
                    echo "<th> $nom </th>
                    <th>$prenom</th>
                    <th>$email</th>
                    <th>$option</th>
                    <th>$note</th></tr>";
                    
                    /*echo "<th> $nom </th>
                    <th>$prenom</th>
                    <th>$email</th>
                    <th>$option</th></tr>";*/
                }
            }
            echo "</table><br>";
            echo "<FORM method='post' action='index.php'> <button type=submit name='deco'> DECONNEXION </button> </FORM>";
        }
    }






?>

