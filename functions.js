function valSignup(){
	var sname=document.getElementById("sname").value;
	var fname=document.getElementById("fname").value;
	var uname=document.getElementById("uname").value;
	var pwd=document.getElementById("pwd").value;
	var phone=document.getElementById("phone").value;
	if(sname==""||fname==""||uname==""||pwd==""||phone==""){
		alert("Please Fill the compulsory fields!");
	}
}

function login(){
	var uname=document.getElementById("uname").value;
	var pwd=document.getElementById("pwd").value;
	if(uname==""||pwd==""){
		alert("Please fill all fields!");
	}
	else{
		if(window.XMLHttpRequest){
			var xr=new XMLHttpRequest();
		}
		else if(window.ActiveXObject){
			var xr=new ActiveXObject("Microsoft.XMLHTTP");
		}
		if(xr){
			xr.onreadystatechange=function(){
				if(xr.readyState==4&&xr.status==200){
					var msg=xr.responseText;
					if(msg=="0"){
						alert("Invalid Username or Password!");
					}
					else{
						document.location.href=".?pg=home&msg=Logged In as "+msg;
					}
				}
			}
			xr.open("GET","login.php?uname="+uname+"&pwd="+pwd,true);
			xr.send();
		}
	}
}

function valExp(){
	var stat=document.getElementById("stat").value;
	var doc=document.getElementById("doc").value;
	var tit=document.getElementById("tit").value;
	var cont=document.getElementById("cont").value;
	var deg=document.getElementById("deg").value;
	if(stat==""||doc==""||tit==""||cont==""||deg==""){
		alert(":::Please fill all field");
	}
}

function showExploration(){
	var def=document.getElementById("default");
	if(window.XMLHttpRequest){
		var xr=new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		var xr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xr){
		xr.onreadystatechange=function(){
			if(xr.readyState==4&&xr.status==200){
				var msg=xr.responseText;
				def.innerHTML=msg;
				def.style.display="none";
				$("document").ready(function(){
					$("#default").show(1000);
				});
			}
		}
		xr.open("GET","exp.php",true);
		xr.send();
	}
}

function showSearch(){
	var def=document.getElementById("default");
	if(window.XMLHttpRequest){
		var xr=new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		var xr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xr){
		xr.onreadystatechange=function(){
			if(xr.readyState==4&&xr.status==200){
				var msg=xr.responseText;
				def.innerHTML=msg;
				def.style.display="none";
				$("document").ready(function(){
					$("#default").show(3000);
				});
			}
		}
		xr.open("GET","obj.php",true);
		xr.send();
	}
}

function valObj(){
	var obj=document.getElementById("obj").value;
	var stat=document.getElementById("stat").value;
	var cont=document.getElementById("cont").value;
	if(obj==""||stat==""||cont==""){
		alert(":::Please fill all field");
	}
	else{
		sbmObj(obj,stat,cont);
	}
}

function sbmObj(a,b,c){
	if(window.XMLHttpRequest){
		var xr=new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		var xr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xr){
		xr.onreadystatechange=function(){
			if(xr.readyState==4&&xr.status==200){
				var msg=xr.responseText;
				if(msg=="Success"){
					alert("Successfully Submitted.");
					document.getElementById("default").innerHTML="";
					$("document").ready(function(){
						$("#default").show(3000);
					});
				}
				else if(msg=="Fail"){
					alert(":::Could not Submit to the database.");
				}
				else{
					alert(":::Invalid Access!");
				}
			}
		}
		xr.open("GET","sbmObj.php?obj="+a+"&stat="+b+"&cont="+c,true);
		xr.send();
	}
}

function showKnowledge(){
	var def=document.getElementById("default");
	if(window.XMLHttpRequest){
		var xr=new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		var xr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xr){
		xr.onreadystatechange=function(){
			if(xr.readyState==4&&xr.status==200){
				var msg=xr.responseText;
				def.innerHTML=msg;
				def.style.display="none";
				$("document").ready(function(){
					$("#default").show(1000);
				});
			}
		}
		xr.open("GET","know.php",true);
		xr.send();
	}
}

function valAtt(){
	/*var att1=document.getElementById("att1").value;
	var att2=document.getElementById("att2").value;
	var att3=document.getElementById("att3").value;
	if(att1==""||att2==""||att3==""){
		alert(":::Please fill all field");
	}
	else{
		sbmAtt(att1,att2,att3);
	}*/
}

