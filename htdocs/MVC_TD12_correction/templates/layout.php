<?php 
session_start();

?>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8" />
      <title><?= $title ?></title>
      <link href="style.css" rel="stylesheet" /> 
   </head>

   <body>
      <?= $content ?>
<?php
require_once('templates/connexion.php');
?>
   </body>
</html>
