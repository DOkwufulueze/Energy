<?php
	include("class.php");
?>
<form method="" action="">
	<div style="clear:both;margin-bottom:10px;">
		<div style="float:left;margin-right:5px;">
			<span style="width:60px;">Attribute 1</span><br />
			<span style="">
				<input type="text" id="att1" name="att1" size="7" />
			</span>
		</div>
		<div style="float:left;margin-right:5px;">
			<span style="margin-right:5px;width:60px;">Attribute 2</span><br />
			<span style="">
				<input type="text" id="att2" name="att2" size="7" />
			</span>
		</div>
		<div style="float:left;margin-right:5px;">
			<span style="margin-right:5px;width:60px;">Attribute 3</span><br />
			<span style="">
				<input type="text" id="att3" name="att3" size="7" />
			</span>
		</div>
	</div>
	
	<div style="clear:both;">
		<div style="clear:both;">
			<br /><br />Constraints:
		</div>
		<div style="clear:both;margin-bottom:10px;">
			<span style="float:left;width:100px;">User</span><br />
			<span style="">
				<input type="text" id="usr" name="usr" />
			</span>
		</div>
		<div style="clear:both;margin-bottom:10px;">
			<span style="float:left;width:100px;">Concept</span><br />
			<span style="">
				<input type="text" id="conc" name="conc" />
			</span>
		</div>
		<div style="clear:both;margin-bottom:10px;">
			<span style="float:left;width:100px;">Time</span><br />
			<span style="">
				<input type="text" id="tim" name="tim" />
			</span>
		</div>
	</div>
	
	<div style="clear:both;">
		<span style="float:left;">
			<input type="button" onclick="valAtt()" value="Execute" />
		</span>
	</div>
</form>