<?php
	include("class.php");
?>
<form method="" action="">
	<div style="clear:both;margin-bottom:30px;">
		<span style="float:left;margin-right:5px;width:100px;">Objective</span>
		<span style="">
			<input type="text" id="obj" name="obj" value="<?php echo !isset($_GET['obj'])?"":$_GET['obj'] ;?>" />
		</span>
	</div>
	<div style="clear:both;margin-bottom:30px;">
		<span style="float:left;margin-right:5px;width:100px;">User Status</span>
		<span style="">
			<input type="text" id="stat" name="stat" value="<?php echo !isset($_GET['stat'])?"":$_GET['stat'] ;?>" />
		</span>
	</div>
	<div style="clear:both;margin-bottom:30px;">
		<span style="float:left;margin-right:5px;width:100px;">Context</span>
		<span style="">
			<input type="text" id="cont" name="cont" value="<?php echo !isset($_GET['cont'])?"":$_GET['cont'] ;?>" />
		</span>
	</div>
	<div style="clear:both;">
		<span style="float:left;">
			<input type="button" onclick="valObj()" value="Submit" />
		</span>
	</div>
</form>