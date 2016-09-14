<?php
	include("class.php");
	$dm=!isset($_GET['domain'])?"":$_GET['domain'];
	$_SESSION['domain']=$dm;
?>