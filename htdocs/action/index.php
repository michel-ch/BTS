 <?php    

 function getPosts(){
		$posts = [[1, "Martin","05/05/2020", "description 1"],
[2, "Jibril","06/05/2020", "description 2"],
[3, "Nessim","07/05/2020", "description de Nessim"],
[4, "Alexander","06/05/2020", "description d'Alexander"],
[5, "Sirine","06/05/2020", "description de Sirine"],];	
		return $posts;
 }	
//récupérer la liste des postes grâce à la fonction puis afficher la sous forme de tableau

echo "<table border=1>
      <tr>
        <th>Numéro</th>
        <th>Prenom</th>
        <th>Date</th>
        <th>Description</th>
      </tr>
      "?>
      <?php
      $post=getPosts();
      foreach ($post as $valeur ){
      echo "<tr>
                <td>$valeur[0]</td>
                <td>$valeur[1]</td>
                <td>$valeur[2]</td>
                <td>$valeur[3]</td>
            </tr>";
        }
    echo "</table>";


?>
