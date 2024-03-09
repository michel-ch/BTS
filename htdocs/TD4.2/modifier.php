<html>
<head>
<title>Modification de vos données</title>
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
        <div class="formbg-outer">
          <div class="formbg">
            <div class="formbg-inner padding-horizontal--48">
              <span class="padding-bottom--15">Modifiez vos données</span>
              <form id="stripe-login" method="POST" action="modifier2.php">
                <div class="field padding-bottom--24">
                  <label for="login">Login</label>
                  <?php
                  session_start();
                  $login = $_SESSION['login'];
                  echo "<input value='$login' type='login' name='login'>";
                  ?>
                </div>
                <div class="field padding-bottom--24">
                  <div class="grid--50-50">
                    <label for="password">Password</label>
                  </div>
                  <input type="password" name="password">
                </div>
                <div class="field padding-bottom--24">
                    <div class="grid--50-50">
                  <label for="repassword">Répéter le mot de passe</label>
                </div>
                  <input type="password" name="repassword">
                </div>
                <div class="field padding-bottom--24">
                  <label for="nom">Nom</label>
                  <?php
                  $nom = $_SESSION['nom'];
                  echo "<input value='$nom' type='nom' name='nom'>";
                  ?>
                </div>
                <div class="field padding-bottom--24">
                  <label for="prenom">Prénom</label>
                  <?php
                  $prenom = $_SESSION['prenom'];
                  echo "<input value='$prenom' type='prenom' name='prenom'>";
                  ?>
                </div>
                <div class="field padding-bottom--24">
                  <label for="email">Email</label>
                  <?php
                  $email = $_SESSION['email'];
                  echo "<input value='$email' type='email' name='email'>";
                  ?>
                </div>
            <div class="field padding-bottom--24">
                  <label for="date">Date de naissance</label>
                  <?php
                  $date = $_SESSION['date'];
                  echo "<input value='$date' type='date' name='date'>";
                  ?>
                </div>
            <div class="field padding-bottom--24">
                  <label for="sexe">Sexe</label>
                  <?php
                  $sexe = $_SESSION['sexe'];
                  if ($sexe==1)
                    {
                  echo "Homme <input type='radio' name='sexe' value='1' checked='checked' > Femme <input type='radio' name='sexe'value='2' >";
                    }
                  else 
                    {
                  echo "Homme <input type='radio' name='sexe' value='1' > Femme <input type='radio' name='sexe'value='2' checked='checked'>";
                    }
                  ?>
                </div>
            <div class="field padding-bottom--24">
                  <label for="bac">Année du bac</label>
                  <select name='bac'>

<?php

$datebac=$_SESSION['bac'];
$anneeN=date("Y");
for ($i=$datebac; $i<=$anneeN-4;$i++){
    if ($i==$date)
    {
    echo "<option selected value=$i>$i</option>";
    }
    else
    {
     echo "<option value=$i>$i</option>";
    }
}
?>    
</select><br>
                </div>
                <div class="field field-checkbox padding-bottom--24 flex-flex align-center">
           
                    
                </div>
                <div class="field padding-bottom--24">
                  <input type="submit" name="modifer" value="Modifier">
                </div>
              </form>
            </div>
          </div>
          <div class="footer-link padding-top--24">
            <div class="listing padding-top--24 padding-bottom--24 flex-flex center-center">
              <span><a href="#">© Stackfindover</a></span>
              <span><a href="#">Contact</a></span>
              <span><a href="#">Privacy & terms</a></span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

</body>
</html>
<?php



?>
