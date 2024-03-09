 <?php    // Connexion à la base de données
 function getPosts(){
      $bdd=dbConnect();

      // On récupère les 5 derniers billets
      $req = $bdd->query('SELECT id, title, content, author, DATE_FORMAT(creation_date, \'%d/%m/%Y à %Hh%imin%ss\') AS creation_date FROM posts ORDER BY creation_date DESC LIMIT 0, 5');

		$posts = [];
		while (($row = $req->fetch())) {
			$post = [
				'id' => $row['id'],
				'title' => $row['title'],
                'author' => $row['author'],
				'french_creation_date' => $row['creation_date'],
				'content' => $row['content'],
			];

			$posts[] = $post;
		}
		return $posts;
 }	

function getPost($id) {
	$database = dbConnect();
	$statement = $database->prepare(
    	"SELECT posts.id, title, content, DATE_FORMAT(creation_date, '%d/%m/%Y à %Hh%imin%ss') AS french_creation_date 
FROM posts, author
WHERE posts.id = ?;"
	);
	$statement->execute([$id]);

	$row = $statement->fetch();
	$post = [
		'identifier' => $row['id'],
    	'title' => $row['title'],
    	'french_creation_date' => $row['french_creation_date'],
    	'content' => $row['content'],
	];

	return $post;
}

// Nouvelle fonction qui nous permet d'éviter de répéter du code
function dbConnect()
{
    try {
        $database = new PDO('mysql:host=localhost;dbname=BLOC 2 TD13;charset=utf8', 'root', '');

        return $database;
    } catch(Exception $e) {
        die('Erreur : '.$e->getMessage());
    }
}	

function getComments($identifier)
{
 
 	$database = dbConnect();
    $statement = $database->prepare(
        "SELECT comments.id, author.name, comment, DATE_FORMAT(comment_date, '%d/%m/%Y à %Hh%imin%ss') AS french_creation_date FROM comments,author WHERE post_id = ? AND author.id=comments.author ORDER BY comment_date DESC "
    );

    $statement->execute([$identifier]);
 
    $comments = [];
    while (($row = $statement->fetch())) {
        $comment = [
            'author' => $row['name'],
            'french_creation_date' => $row['french_creation_date'],
            'comment' => $row['comment'],
        ];
        $comments[] = $comment;
    }

    return $comments;
}

function createComment(string $post, string $author, string $comment)
{
	$database = dbConnect();
	$statement = $database->prepare(
    	'INSERT INTO comments(post_id, author, comment, comment_date) VALUES(?, ?, ?, NOW()) '
	);
	$affectedLines = $statement->execute([$post, $author, $comment]);

	return ($affectedLines > 0);
}


function connexion($login,$pwd){
    $database = dbConnect();
	$statement = $database->prepare(
    	"SELECT * FROM author 
		WHERE login = ? AND pwd= ?"
	);
	try {
        $statement->execute([$login,$pwd]);
    
        $row = $statement->fetch();
        $donneeconnexion = [
            'id' => $row['id'],
            'name' => $row['name'],
            'firstname' => $row['firstname'],
            'login' => $row['login'],
            'email' => $row['email']
            ];
        return $donneeconnexion;
    } catch(Exception $e) {
        // die('Erreur : '.$e->getMessage());
        echo 'Identifiant ou mot de passe incorrect';
    }
}


		?>
