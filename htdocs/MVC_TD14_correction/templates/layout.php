<?php
session_start();
?>


<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8" />
      <title><?= $title ?></title>
      <link href="style.css" rel="stylesheet" /> 
   </head>

   <body>
      <?= $content ?>
      <?php
      if($_SESSION['login']!=null){
         $login=$_SESSION['login'];
         $email=$_SESSION['email'];
         $nom=$_SESSION['nom'];
         $prenom=$_SESSION['prenom'];
         echo "<center>Vous etes connecté en tant que $login<br><br>
         <form method='POST'> 
         <input <input type='submit' value='Déconnexion' name='submit'><br><br></center>
         </form>";
         if(isset($_POST['submit'])){
            deconnexion();
         }
      }
      else{
      ?>
            <form method="POST"> 
            <center>Login : <input type="text" id="login" name="login"> <br><br>
            Mot de passe : <input type="password" id="mdp" name="mdp"><br><br>
            <input type="submit" name="send" value="Connexion"><br><br></center>
            </form>
         <?php
       
       
         if (!empty($_POST['login']) && !empty($_POST['mdp'])) 
         {
            $login = $_POST['login'];
            $mdp = $_POST['mdp'];
            $info=connexion($login,$mdp);
            
               if ($info!=0)
               {
               $_SESSION['login']=$info['login'];
               $_SESSION['email']=$info['email'];
               $_SESSION['nom']=$info['nom'];
               $_SESSION['prenom']=$info['prenom'];
               $login=$_SESSION['login'];
               $email=$_SESSION['email'];
               $nom=$_SESSION['nom'];
               $prenom=$_SESSION['prenom'];
               echo "<center>Vous etes connecté en tant que $login<br><br></center>";
               header("Refresh:0");
               //echo "CA MARCHE";
              }
              else
              {
               echo "Connexion échouée";
              }
            }
            else 
            {
                die('<center>Veuillez remplir les champs</center>');
            }
        
       
      }
      ?>
   </body>
</html>