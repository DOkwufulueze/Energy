<?php
	include("class.php");
	energy::db();
	$docname=!isset($_GET['doc'])?"":$_GET['doc'];
	$docname=urldecode($docname);//decodes %5C to \
	$docname=str_replace("\\","/",$docname);//changes \ to /
	$tit=substr($docname,strrpos($docname,"/")+1);
	$concept=!isset($_GET['concept'])?"":$_GET['concept'];
	$uname=!isset($_SESSION['user'])?"":$_SESSION['user'];
	$q=mysql_query("SELECT * FROM activity WHERE username='$uname' AND documentURL='$docname' AND concept='$concept'")or die(":::Problem with first fetching.");
	$n=mysql_num_rows($q);
	if($n==0){
		$time=date("Y-m-d H:i:s");
		if(mysql_query("INSERT INTO activity(username,documentURL,documentTitle,concept,frequency,time) VALUES('$uname','$docname','$tit','$concept','1','$time')")){//or die(mysql_error());
			$_SESSION['act']=1;
			$q=mysql_query("SELECT * FROM activity WHERE username='$uname' AND documentURL='$docname' AND concept='$concept'")or die(":::Problem with fetching.");
			$n=mysql_num_rows($q);
			if($n>0){
				while($rr=mysql_fetch_array($q)){
					$id=$rr['activityID'];
				}
				echo "$id";
			}
		}
		else{
			echo ":::Problems with inserting.";
		}
	}
	else if($n>0){
		while($rr=mysql_fetch_array($q)){
			$freq=$rr['frequency'];
			$id=$rr['activityID'];
		}
		$freq+=1;
		mysql_query("UPDATE activity SET frequency='$freq' WHERE username='$uname' AND documentURL='$docname' AND concept='$concept'")or die(":::Problem with updating.");
		$_SESSION['act']=2;
		echo "$id";
	}
?>