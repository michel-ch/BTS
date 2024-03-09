<html>
<head>
<title>Bienvenue</title>
<meta charset="UTF-8">
<link href="index.css" media="all" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="login-root">
    <div class="box-root flex-flex flex-direction--column" style="min-height: 100vh;flex-grow: 1;">
      <div class="loginbackground box-background--white padding-top--64">
        <div class="loginbackground-gridContainer">
          <div class="box-root flex-flex" style="grid-area: top / start / 8 / end;">
            <div class="box-root" style="background-image: linear-gradient(white 0%, rgb(247, 250, 252) 33%); flex-grow: 1;">
            </div>
          </div>
          <div class="box-root flex-flex" style="grid-area: 4 / 2 / auto / 5;">
            <div class="box-root box-divider--light-all-2 animationLeftRight tans3s" style="flex-grow: 1;"></div>
          </div>
          <div class="box-root flex-flex" style="grid-area: 6 / start / auto / 2;">
            <div class="box-root box-background--blue800" style="flex-grow: 1;"></div>
          </div>
          <div class="box-root flex-flex" style="grid-area: 7 / start / auto / 4;">
            <div class="box-root box-background--blue animationLeftRight" style="flex-grow: 1;"></div>
          </div>
          <div class="box-root flex-flex" style="grid-area: 8 / 4 / auto / 6;">
            <div class="box-root box-background--gray100 animationLeftRight tans3s" style="flex-grow: 1;"></div>
          </div>
          <div class="box-root flex-flex" style="grid-area: 2 / 15 / auto / end;">
            <div class="box-root box-background--cyan200 animationRightLeft tans4s" style="flex-grow: 1;"></div>
          </div>
          <div class="box-root flex-flex" style="grid-area: 3 / 14 / auto / end;">
            <div class="box-root box-background--blue animationRightLeft" style="flex-grow: 1;"></div>
          </div>
          <div class="box-root flex-flex" style="grid-area: 4 / 17 / auto / 20;">
            <div class="box-root box-background--gray100 animationRightLeft tans4s" style="flex-grow: 1;"></div>
          </div>
          <div class="box-root flex-flex" style="grid-area: 5 / 14 / auto / 17;">
            <div class="box-root box-divider--light-all-2 animationRightLeft tans3s" style="flex-grow: 1;"></div>
          </div>
        </div>
      </div>
      <div class="box-root padding-top--24 flex-flex flex-direction--column" style="flex-grow: 1; z-index: 9;">
        <div class="box-root padding-top--48 padding-bottom--24 flex-flex flex-justifyContent--center">

          <?php 
          session_start();
          $prenom = $_SESSION['prenom'];
          echo "<h1><a href='http://blog.stackfindover.com/' rel='dofollow'>Bienvenue $prenom</a></h1>";
          ?>

        </div>
        <div class="formbg-outer">
          <div class="formbg">
            <div class="formbg-inner padding-horizontal--48">
              <span class="padding-bottom--15"></span>
<?php

$login = $_POST['login'];
$password = md5($_POST['password']);

if(empty($login) || empty($password))
{
	echo "Veuillez renseigner TOUS les champs";
}
else
{
include '_conf.php';
if ($connexion = mysqli_connect($serveurBDD, $userBDD, $mdpBDD, $nomBDD)) 
{
$requete = "SELECT * FROM ADHERENT WHERE login='$login' AND password='$password'";
$resultat= mysqli_query($connexion,$requete);
			
while ($donnees= mysqli_fetch_assoc($resultat))
{		
$champPrenom= $donnees["prenom"];
$champNom= $donnees["nom"];
$champLogin= $donnees["login"];
$champPassword= $donnees["password"];
$champEmail= $donnees["email"];
$champDate= $donnees["dateNaissance"];
$champSexe= $donnees["Sexe"];
$champBac= $donnees["Annee_BAC"];
$id = $donnees["id"];
}
if (empty($champPrenom))
{
echo "Erreur de connexion";
}
else
{
echo "<hr><br>Connexion Reussie <br><br> 
Bienvenue $champPrenom<br><br><hr><br>";

$_SESSION['id']=$id;
$_SESSION['prenom']=$champPrenom;
$_SESSION['nom']=$champNom;
$_SESSION['login']=$champLogin;
$_SESSION['password']=$champPassword;
$_SESSION['email']=$champEmail;
$_SESSION['date']=$champDate;
$_SESSION['sexe']=$champSexe;
$_SESSION['bac']=$champBac;

}	
}
}

?>
<br><br>
<form id="modifier" method="POST" action="modifier.php">
<input type="submit" value="Modifier vos données">
</form>
   </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>

