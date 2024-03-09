<html>
<head>
<title>inscription</title>
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
          <h1><a href="http://blog.stackfindover.com/" rel="dofollow">Stackfindover</a></h1>
        </div>
        <div class="formbg-outer">
          <div class="formbg">
            <div class="formbg-inner padding-horizontal--48">
              <span class="padding-bottom--15">Inscrivez vous</span>
              <form id="stripe-login" method="POST" action="inscription2.php">
                <div class="field padding-bottom--24">
                  <label for="login">Login</label>
                  <input type="login" name="login">
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
                  <input type="nom" name="nom">
                </div>
                <div class="field padding-bottom--24">
                  <label for="prenom">Prénom</label>
                  <input type="prenom" name="prenom">
                </div>
                <div class="field padding-bottom--24">
                  <label for="email">Email</label>
                  <input type="email" name="email">
                </div>
            <div class="field padding-bottom--24">
                  <label for="date">Date de naissance</label>
                  <input type="date" name="date">
                </div>
            <div class="field padding-bottom--24">
                  <label for="sex">Sexe</label>
                  Homme <input type="radio" name="sexe" value="1"> Femme <input type="radio" name="sexe" value="2" >
                </div>
            <div class="field padding-bottom--24">
                  <label for="bac">Année du bac</label>

<select name="bac">
<?php

session_start();

$anneeN=date("Y");
for ($i=1970; $i<=$anneeN-4;$i++){
echo "<option value=$i>$i</option>";
}
?>    
</select><br>
                </div>
                <div class="field field-checkbox padding-bottom--24 flex-flex align-center">
           
                    
                </div>
                <div class="field padding-bottom--24">
                  <input type="submit" name="inscrire" value="S'inscrire">
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