function sbmAtt(a,b,c){
	/*if(window.XMLHttpRequest){
		var xr=new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		var xr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xr){
		xr.onreadystatechange=function(){
			if(xr.readyState==4&&xr.status==200){
				var msg=xr.responseText;
				if(msg=="Success"){
					alert("Successfully Submitted.");
					document.getElementById("default").innerHTML="";
					$("document").ready(function(){
						$("#default").show(3000);
					});
				}
				else if(msg=="Fail"){
					alert(":::Could not Submit to the database.");
				}
				else{
					alert(":::Invalid Access!");
				}
			}
		}
		xr.open("GET","sbmObj.php?obj="+a+"&stat="+b+"&cont="+c,true);
		xr.send();
	}*/
}

function showMain(){
	var main=document.getElementById("main");
	var domain=document.getElementById("domain");
	var dmn=document.getElementById("domains").options[document.getElementById("domains").selectedIndex].value;
	if(window.XMLHttpRequest){
		var xr=new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		var xr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xr){
		xr.onreadystatechange=function(){
			if(xr.readyState==4&&xr.status==200){
				var msg=xr.responseText;
				$("document").ready(function(){
					$("#domain").hide(3000);
					$("#main").show(3000);
				});
			}
		}
		xr.open("GET","domain.php?domain="+dmn,true);
		xr.send();
	}
}

function back(){
	var main=document.getElementById("main");
	var domain=document.getElementById("domain");
	if(window.XMLHttpRequest){
		var xr=new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		var xr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xr){
		xr.onreadystatechange=function(){
			if(xr.readyState==4&&xr.status==200){
				document.location.href="?";
			}
		}
		xr.open("GET","back.php",true);
		xr.send();
	}
}

function showMindMapDoc(a,b){
	/*var def=document.getElementById("default");
	var mind=document.getElementById("mindMap");*/
	if(window.XMLHttpRequest){
		var xr=new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		var xr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xr){
		xr.onreadystatechange=function(){
			if(xr.readyState==4&&xr.status==200){
				var msg=xr.responseText;//alert("Activity Submitted Successfully.&act=1&id="+msg);
				//document.location.replace("../?msgMind=Activity Submitted Successfully.&act=1&id="+msg);
				//window.location.href="../?msgMind=Activity Submitted Successfully.&act=1&id="+msg;
				window.open("../?msgMind=Activity Submitted Successfully.&act=1&id="+msg, "_top");
				/*mind.innerHTML="<embed src='"+a+"' width='360' height='340' />";
				def.innerHTML=msg;
				$("document").ready(function(){alert(a);
					alert(msg);
					$("#default").slideDown(3000);
					$("#mindMap").show(3000);
				});*/
			}
		}
		xr.open("GET","../sbmExp.php?tit="+a+"&doc="+a+"&concept="+b,true);
		xr.send();
	}
}
function showForms(b){
	var def=document.getElementById("default");
	var mind=document.getElementById("mindMap");
	if(window.XMLHttpRequest){
		var xr=new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		var xr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xr){
		xr.onreadystatechange=function(){
			if(xr.readyState==4&&xr.status==200){
				var msg=xr.responseText;
				mind.innerHTML="<span style='font-size:20px;color:#2323ba;'>You're in the "+b+" domain.</span><embed src='pdf/forms.java' width='360' height='340' />";
				def.innerHTML=msg;
				$("document").ready(function(){
					$("#default").slideDown(3000);
					$("#mindMap").show(3000);
				});
			}
		}
		xr.open("GET","usage.php?tit=Forms of Renewable Energy&doc=pdf/forms.java",true);
		xr.send();
	}
}

function showBiomass(b){
	var def=document.getElementById("default");
	var mind=document.getElementById("mindMap");
	if(window.XMLHttpRequest){
		var xr=new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		var xr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xr){
		xr.onreadystatechange=function(){
			if(xr.readyState==4&&xr.status==200){
				var msg=xr.responseText;
				mind.innerHTML="<span style='font-size:20px;color:#2323ba;'>You're in the "+b+" domain.</span><embed src='pdf/biomass.mm' width='360' height='340' />";
				def.innerHTML=msg;
				$("document").ready(function(){
					$("#default").slideDown(3000);
					$("#mindMap").show(3000);
				});
			}
		}
		xr.open("GET","usage.php?tit=Biomass Energy&doc=pdf/biomass.mm",true);
		xr.send();
	}
}

