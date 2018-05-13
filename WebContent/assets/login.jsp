<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
 <HEAD>
  <TITLE> New Document </TITLE>
  <META NAME="Generator" CONTENT="EditPlus">
  <META NAME="Author" CONTENT="">
  <META NAME="Keywords" CONTENT="">
  <META NAME="Description" CONTENT="">
  <style>
  /*Twitter @locoalien*/
/*Sitio web www.locoaliensoft.com*/
/*www.facebook.com/CulturaInformatica*/




		* {margin: 0; padding: 0;}
		canvas {display: block;}
		body {background: black;}
  </style>
 </HEAD>


 <BODY>
 <html>
<head>
	<title>Hacking locoalien Matrix console</title>
	<meta charset="UTF-8">
</head>
<body>
<canvas id="locoalien">
<form action="form_action.asp" method="get">
  <p>First name: <input type="text" name="fname" /></p>
  <p>Last name: <input type="text" name="lname" /></p>
  <input type="submit" value="Submit" />
</form>
</canvas>

<script type="text/javascript">
	</script>
</body>
</html>
  <script>
  //*--------------------------------------*
//* Desarrollado por Locoalien           *
//* Twitter @locoalien                   *
//* Sitio web: www.locoaliensoft.com     *
//*--------------------------------------*


//+++++++++++++++++++++++++++++++++++++
// El objetivo de este ejemplo es aprender a dar animacion y utilizar las propiedades
// Mas comunes de JavaScript. Veremos el poder que tiene HTML5 implementando el Canvas
// Espero les guste este ejemplo
// Para mas informacion visitar nuestra pagina de Facebook: https://www.facebook.com/CulturaInformatica
//+++++++++++++++++++++++++++++++++++++








window.onload = hacking;//Llamamos a la funcion despues de que el documento ha sido cargado completamente
function hacking(){
	var c = document.getElementById("locoalien");
	c.height = window.innerHeight;  //innerHeight se utiliza para saber la altura de la pantalla
	c.width = window.innerWidth;    //innerHeight se utiliza para saber la altura de la pantalla


	
	var letraTam=12; //Tamaño de la letras por pixel
	var columnas=c.width/letraTam; //El ancho dividido por el tamano que tendra las letras
	


	var Texto="0"; //El testo que aparecera en pantalla
	Texto=Texto.split("");//La función split() permite dividir una cadena de caracteres (string) en varios bloques y crear un array con estos
	var Texto2="1";
	Texto2=Texto2.split("");


	var letras=[];
	for(var i=0; i<columnas;i++){
		letras[i]=1;//Siver para saber la cantidad de letras que tendra en la pantalla
	}
	contexto= c.getContext('2d');//Muy importante especificar el contexto en el cual vamos a trabajar


	function dibujar(){
		contexto.fillStyle="rgba(0,0,0,0.05)";//Damos el color que tendra el recuadro en el que estara la animacion. en este caso sera transparente 0.05
		contexto.fillRect(0,0,c.width,c.height);//Damos las dimensiones alto y ancho que tendra el cuadrado, que en este caso es de toda la pantalla


		contexto.fillStyle= "#0f0";//Color de las letras
		contexto.font= letraTam+"px arial";//Tamaño de la letra


		for(var i=0;i<letras.length;i++){
			text=Texto; //Le asigno el texto que definimos en la parte de arriba
			//El ciclo for me permite darle las coordenadas correctas para posicionar el text x, y 
			text2=Texto2;//El texto dos que mostrara solo el 1
			if(i%2==1){contexto.fillText(text,i*letraTam, letras[i]*letraTam);//Para imprimir texto disponesmos de fillText(texto,x,y)
			}else{
				contexto.fillText(text2,i*letraTam, letras[i]*letraTam);//Para imprimir texto disponesmos de fillText(texto,x,y)	
			}


			if(letras[i]*letraTam > c.height && Math.random()>0.975){
				letras[i]=0;
			}
			letras[i]++;


		}


	}
	setInterval(dibujar,120);//velocidad a la que se ejecuta la funcion en milisegundos


}
  </script>
 </BODY>
</HTML>