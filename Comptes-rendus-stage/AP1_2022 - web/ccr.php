<?php
session_start();
?>
<html>
<head> <link href="style.css" media="all" rel="stylesheet" type="text/css"/> 
<title> Creation Compte rendu</title>
</head>

<ul class="nav">
  <li><a href="accueil.php">Accueil</a></li>
  <li><a href="perso.php">Vos informations</a></li>
  <li><a href="cr.php">Compte rendus</a></li>
  <li><a href="ccr.php">Nouveau compte-rendu</a></li>
</ul>

<FORM method="post" action="cr.php"><br>
<div style='background-color:#aaa;' ><font size=5 align="center"> <center>Création un compte rendu </div>
<div class='header'><div class='row'>
<div style='background-color:#ccc;' >Date <input type="date" name="date" required ></div>
<br>
<div style='background-color:#ccc;' >Note <select name="note" required>
    <option selected="selected" value=0>Aucune note selectionnée</option>
    <option>1</option>
    <option>2</option>
    <option>3</option>
    <option>4</option>
    <option>5</option>
</select>
</div>
<div><br>
<center>
<textarea name="contenu" rows=40 cols=80 placeholder="Contenu du compte rendu"></textarea><br>
<br><input type="submit" name="update" value="Confirmer" style="height:65px; width:100px"> </center></button></font> </div>

</html>

