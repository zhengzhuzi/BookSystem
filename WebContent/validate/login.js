$(function(){
	
	$("#loginForm").validate({
		
		debug:true,
		submitHandler:function(form)
		{
			form.submit();	
		},
		rules:{
			aid:{
				required:true
			},
			password:{
				 required:true,
				 rangelength:[4,12],
				 
			}
			
		}
	
	})
	
		
})