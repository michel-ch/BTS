<html>

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1"charset="utf-8">
	<title>Contact</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>

<body>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark justify-content-center">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarCollapse2">
                <div class="navbar-nav">
                    <a href="index.html" class="nav-item nav-link active">Accueil</a>
                    <a href="projet.php" class="nav-item nav-link">Projet</a>
                    <a href="about.html" class="nav-item nav-link">A propos de</a>
                    <a href="contact.html" class="nav-item nav-link">Contact</a>
                </div>
                <form class="d-flex ms-auto">
                    <input type="text" class="form-control me-sm-2" placeholder="Search">
                    <button type="submit" class="btn btn-outline-light">Rechercher</button>
                </form>
            </div>
        </div>        
    </nav>
<br><br><br>
<div class="text-center" >
    <div class="container" >
        <br><br><br>
        Tépéhone : <a href="tel:0782084289">0782084289</a>
        <br><br>
        Email : <a href="mailto:contact@michelchen.fr">contact@michelchen.fr</a>
        <br><br>
    </div>

<p>Vous pouvez aussi me contacter en complétant ce formulaire :</p><br>

<FORM method="POST" action="contact.php">
    <br>Email : <input name="email"><br>
    Objet de l'Email : <input name="objet"><br>
    Votre message : <textarea name="message" rows=10 cols=40></textarea><br>
    <input type="submit" value="Envoyer"><br><br>
</FORM>
    </div>
</div>
<?php

if (isset($_POST['submit'])) {
    $email = $_POST['email'];
    $objet = $_POST['objet'];
    $message = $_POST['message'];
    echo 'Votre message a bien été envoyé<br>';
    echo "Adresse mail = $email<br>";
    echo "objet de l'email = $objet<br>";
    echo "Contenu du texte envoyé = $message";
    mail('yepmtx@gmail.com',$objet,$message);
}
?>

</body>

</html>