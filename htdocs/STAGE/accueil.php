<?php
session_start();

if (isset($_POST['send_con']))
{
    $login=$_POST['login'];
    $motdepasse=md5($_POST['motdepasse']);

    include '_conf.php';
    $connexion = mysqli_connect($serveurBDD, $userBDD, $mdpBDD, $nomBDD);

    $requete="Select * from UTILISATEUR WHERE login='$login'AND motdepasse='$motdepasse'";
    echo "<hr>$requete<hr>";
    $resultat=mysqli_query($connexion,$requete);
    $trouve=0;

    while ($donnees=mysqli_fetch_assoc($resultat)) {
            $trouve=1;
            $login=$donnees['login'];
            $num=$donnees['num'];
            $nom=$donnees['nom'];
            $type=$donnees['type'];
            $email=$donnees['email'];
            $motdepasse=$donnees['motdepasse'];
    
}
if($trouve==1){
    echo "<br>Bon mot de passe<br><br>";
    $_SESSION['login']=$login;
    $_SESSION['num']=$num;
    $_SESSION['nom']=$nom;
    $_SESSION['type']=$type;    
    $_SESSION['email']=$email;    
    $_SESSION['motdepasse']=$motdepasse;

}
else {
    echo "Erreur de mot de passe<br><br>";
}
if ($trouve==1) {
if (isset($_SESSION['login'])){
echo "Connexion reussie !<br><br>";
echo "Bienvenue $login <br><br>";
}
else {
echo "La connexion est perdue, veuillez revenir à la <a href='index.html'>page d'index</a> pour vous reconnecter."; 
}
}
else {
echo "Veuillez revenir à la <a href='index.html'>page d'index</a> pour vous identifier.<br><br>"; 
}
}
?>
<FORM method='POST' action="perso.php"><input type="submit" value="Vos informations"><br></FORM><br><br>
<FORM method='POST' action="deconnexion.php"><input type="submit" value="Déconnexion" name="deconnexion"></FORM><br>
<?





/*resultat = executer la requete dans la base de donnée*/


/*

if ($login="Select * from User WHERE login='$login'"&&$mdp=$requete="Select * from User WHERE mdp='$mdp'");
{
echo mdp en md5:("Select * from User WHERE mdp=md5($mdp)");
}
else {
echo "erreur"
}
*/


?>


