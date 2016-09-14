<?php

switch($_GET['pg']=!isset($_GET['pg'])?"":$_GET['pg']){
        case"home":
        include("home.php");
        break;
		
		case"signup":
        include("signup.php");
        break;
		
		case"logout":
        include("class.php");
		energy::logout();
        break;
		
        default:
        include("home.php");
        break;
}
?>