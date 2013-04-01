var formInput = new Array("id","styleId","title","authorId","content","contentExt","createTime");
var formExpandInput = {operator:"id"};
var url_action = {url_list:"article_list.action",url_edit:"article_edit.action",
		url_save_or_update:"article_saveOrUpdate.action",
        url_del:"article_delete.action"};

function setInputValue(text){
	var jsonObject = this.toJSON(text);
   	if (this.isNull(jsonObject)){
   	    alert("数据为空,无法为表格赋值!");
   	    return;
   	}

	for (var i = 0; i< formInput.length; i++){
	    if (!this.isNull(document.getElementById(formInput[i]))){
	    	document.getElementById(formInput[i]).value = this.isNullToString(jsonObject[formInput[i]]);
	    }
	}
}

function editAjax(id){
    if (!confirm("请确认是否进行修改!")){
    	return;
    }
	$.ajax({
	    url : url_action.url_edit,  //后台处理程序      
	    type:'post',    //数据发送方式      
	    dataType:'text',   //接受数据格式      
	    data : {
	        id : id
	    },//要传递的数据；就是上面序列化的值      
	    success:function(text){
	    	$("#dialog-form").dialog("open");
	    	if (text != null){
	    	    //填充属性
		    	setInputValue(text);
	    	}
	    }
	});
}

function deleteAjax(id){
    if (!confirm("请确认是否进行删除!")){
    	return;
    }
 	$.ajax({ 
      url: url_action.url_del, 
      type:'post', //数据发送方式 
      dataType:'text', //接受数据格式 
      data : {
  		id : id
	  },
      cache: false, 
      error:function(){
          alert( "not lived!");
      },
      success: function(text){
           $("#tr_oper_"+id).hide();
          //$("."+id+"A"+" .delete").parents("."+id+"A").animate({ opacity: 'hide' }, "slow");
      }
    });
}

$(function() {
    $('#Tip').hide();
    var nowDate = new Date();
	var id = $("#id"),
	    styleId = $("#styleId"),
		title = $("#title"),
		authorId = $("#authorId"),
		content = $("#content"),
		contentExt = $("#contentExt"),
		createTime = $("#createTime"),
		allFields = $([]).add(id).add(styleId).add(title).add(authorId).add(content).add(contentExt).add(createTime),
		tips = $(".validateTips");

	function updateTips( t ) {
		tips.text(t).addClass("ui-state-highlight");
		setTimeout(function() {
			tips.removeClass("ui-state-highlight", 1500);
		}, 500 );
	}

	function checkLength( o, n, min, max ) {
		if ( o.val().length > max || o.val().length < min ) {
			o.addClass("ui-state-error");
			updateTips( "Length of " + n + " must be between " +
				min + " and " + max + "." );
			return false;
		} else {
			return true;
		}
	}

	function checkRegexp( o, regexp, n ) {
		if ( !( regexp.test( o.val() ) ) ) {
			o.addClass("ui-state-error");
			updateTips(n);
			return false;
		} else {
			return true;
		}
	}
	
	function isNull(obj){
		if(obj == null || $.trim(obj) == "" || typeof(obj) == "undefined"){
			return true;
		}
		return false;
	}

	function search(){
		$.ajax({type: "POST",url: url_action.url_list,data:"",dataType:"json",
             "success": function(result){
            if(result.data == null){
                 return;
            }
            
            var article_list_table = $("#article_list tbody");
            article_list_table.empty();
		    var cellVaues = eval('(' + result.data + ')');
			var trStr = "";
		    
			if(cellVaues.length==1){
				article_list_table.append("no data!");
			}
		    
		    for(var j=0;j<cellVaues.length;j++){
		    	var tmp_operator_id = cellVaues[j][formExpandInput.operator];
			    trStr += "<tr id=tr_oper_"+tmp_operator_id+">";
			    for (var i = 0; i< formInput.length; i++){
			    	var tmp_text = cellVaues[j][formInput[i]];
			        if(formInput[i]=="id"){
			        	trStr += "<input type='text' id='id' value='"+tmp_operator_id+"'/>";
			        }else if(formInput[i]=="createTime"){
						trStr += "<td id=td_oper_"+tmp_operator_id+"_"+formInput[i]+" width='18%'>" + tmp_text + "</td>";
					}else{
						trStr += "<td id=td_oper_"+tmp_operator_id+"_"+formInput[i]+">" + tmp_text + "</td>";
					}
				}
				trStr += "<td>"
				trStr += "<img src='images/icons/edit.gif' style='cursor: hand;' alt='Edit' onclick='editAjax("+tmp_operator_id+");'>"
				trStr += "<img src='images/icons/delete.gif' style='cursor: hand;' alt='Delete' onclick='deleteAjax("+tmp_operator_id+");'>"
				trStr += "</td>"
				trStr += "</tr>";
		    }
		    article_list_table.append(trStr);
           }
      });
	}
	
	$("#dialog-form").dialog({
		autoOpen: false,
		height: 420,
		width: 500,
		modal: false,
		buttons: {
			"New or Edit a article": function() {
				var bValid = true;
				allFields.removeClass("ui-state-error");
				
				//bValid = bValid && checkLength( name, "username", 3, 16 );
				//bValid = bValid && checkLength( email, "email", 6, 80 );
				//bValid = bValid && checkLength( password, "password", 5, 16 );

				//bValid = bValid && checkRegexp( name, /^[a-z]([0-9a-z_])+$/i, "Username may consist of a-z, 0-9, underscores, begin with a letter." );
				// From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
				//bValid = bValid && checkRegexp( email, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i, "eg. ui@jquery.com" );
				//bValid = bValid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );
				
				var operId = id.val();
				if (bValid) {
					var options={
			            target:'#Tip', //后台将把传递过来的值赋给该元素
				        url: url_action.url_save_or_update, //提交给哪个执行
				        type:'POST', 
				        data : {
					  		id : id.val()
						},
						beforeSend: function(XMLHttpRequest){
						    //预先缓存新值,如果操作成功更新td
							for (var i = 0; i< formInput.length; i++){
		          	    	    $("#td_oper_"+operId+"_"+formInput[i]).data("#new_value",$("#"+formInput[i]).val());
						    }
						},
						error: function(XMLHttpRequest, textStatus, errorThrown) {
	                        //alert(XMLHttpRequest.status);
	                        //alert(XMLHttpRequest.readyState);
	                        alert(textStatus);
	                    },
				        success: function(data){
			          	    if(isNull(operId)){
			          	       search();
			          	    }else{
			          	    	for (var i = 0; i< formInput.length; i++){
		                        	var newValue = $("#td_oper_"+operId+"_"+formInput[i]).data("#new_value");
		                        	$("#td_oper_"+operId+"_"+formInput[i]).text(newValue);
	                        	}
			          	    }
			            },//显示操作提示
			            //完成后你要干什麼，和成功后的区别是：不管成不成功都会到这个阶段。
					    complete: function(XMLHttpRequest, textStatus){
					   		//if(textStatus == "success"){
					   		//	alert("1");
					   		//}
			            	jQuery.removeData(this);
					    }
			         };
			        $('#articleForm').ajaxSubmit(options);
				    $(this).dialog("close");
				}
			},
			Cancel: function() {
				$(this).dialog("close");
			}
		},
		close: function() {
			allFields.val("").removeClass("ui-state-error");
		}
	});

	$("#create-article").button().click(function() {
		$("#dialog-form").dialog("open");
	});
	
	$("#searchBn").button().click(function() {
		search();
	});
});