<?php
echo "<br>md5<br>";
echo crypt('Vive#Les#S1aux','$1$duSel');
echo "<br>SHA 256<br>";
echo crypt('Vive#Les#S1aux','$5$duSel');
echo "<br>SHA 512<br>";
echo crypt('Vive#Les#S1aux','$6$duSel');
echo "<br>";
echo "<br>SHA 256<br>";
echo crypt('Vive#Les#S1aux','$5$duSelFin');
echo "<br>SHA 256<br>";
echo crypt('Vive#Les#S1aux','$5$duGrosSel');

echo "<br>password_hash<br>";
echo password_hash('Vive#Les#S1aux',PASSWORD_BCRYPT);

echo "<br><br>microtime<br>";
$t1=microtime();
echo password_hash('Vive#Les#S1aux',PASSWORD_BCRYPT);
$temps=(float)microtime()-(float)$t1;
echo "<br>";
echo "durée exécution = $temps secondes";
echo "<br>";

echo "<br>password_hash cout 5<br>";
$cost=5;
$t2=microtime();
echo password_hash('Vive#Les#S1aux',PASSWORD_BCRYPT,["cost" => $cost]);
$temps=(float)microtime()-(float)$t2;
echo "<br>";
echo "durée exécution = $temps secondes";
echo "<br>";

echo "<br>password_hash cout 15<br>";
$cost=15;
$t3=microtime();
echo password_hash('Vive#Les#S1aux',PASSWORD_BCRYPT,["cost" => $cost]);
$temps=(float)microtime()-(float)$t3;
echo "<br>";
echo "durée exécution = $temps secondes";
echo "<br>";

echo password_verify('a','$6$rounds=500000$Zr56Y#123$VLQXmIGuOB7oggdzArOQF.WmrrJlBH.OPhHXaK8WiRubvKlqCfK7cHrY01KCs9/Kgfm7.J/3rvOXH0TLimggn/');
echo "<br>";
if (password_verify('UnMot2Passe','$2y$12$SuP21Kvq9xb2JXW7oSxOLudahWZdHVRvBSl1xzYPRhKurxiQTxjGW')){
    echo "UnMot2Passe est le mot de passe";
}
elseif (password_verify('M0t2Pass','$2y$12$SuP21Kvq9xb2JXW7oSxOLudahWZdHVRvBSl1xzYPRhKurxiQTxjGW')) {
     echo "M0t2Pass est le mot de passe";
}
else {
    echo "Aucun mot de passe correct";
}
?>
