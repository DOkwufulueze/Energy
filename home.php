<?php
	 include("class.php");
	 include("top.inc");
  ?>
    <div id="content">
		<div id="welcome" style="clear:both;">
			<div id="username" style="float:left;width:200px;margin-right:10px;text-align:left;">
				<?php echo $msg=!isset($_GET['msg'])?"":$_GET['msg']."<br />"; ?>
				<div id="login" > 
					username:<input type="text" name="uname" id="uname" /></br>
					password:<input type="password" name="pwd" id="pwd"></br>
					<input type="button" value="Login" onclick="login()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=".?pg=signup">Register</a>
				</div>
			</div>
			<div>
				<img src="images/energy.jpg" style="width:680px;" height="130" />
			</div>
		</div>
		
		<div id="domain" style="clear:both;">
			<?php
				$usr=!isset($_SESSION['user'])?"":$_SESSION['user'];
				$dm=!isset($_SESSION['domain'])?"":$_SESSION['domain'];
				$act=!isset($_SESSION['act'])?"":$_SESSION['act'];
				if($usr==""){
			?>	
			<span style="float:right;">Login to enable the dropdown menu at the left hand side, and select a domain.</span>
			<div id="energy" style="float:left;width:200px;margin-right:10px;">
				<select name="domains" id="domains" disabled>
					<option value="">Select Domain</option>
					<option value="Energy">Energy</option>
					<option value="Biomass">Biomass</option>
					<option value="Environment">Environment</option>
				</select>
			</div>
			<?php
				}
				else if($usr!=""&&($dm==""||$dm=="0")&&($act==""||$act=="0")){
			?>
			<span style="clear:both;float:right;"><a href='.?pg=logout' style="color:#2222ff;">Logout</a></span>
			<div id="energy" style="float:left;width:200px;margin-right:10px;">
				<select name="domains" id="domains" onchange="showMain()" >
					<option value="">Select Domain</option>
					<option value="Energy">Energy</option>
					<option value="Biomass">Biomass</option>
					<option value="Environment">Environment</option>
				</select>
			</div>
			
		</div>
		
		<div id="main" style="clear:both;display:none;">
			<div id="menu" style="">
				<span style="clear:both;float:right;"><a href='.?pg=logout' style="color:#2222ff;">Logout</a></span>
				<div id="exp" style="clear:both;margin-bottom:50px;"> 
					<input type="button" value="Exploration" onclick="showExploration()"  />
				</div>
				<div id="srch" style="clear:both;margin-bottom:50px;"> 
					<input type="button" value="Search" onclick="showSearch()"  />
				</div>
				<div id="knowledge" style="clear:both;margin-bottom:50px;"> 
					<input type="button" value="Knowledge Extraction" onclick="showKnowledge()"  />
				</div>
				<div id="back" style="clear:both;margin-bottom:50px;"> 
					<input type="button" value="View History" onclick="history()"  />
				</div>
				<div id="back" style="clear:both;margin-bottom:10px;"> 
					<input type="button" value="Go Back to Domain Selection" onclick="back()"  />
				</div>
			</div>
			<div id="default" style="">
				<?php echo !isset($_GET['msgMind'])?"":$_GET['msgMind']."<br />"; ?>
			</div>
			
			<div id="mindMap" style="text-align:center;">
				&nbsp;
			</div>
		</div>
		<?php
			}
			else if($usr!=""&&$dm!=""&&$dm!="0"&&$act!=""&&$act!="0"){
		?>
		<div id="main" style="clear:both;display:block;">
			<div id="menu" style="">
				<span style="clear:both;float:right;"><a href='.?pg=logout' style="color:#2222ff;">Logout</a></span>
				<div id="exp" style="clear:both;margin-bottom:50px;"> 
					<input type="button" value="Exploration" onclick="showExploration()"  />
				</div>
				<div id="srch" style="clear:both;margin-bottom:50px;"> 
					<input type="button" value="Search" onclick="showSearch()"  />
				</div>
				<div id="knowledge" style="clear:both;margin-bottom:50px;"> 
					<input type="button" value="Knowledge Extraction" onclick="showKnowledge()"  />
				</div>
				<div id="back" style="clear:both;margin-bottom:50px;"> 
					<input type="button" value="View History" onclick="history()"  />
				</div>
				<div id="back" style="clear:both;margin-bottom:10px;"> 
					<input type="button" value="Go Back to Domain Selection" onclick="back()"  />
				</div>
			</div>
			
			<div id="default" style="">
				<?php echo !isset($_GET['msgMind'])?"":$_GET['msgMind']."<br />"; ?>
			</div>
			
			<div id="mindMap" style="text-align:center;">
				<?php 
					$id=!isset($_GET['id'])?"":$_GET['id'];
					energy::showFile($id); 
				?>
			</div>
		</div>
		<?php
			}
		?>
	</div> 

  
  
  <?php
  include("foot.inc");
  ?>