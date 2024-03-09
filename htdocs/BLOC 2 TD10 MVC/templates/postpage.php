<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8" />
      <title>Le blog de l'AVBN</title>
      <link href="style.css" rel="stylesheet" />
   </head>

   <body>
      <h1>Le super blog de l'AVBN !</h1>
      <p><a href="index.php">Retour à la liste des billets</a></p>

            <div class="news">
                <h3>
                   <?=htmlspecialchars($post['title']) ?>  <!--htmlspecialchars convertit caractère spéciaux en html-->
                    <em>le <?= $post['french_creation_date'] ?></em>
                </h3>
                <p>
                    <?= nl2br(htmlspecialchars($post['content'])) ?>
                    <br>
                </p>
            </div>
            <h2>Commentaires</h2>
    <?=foreach ($comments as $comment){
        htmlspecialchars($post['title']);
        htmlspecialchars($post['french_creation_date']);
        htmlspecialchars($post['comments']);
    }?>
   </body>
</html>
