<?php
	include("class.php");
	energy::db();
	$uname=!isset($_SESSION['user'])?"":$_SESSION['user'];
	$q=mysql_query("SELECT * FROM activity WHERE username='$uname'")or die(":::Problem with first fetching.");
	$n=mysql_num_rows($q);
	if($n==0){
			echo "0";
	}
	else if($n>0){
		$docname=array();$tit=array();$conc=array();$freq=array();$tim=array();$id=array();$k=0;
		while($rr=mysql_fetch_array($q)){
			$docname[$k]=$rr['documentURL'];
			$tit[$k]=$rr['documentTitle'];
			$conc[$k]=$rr['concept'];
			$freq[$k]=$rr['frequency'];
			$time[$k]=$rr['time'];
			$id[$k]=$rr['activityID'];
			$k++;
		}
		echo "<div style='clear:both;margin-bottom:20px;'><div style='margin-right:10px;float:left;width:70px;font-weight:bold;'>URL</div><div style='margin-right:10px;float:left;width:70px;font-weight:bold;'>Title</div><div style='margin-right:10px;float:left;width:70px;font-weight:bold;'>Concept</div><div style='margin-right:10px;float:left;width:70px;font-weight:bold;'>Frequency</div><div style='float:left;width:70px;font-weight:bold;'>Time</div></div>";
		for($i=0;$i<count($id);$i++){
			$docnames=$docname[$i];
			$tits=$tit[$i];
			$concs=$conc[$i];
			$freqs=$freq[$i];
			$times=$time[$i];
			echo "<div style='clear:both;margin-bottom:20px;'><div style='margin-right:10px;float:left;width:70px;word-wrap:break-word;'>$docnames</div><div style='margin-right:10px;float:left;width:70px;word-wrap:break-word;'>$tits</div><div style='margin-right:10px;float:left;width:70px;word-wrap:break-word;'>$concs</div><div style='margin-right:10px;float:left;width:70px;word-wrap:break-word;'>$freqs</div><div style='float:left;width:70px;word-wrap:break-word;'>$times</div></div>";
		}
	}
?>