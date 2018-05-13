
function deal() {
	//alert("1");
	var someValue;
	someValue=window.showModalDialog("pages/back/ImageList.jsp","","dialogWidth=300px;dialogHeight=300px");
	//alert(someValue);
	document.img.src="assets/img/"+someValue+".jpg";
	
}
$(document).ready(function() {
	
})
$(document).ready(function(){
    	 //alert("11");
    	 var text=$(".text");
         //.fadeOut(3000)
         text.animate({
        	        left:'600px', 
        		 });
         text.animate({fontSize:'2em'});
	
 });


/*.css("color","black")
.fadeIn(3000)
.fadeOut(3000)
.fadeIn(3000)*/