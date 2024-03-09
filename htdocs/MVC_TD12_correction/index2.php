<?php

if ($_GET['action'] === 'connexion') //reçois données rentrée lors de la connexion
{
   
    $id = $_POST['id'];
    $mdp =  $_POST['mdp'];
    require_once('src/model.php');
    if (connexion($id,$mdp)) {
        require_once('src/controllers/homepage.php');
        require_once('src/controllers/post.php');
        require_once('src/controllers/add_comment.php');

if (isset($_GET['action']) && $_GET['action'] !== '') {
	if ($_GET['action'] === 'post') {
    	if (isset($_GET['id']) && $_GET['id'] > 0) {
        	$identifier = $_GET['id'];
            
        	post($identifier);
    	} else {
        	echo 'Erreur : aucun identifiant de billet envoyé';

        	die;
    	}

        
	  }   /// AJOUT   
elseif ($_GET['action'] === 'addComment') {
    	if (isset($_GET['id']) && $_GET['id'] > 0) {
        	$identifier = $_GET['id'];

        	addComment($identifier, $_POST);
    	} else {
        	echo 'Erreur : aucun identifiant de billet envoyé';

        	die;
    	}
}else {
    	echo "Erreur 404 : la page que vous recherchez n'existe pas.";
	}

}else {
	homepage();
}


};
?>
