<?php
	include("class.php");
	energy::db();
	$uname=!isset($_GET['uname'])?"":$_GET['uname'];
	$pwd=!isset($_GET['pwd'])?"":$_GET['pwd'];
	$q=mysql_query("SELECT * FROM signup WHERE username='$uname' AND password='$pwd'") or die(mysql_error());
	$n=mysql_num_rows($q);
	if($n==0){
		echo "0";
	}
	else if($n>0){
		$_SESSION['user']=$uname;
		$_SESSION['act']=0;
		echo $uname;
	}
?>