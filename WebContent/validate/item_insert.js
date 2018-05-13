$(function(){
    $("#insertForm").validate({
        debug:true,
        submitHandler:function(form){
            form.submit(); // 表示采用手工提交
        },
        rules:{
            
            name:{
                required:true
            },
            note:{
                required:true,
                rangelength:[3,100]
            }
        }
    })
});