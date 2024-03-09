<?php
include '_conf.php';
?>
<?php
if ($bdd = mysqli_connect($serveurBDD, $userBDD, $mdpBDD, $nomBDD))
{
echo " connexion BDD réussie !" ;
}
else
{
echo 'Erreur';
}
?>
