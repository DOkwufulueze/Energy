<?php
	session_start();
	class energy{
		public static function db(){
			@mysql_connect("localhost","root","")or die(mysql_query());
			@mysql_select_db("energy")or die(mysql_error());
		}
		
		public static function signup(){
			energy::db();
			$uname=htmlentities($_POST['uname']);
			$pwd=htmlentities($_POST['pwd']);
			$sname=htmlentities($_POST['sname']);
			$fname=htmlentities($_POST['fname']);
			$sex=htmlentities($_POST['sex']);
			$phone=htmlentities($_POST['phone']);
			$q=mysql_query("SELECT * FROM signup WHERE username='$uname' ")or die(mysql_error());
			$num=mysql_num_rows($q);
			if($uname==""||$pwd==""||$sname==""||$fname==""||$phone==""){
				echo "<script>document.location.href='.?pg=signup&msg=Please fill all compulsory fields!&uname=$uname&sname=$sname&fname=$fname&phone=$phone'</script>";
			}
			else{
				if($num>0){
					echo "<script>document.location.href='.?pg=signup&msg=Username $uname is not available!'</script>";
				}
				else if($num==0){
					mysql_query("INSERT INTO signup(username,password,surname,firstname,sex,phone) VALUES('$uname','$pwd','$sname','$fname','$sex','$phone')")or die(mysql_error());
					echo "<script>document.location.href='.?pg=home&msg=$uname successfully registered!'</script>";
				}
			}
		}
		
		public static function showFile($id){
			energy::db();
			$usr=!isset($_SESSION['user'])?"":$_SESSION['user'];
			$q=mysql_query("SELECT * FROM activity WHERE activityID='$id'")or die(mysql_error());
			$n=mysql_num_rows($q);
			if($n>0){
				while($rr=mysql_fetch_array($q)){
					$fl=$rr['documentURL'];
				}
				echo "<embed src='$fl' width='280' height='340' />";
			}
		}
		
		public static function logout(){
			$uname=!isset($_SESSION['user'])?"":$_SESSION['user'];
			session_destroy();
			echo "<script>document.location.href='.?msg=$uname Logged Out!'</script>";
		}
	}
?>