<?php

function dbConnect() {
    try {
        // Connexion à la base de données
        $database = new PDO('mysql:host=localhost;dbname=bloc2MVC;charset=utf8', 'root', '');
        return $database;
    } catch (Exception $e) {
        die('Erreur : '.$e->getMessage());
    }

}


function getPosts() {


// On récupère les 5 derniers billets
      
      $statement = dbConnect()->query('SELECT id, title, content, DATE_FORMAT(creation_date, \'%d/%m/%Y à %Hh%imin%ss\') AS date_creation_fr FROM billets ORDER BY creation_date DESC LIMIT 0, 5');
    $posts=[];
      while (($row = $statement->fetch())) 
      {
        $post = [
            'title' => $row['title'],
            'french_creation_date' => $row['date_creation_fr'],
            'content' => $row['content'],
        ];

        $posts[] = $post;
      } // Fin de la boucle des billets
        
            $statement->closeCursor();
            return $posts;
}

function getPost($id) {


// On récupère un billet
      
      $statement = dbConnect()->prepare('SELECT id, title, content, DATE_FORMAT(creation_date, \'%d/%m/%Y à %Hh%imin%ss\') AS date_creation_fr FROM billets WHERE id= ?');
      $statement -> execute([$id]);
      $donnee = $statement->fetch();
      $post = [
          'title' => $donnee['title'],
          'french_creation_date' => $row['date_creation_fr'],
          'content' => $donnee['content'],
      ];
        
      $statement->closeCursor();
      return $post;
}
?>
