<?php
	include("class.php");
	energy::db();
	$obj=!isset($_GET['obj'])?"":$_GET['obj'];
	$stat=!isset($_GET['stat'])?"":$_GET['stat'];
	$cont=!isset($_GET['cont'])?"":$_GET['cont'];
	$dt=date("Y-m-d H:i:s");
	$usr=!isset($_SESSION['user'])?"":$_SESSION['user'];
	if($usr!=""){
		//$q=mysql_query("INSERT INTO objective(username,userStatus,objective,timestamp) VALUES('$usr','$stat','$obj','$dt')") or die(mysql_error());
		if(mysql_query("INSERT INTO objective(username,userStatus,objective,timestamp) VALUES('$usr','$stat','$obj','$dt')")){
			echo "Success";
		}
		else{
			echo "Fail";
		}
	}
	else{
		echo ":::Invalid Access!";
	}
?>