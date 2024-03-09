<?php ob_start(); ?>
<h1>Le super blog de l'AVBN !</h1>
<p>Derniers billets du blog :</p>

<?php
foreach ($posts as $post) {
?>
        <div class="news">
        <h3>
        <?php echo htmlspecialchars($post['title']); ?>
        <em>le <?php echo $post['french_creation_date']; ?></em>
        </h3>
        <p>
        <?php
        // We display the post content.
        echo nl2br(htmlspecialchars($post['content']));
        ?>
        <br />
		<em><a href="post.php?id=<?php echo $post['id']?>">Commentaires</a></em>
            
        </p>
        </div>
<?php
} // The end of the posts loop.
?>
<?php $content = ob_get_clean(); ?>
<?php $title = ob_get_clean(); ?>
<?php require('layout.php')?>
