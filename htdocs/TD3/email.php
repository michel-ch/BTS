<?php
$email = $_POST['email'];
$objet = $_POST['objet'];
$message = $_POST['message'];
echo 'Votre message a bien été envoyé<br>';
echo "Adresse mail = $email<br>";
echo "objet de l'email = $objet<br>";
echo "Contenu du texte envoyé = $message";
mail('yepmtx@gmail.com',$objet,$message);

?>
