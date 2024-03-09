<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"charset="utf-8">
    <title>Projet</title>
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
                    <a href="contact.php" class="nav-item nav-link">Contact</a>
                </div>
            </div>
        </div>        
    </nav>
<br><br><br>
<div class="container">
  <div class="row">
    <div class="col-md-4 d-flex justify-content-center text-center">
        <div class="col">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Un1.svg/1200px-Un1.svg.png" class="rounded img-thumbnail"><br><br>
            <h5>Projet 1</h5><br><br>
            Description :<br>
            aaa
            <br><br>

            <?php
            session_start();

            $_SESSION['commentaire1']=$_POST['commentaire1'];

            $commentaire1=$_SESSION['commentaire1'];
            if (empty($commentaire1)){
                echo "Pas de commentaire";
            }
            else {
                echo "<p>Commentaire:<br><br>$commentaire1";
            }
            ?>
            </p><br>
            <a href="http://sioreport.fr/21.CHEN/TD1/">TD1</a><br><br>
            <a href="commentaire1.php">Commenter le Projet 1</a>

        </div>



    </div>
    <div class="col-md-4 d-flex justify-content-center text-center">
        <div class="col">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Deux.svg/1200px-Deux.svg.png" class="rounded img-thumbnail"><br><br>
            <h5>Projet 2</h5><br><br>
            Description :<br>
            aaa
            <br><br>

            <?php
            

            $_SESSION['commentaire2']=$_POST['commentaire2'];

            $commentaire2=$_SESSION['commentaire2'];
            if (empty($commentaire2)){
                echo "Pas de commentaire";
            }
            else {
                echo "<p>Commentaire:<br><br>$commentaire2";
            }
            ?>
            </p><br>
            <a href="http://sioreport.fr/21.CHEN/TD2/">TD2</a><br><br>
            <a href="commentaire2.php">Commenter le Projet 2</a>

        </div>



    </div>
    <div class="col-md-4 d-flex justify-content-center text-center">
        <div class="col">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/6d/Trois.svg/1200px-Trois.svg.png" class="rounded img-thumbnail"><br><br>
            <h5>Projet 3</h5><br><br>
              Description :<br>
            aaa
            <br><br>

            <?php
            

            $_SESSION['commentaire3']=$_POST['commentaire3'];

            $commentaire3=$_SESSION['commentaire3'];
            if (empty($commentaire3)){
                echo "Pas de commentaire";
            }
            else {
                echo "<p>Commentaire:<br><br>$commentaire3";
            }
            ?>
            </p><br>
            <a href="http://sioreport.fr/21.CHEN/TD3/">TD3</a><br><br>
            <a href="commentaire3.php">Commenter le Projet 3</a>
        </div>




    </div>
</div>

</body>

</html>
