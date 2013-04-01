$(function() {
	$('#Tip').hide();
	$('#articleForm').submit(function(){
        var options={
            target:'#Tip', //后台将把传递过来的值赋给该元素
	        url:'article_insert.action', //提交给哪个执行
	        type:'POST', 
	        success: function(){
          	 alert($('#Tip').text());
            }//显示操作提示
         }; 
         $('#articleForm').ajaxSubmit(options);
         return false; //为了不刷新页面,返回false
	});
});