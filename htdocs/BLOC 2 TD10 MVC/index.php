
      <?php
        require('src/model.php');
        $posts=getPosts(); // utilisation de la fonction de model
        /// $post=getPost(1);
        require('templates/homepage.php');
        
      ?>

