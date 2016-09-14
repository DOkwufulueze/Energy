<?php
  include("class.php");
  include("top.inc");
  if($_POST){
	energy::signup();
  }
 ?>
<span style=""><?php echo $_GET['msg']=!isset($_GET['msg'])?"":$_GET['msg'] ; ?></span><br />
<form method="post" action="">
    <fieldset style="border:1px solid pink">
	   <legend style="color:red; border:dashed pink">
	   <i>REGISTRATION</i>
	   </legend>
	   
			<div id="Sform">
				<span style="color:red">*</span> Username:<input type="text" name="uname" id="uname" style="margin-left:9px" value="<?php echo !isset($_GET['uname'])?'':$_GET['uname'] ; ?>" /><br><br>
				<span style="color:red">*</span> Password:<input type="password" name="pwd" id="pwd" style="margin-left:10px"/><br><br>
				<span style="color:red">*</span> Surname:<input type="text" name="sname" id="sname" style="margin-left:17px" value="<?php echo !isset($_GET['sname'])?'':$_GET['sname'] ; ?>" /><br><br>
				<span style="color:red">*</span> First name:<input type="text" name="fname" id="fname" style="margin-left:7px" value="<?php echo !isset($_GET['fname'])?'':$_GET['fname'] ; ?>" /><br><br>
				
				Sex:  <select name="sex" id="sex">
					      <option value="">Select your Sex</option>
					      <option value="Male">Male</option>
						  <option value="Female">Female</option>
						</select></br><br>
					  
				<span style="color:red">*</span> Phone No:<input type="text" name="phone" id="phone" style="margin-left:42px" value="<?php echo !isset($_GET['phone'])?'':$_GET['phone'] ; ?>" ></input><br><br>
				<input type="submit" value="Register" style="margin-left:450px" onmousedown="valSignup()" />
		
			</div>
 
    </fieldset>   
 
</form>
<?php
  include("foot.inc");
?>