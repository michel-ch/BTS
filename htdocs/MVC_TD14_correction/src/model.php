
<?php    // Connexion à la base de données
/*
function getUser($id)
{
 
	$database = dbConnect();
	$statement = $database->prepare(
    	"SELECT id, name, firstname, login, email
		FROM user 
		WHERE id = ?"
	);
	$statement->execute([$id]);

	$row = $statement->fetch();
	$user = [
		'identifier' => $row['id'],
    	'name' => $row['name'],
    	'firstname' => $row['firstname'],
    	'login' => $row['login'],
		'email' => $row['email'],
	];

	return $user;
}
*/

function createComment(string $post, string $author, string $comment)
{
	$database = dbConnect();
	$statement = $database->prepare(
    	'INSERT INTO comments(post_id, author, comment, comment_date) VALUES(?, ?, ?, NOW())'
	);
	$affectedLines = $statement->execute([$post, $author, $comment]);

	return ($affectedLines > 0);
}

 
 function getPosts(){
      $bdd=dbConnect();

      // On récupère les 5 derniers billets
      $req = $bdd->query('SELECT posts.id, title, content, DATE_FORMAT(creation_date, \'%d/%m/%Y à %Hh%imin%ss\') AS creation_date,login 
	  FROM posts,user
	  WHERE user.id = posts.author
	  ORDER BY creation_date DESC LIMIT 0, 5');

		$posts = [];
		while (($row = $req->fetch())) {
			$post = [
				'id' => $row['id'],
				'title' => $row['title'],
				'french_creation_date' => $row['creation_date'],
				'content' => $row['content'],
				'login' => $row['login'],
			];

			$posts[] = $post;
		}
		return $posts;
 }	

function getPost($id) {
	$database = dbConnect();
	$statement = $database->prepare(
    	"SELECT posts.id, title, content, DATE_FORMAT(creation_date, '%d/%m/%Y à %Hh%imin%ss') AS french_creation_date,login 
		FROM posts ,user WHERE user.id = posts.author
		AND posts.id = ?"
	);
	$statement->execute([$id]);

	$row = $statement->fetch();
	$post = [
		'identifier' => $row['id'],
    	'title' => $row['title'],
    	'french_creation_date' => $row['french_creation_date'],
    	'content' => $row['content'],
		'login' => $row['login'],
	];

	return $post;
}

// Nouvelle fonction qui nous permet d'éviter de répéter du code
function dbConnect()
{
    try {
        $database = new PDO('mysql:host=localhost;dbname=mvc2;charset=utf8', 'root', '');

        return $database;
    } catch(Exception $e) {
        die('Erreur : '.$e->getMessage());
    }
}	

function getComments($identifier)
{
 
 	$database = dbConnect();
    $statement = $database->prepare(
        "SELECT comments.id, author, comment, DATE_FORMAT(comment_date, '%d/%m/%Y à %Hh%imin%ss') AS french_creation_date ,login
		FROM comments,user
		WHERE user.id = comments.author
		AND post_id = ? ORDER BY comment_date DESC"
    );
    $statement->execute([$identifier]);
 
    $comments = [];
    while ($row = $statement->fetch()) {
        $comment = [
            'author' => $row['author'],
            'french_creation_date' => $row['french_creation_date'],
            'comment' => $row['comment'],
			'login' => $row['login'],
        ];
        $comments[] = $comment;
    }

    return $comments;
}


function connexion($login,$mdp){

	$database=dbConnect();
	$motdepasse=md5($mdp);
	$statement = $database->prepare("SELECT login,mdp,nom,prenom,email FROM user
	WHERE user.login = ? AND user.mdp = ?");
	// echo "$login. motdepasse .$motdepasse";
	$statement->execute([$login,$motdepasse]);
	$info = 0 ;
    while ($donnees = $statement->fetch()){
		$info = [
			'nom' => $donnees['nom'],
			'prenom' => $donnees['prenom'],
			'email' => $donnees['email'],
			'login' => $donnees['login'],
		];
		//$_SESSION['nom'] => $donnees['nom'];
		//$_SESSION['prenom'] => $donnees['prenom'];
		//$_SESSION['email'] => $donnees['email'];
		//$_SESSION['login'] => $donnees['login'];
		}
		return $info;
	}

function deconnexion(){
	$_SESSION['login']=null;
	$_SESSION['email']=null;
	$_SESSION['prenom']=null;
	$_SESSION['nom']=null;
	header("Refresh:0");
	}


?>