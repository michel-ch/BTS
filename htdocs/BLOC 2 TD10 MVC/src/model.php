<?php

function dbConnect() {
    try {
        // Connexion à la base de données
        $database = new PDO('mysql:host=localhost;dbname=bloc2 TD10 MVC;charset=utf8', 'root', '');
        return $database;
    } catch (Exception $e) {
        die('Erreur : '.$e->getMessage());
    }

}


function getPosts() {


// On récupère les 5 derniers billets
      
      $statement = dbConnect()->query('SELECT id, title, content, DATE_FORMAT(creation_date, \'%d/%m/%Y à %Hh%imin%ss\') AS date_creation_fr FROM posts ORDER BY creation_date DESC LIMIT 0, 5');
    $posts=[];
      while ($donnee = $statement->fetch())
      {
        $post = [
            'id' => $donnee ['id'],
            'title' => $donnee['title'],
            'french_creation_date' => $donnee['date_creation_fr'],
            'content' => $donnee['content'],
        ];

        $posts[] = $post;
      } // Fin de la boucle des billets
        
            $statement->closeCursor();
            return $posts;
}

function getPost($id) {


// On récupère un billet
      
      $statement = dbConnect()->prepare('SELECT id, title, content, DATE_FORMAT(creation_date, \'%d/%m/%Y à %Hh%imin%ss\') AS date_creation_fr FROM posts WHERE id= ?');
      $statement -> execute([$id]);
      $donnee = $statement->fetch();
      $post = [
          'title' => $donnee['title'],
          'french_creation_date' => $donnee['date_creation_fr'],
          'content' => $donnee['content'],
      ];
        
      $statement->closeCursor();
      return $post;
}

function getComments($id) {
    $statement = dbConnect()->prepare('SELECT id, author, comment, DATE_FORMAT(comment_date, \'%d/%m/%Y à %Hh%imin%ss\') AS french_creation_date FROM comments WHERE post_id=? ORDER BY comment_date DESC');
    $statement -> execute([$id]);
    $donnee = $statement->fetch();
    while ($donnee = $statement->fetch())
    {
        $comment = [
            'author'=> $donnee['author'],
            'french_creation_date'=> $donnee['french_creation_date'],
            'comment'=> $donnee['comment'],
            $comments[]=$comment,
        ];
    return $comments;
    }
}


?>
