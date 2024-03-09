<html>
<body>
   

<?php

session_start(); 

if (isset($_POST['envoi'])) //reçois données rentrée lors de la connexion
{
   
    $login = $_POST['login'];
    $mdp =  $_POST['mdp'];

    $pdo = new pdo('mysql:host=localhost;dbname=BLOC 3 TD8 BDD','root','');

    $stmt = $pdo-> prepare ("Select * from acheteur WHERE email = ? AND motdepasse= ?"); 
    $stmt-> execute([$login,$mdp]);
    $row = $stmt -> fetch();
    echo $row ['nom']."<br/>\n";
    echo $id= $row['id']."<br/>\n";

    $note = $pdo-> prepare("SELECT voir.idSPECTACLE AS spectacle,voir.note FROM voir, acheteur, spectacle WHERE acheteur.id=voir.idAcheteur AND spectacle.id=voir.idSPECTACLE AND acheteur.id = :id ORDER BY spectacle.dateCreation DESC LIMIT 3");
    $note-> execute(['id' => $id]);
    while ($donnees = $note -> fetch()) {
        echo $donnees ['spectacle']." ";
        echo $donnees ['note']."<br/>\n";
    }

}






?>

