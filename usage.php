<?php
	include("class.php");
?>
<form method="post" action="sbmExp.php" enctype="multipart/form-data">
	<!--div style="clear:both;margin-bottom:30px;">
		<span style="float:left;margin-right:5px;width:100px;">Username</span>
		<span style="">
			<input type="text" id="uname" name="uname" value="<?php //echo !isset($_GET['uname'])?"":$_GET['uname'] ;?>" />
		</span>
	</div-->
	<div style="clear:both;margin-bottom:30px;">
		<span style="float:left;margin-right:5px;width:100px;">User Status</span>
		<span style="">
			<input type="text" id="stat" name="stat" />
		</span>
	</div>
	<div style="clear:both;margin-bottom:30px;">
		<span style="float:left;margin-right:5px;width:100px;">Document URL</span>
		<span style="">
			<input type="text" id="doc1" name="doc" size="30" value="<? echo !isset($_GET['doc'])?"":$_GET['doc']; ?>" disabled />
			<input type="hidden" name="doc" id="doc" value="<? echo !isset($_GET['doc'])?"":$_GET['doc']; ?>" />
		</span>
	</div>
	<div style="clear:both;margin-bottom:30px;">
		<span style="float:left;margin-right:5px;width:100px;">Document Title</span>
		<span style="">
			<input type="text" id="tit1" name="tit" size="30" value="<? echo !isset($_GET['tit'])?"":$_GET['tit']; ?>" disabled />
			<input type="hidden" name="tit" id="tit" value="<? echo !isset($_GET['tit'])?"":$_GET['tit']; ?>" />
		</span>
	</div>
	<div style="clear:both;margin-bottom:30px;">
		<span style="float:left;margin-right:5px;width:100px;">Context</span>
		<span style="">
			<input type="text" id="cont" name="cont" />
		</span>
	</div>
	<div style="clear:both;margin-bottom:30px;">
		<span style="float:left;margin-right:5px;width:100px;">Degree</span>
		<span style="">
			<input type="text" id="deg" name="deg" />
		</span>
	</div>
	<div style="clear:both;">
		<span style="float:left;">
			<input type="submit" onmousedown="valExp()" value="Submit" />
		</span>
	</div>
</form>