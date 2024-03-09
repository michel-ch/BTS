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
if ($_SESSION["type"] !=0) //si connexion en prof
  {
    echo "Nous n'êtes pas autorisé à modifier vos informations.";
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

    if($connexion = mysqli_connect($serveurBDD,$userBDD,$mdpBDD,$nomBDD))
    {
      $id=$_SESSION["id"];
      // $num=$_GET['variablenum'];

      $requete="SELECT * FROM utilisateur WHERE utilisateur.num=$id";
      $resultat = mysqli_query($connexion, $requete);
      while($donnees = mysqli_fetch_assoc($resultat))
        {
          $nom=$donnees['nom'];
          $prenom=$donnees['prenom'];
          $tel=$donnees['tel'];
          $login=$donnees['login'];
          $motdepasse=$donnees['motdepasse'];
          $type=$donnees['type'];
          $email=$donnees['email'];
          $option=$donnees['option'];
          $num_stage=$donnees['num_stage'];
          $naissance=$donnees['naissance'];

          echo "<br><FORM method='POST' action='modif_info.php'>
          Nom : <input type='text' name='nomentree' placeholder='$nom'><br><br>
          Prenom : <input type='text' name='prenomentree' placeholder='$prenom'><br><br>
          Téléphone : <input type='text' name='telentree' placeholder='$tel'><br><br>
          Login : <input type='text' name='loginentree' placeholder='$login'><br><br>
          Motdepasse : <input name='motdepasseentree' type='password'><br><br>
          Confirmation Motdepasse : <input name='remotdepasseentree' type='password'><br><br>
          Email : <input type='text' name='emailentree' placeholder='$email'><br><br>
          Date de naissance : <input type='text' nam='naissanceentree' placeholder='$naissance'><br><br>
          <input type='submit' name='modifer' value='Modifier'>
          </FORM>";

        }

        error_reporting(0); // not show errors

        $nomentree = $_POST['nomentree'];
        $prenomentree = $_POST['prenomentree'];
        $telentree = $_POST['telentree'];
        $loginentree = $_POST['loginentree'];
        $motdepasseentree = $_POST['motdepasseentree'];
        $remotdepasseentree = $_POST['remotdepasseentree'];
        $emailentree = $_POST['emailentree'];
        $naissanceentree = $_POST['naissanceentree'];

        if (isset($_POST['nomentree']))
        {

          $verifmotdepasse=false;

          if($motdepasseentree==$remotdepasseentree){
            $verifmotdepasse=true;
          }
          if($motdepasseentree!=$remotdepasseentree){
            echo "Vos mot de passes ne sont pas identiques.<br><br>
            Veuillez insérer des mots de passes identiques.";
          }
          if(empty($nomentree)){
            $nomentree=$nom;
          }
          if(empty($prenomentree)){
            $prenomentree=$prenom;
          }
          if(empty($telentree)){
            $telentree=$tel;
          }
          if(empty($loginentree)){
            $loginentree=$login;
          }
          if(empty($motdepasseentree)){
            $motdepasseentree=$motdepasse;
          }
          if(empty($emailentree)){
            $emailentree=$email;
          }
          if(empty($naissanceentree)){
            $naissanceentree=$naissance;
          }
          
          if($verifmotdepasse==true){
            $md5motdepasse=md5($motdepasseentree);
          }
          if($verifmotdepasse==false){
            $md5motdepasse=$motdepasse;
          }

          $requete1 ="
          UPDATE `utilisateur` SET 
          `nom` = '$nomentree',
          `prenom` = '$prenomentree',
          `tel` = $telentree,
          `login` = '$loginentree',
          `motdepasse` = '$md5motdepasse',
          `type` = $type,
          `email` = '$emailentree',
          `option` = $option,
          `num_stage` = $num_stage,
          `naissance` = '$naissanceentree'
          WHERE utilisateur.num=$id;";
          echo "$requete1";

          if(md5($motdepasseentree)==$motdepasse){
            echo "<br><br>Veuillez insérer un mot de passe différent du précédent.";
          }
          else {
            $resultat= mysqli_query($connexion,$requete1);

            if (!mysqli_query($connexion,$requete1)) 
          {
            echo "<br>Erreur : ".mysqli_error($connexion)."<br>";
          }
          else
          {
            if(empty($nomentree)&&empty($prenomentree)&&empty($telentree)&&empty($loginentree)&&empty($motdepasseentree)&&empty($remotdepasseentree)&&empty($emailentree)&&empty($naissanceentree)){
              echo " <br><center> <font color=limegreen> Aucune donnée modifiée</font> </center><br>";
            }
            else{
              echo " <br><center> <font color=limegreen> Modification faite ! </font> </center><br>";
            }
            
          }
          }

        }
        
    }


}

?>