function showSolar(b){
	var def=document.getElementById("default");
	var mind=document.getElementById("mindMap");
	if(window.XMLHttpRequest){
		var xr=new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		var xr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xr){
		xr.onreadystatechange=function(){
			if(xr.readyState==4&&xr.status==200){
				var msg=xr.responseText;
				mind.innerHTML="<span style='font-size:20px;color:#2323ba;'>You're in the "+b+" domain.</span><embed src='pdf/solar.pdf' width='360' height='340' />";
				def.innerHTML=msg;
				$("document").ready(function(){
					$("#default").slideDown(3000);
					$("#mindMap").show(3000);
				});
			}
		}
		xr.open("GET","usage.php?tit=Solar Energy&doc=pdf/solar.pdf",true);
		xr.send();
	}
}

function showWind(b){
	var def=document.getElementById("default");
	var mind=document.getElementById("mindMap");
	if(window.XMLHttpRequest){
		var xr=new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		var xr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xr){
		xr.onreadystatechange=function(){
			if(xr.readyState==4&&xr.status==200){
				var msg=xr.responseText;
				mind.innerHTML="<span style='font-size:20px;color:#2323ba;'>You're in the "+b+" domain.</span><embed src='pdf/wind.pdf' width='360' height='340' />";
				def.innerHTML=msg;
				$("document").ready(function(){
					$("#default").slideDown(3000);
					$("#mindMap").show(3000);
				});
			}
		}
		xr.open("GET","usage.php?tit=Wind Energy&doc=pdf/wind.pdf",true);
		xr.send();
	}
}

function showBenefits(b){
	var def=document.getElementById("default");
	var mind=document.getElementById("mindMap");
	if(window.XMLHttpRequest){
		var xr=new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		var xr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xr){
		xr.onreadystatechange=function(){
			if(xr.readyState==4&&xr.status==200){
				var msg=xr.responseText;
				mind.innerHTML="<span style='font-size:20px;color:#2323ba;'>You're in the "+b+" domain.</span><embed src='pdf/benefit.pdf' width='360' height='340' />";
				def.innerHTML=msg;
				$("document").ready(function(){
					$("#default").slideDown(3000);
					$("#mindMap").show(3000);
				});
			}
		}
		xr.open("GET","usage.php?tit=Benefit of Biomass&doc=pdf/benefit.pdf",true);
		xr.send();
	}
}

function showEconomic(b){
	var def=document.getElementById("default");
	var mind=document.getElementById("mindMap");
	if(window.XMLHttpRequest){
		var xr=new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		var xr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xr){
		xr.onreadystatechange=function(){
			if(xr.readyState==4&&xr.status==200){
				var msg=xr.responseText;
				mind.innerHTML="<span style='font-size:20px;color:#2323ba;'>You're in the "+b+" domain.</span><embed src='pdf/economic.pdf' width='360' height='340' />";
				def.innerHTML=msg;
				$("document").ready(function(){
					$("#default").slideDown(3000);
					$("#mindMap").show(3000);
				});
			}
		}
		xr.open("GET","usage.php?tit=Economic Effect of Biomass&doc=pdf/economic.pdf",true);
		xr.send();
	}
}

function showEnvironment(b){
	var def=document.getElementById("default");
	var mind=document.getElementById("mindMap");
	if(window.XMLHttpRequest){
		var xr=new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		var xr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xr){
		xr.onreadystatechange=function(){
			if(xr.readyState==4&&xr.status==200){
				var msg=xr.responseText;
				mind.innerHTML="<span style='font-size:20px;color:#2323ba;'>You're in the "+b+" domain.</span><embed src='pdf/environment.pdf' width='360' height='340' />";
				def.innerHTML=msg;
				$("document").ready(function(){
					$("#default").slideDown(3000);
					$("#mindMap").show(3000);
				});
			}
		}
		xr.open("GET","usage.php?tit=Environment Effect&doc=pdf/environment.pdf",true);
		xr.send();
	}
}

function history(){
	var def=document.getElementById("default");
	if(window.XMLHttpRequest){
		var xr=new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		var xr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xr){
		xr.onreadystatechange=function(){
			if(xr.readyState==4&&xr.status==200){
				var msg=xr.responseText;
				def.innerHTML=msg
				$("document").ready(function(){
					$("#default").show(3000);
				});
			}
		}
		xr.open("GET","history.php",true);
		xr.send();
	}
}