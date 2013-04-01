var formInput = new Array("id","name","sexLabel","mobile","email","qq","company","address","postcode","filepathPreview","updateDate","bbs","bbsqq");
var formHiddenInput = new Array("sex","filepath");
var formExpandInput = {operator:"id",dowloadTips:"filepath",dowloadFileName:"filepathPreview"};
var url_action = {url_list:"address_list_ajax",url_insert:"address_insert_ajax.action",
                  url_del:"address_delete_ajax.action",url_edit:"address_edit_ajax.action",
                  url_dowload:"address_dowload_ajax.action"};

$(function() {
		//传入table id的值,其他为固定值
		var tableID = "#tableAddress";
		//初始化加载表
		//loadGrid(tableID);
		
		//alert("bigPage:1"+$("#tableAddress").bigPage);
	    if (isNull($("#tableAddress").bigPage)){
	    	alert("无法给表格加载数据,请定义需要绑定数据的表格 !");
	    	return;
	    }
	   // alert("bigPage:2"+url_action);
	    try{
	    	if (!isObject(url_action)){
				alert("未指定url_action,否则页面无法正常加载!");
				return;
			}
	    }catch(e){
	    	alert("未定义url_action,页面无法正常加载!");
			return;
	    }
	    //alert("bigPage:3"+url_action.url_list);
		if (isNull(url_action.url_list)){
			alert("未指定url_list,否则页面无法正常加载!");
			return;
		}
		//$("#tableAddress").bigPage.trigger("update",{ajaxData:{url:url_action.url_list,curentPageKey:"",params:{keyword:""},batch:true}});
		
	   //$("#dialog:ui-dialog").dialog("destroy");
		/*
		var id = $("#id"),
		    name = $("#name"),
			sex = $("#sex"),
			mobile = $("#mobile"),
			email = $("#email"),
			qq = $("#qq"),
			company = $("#company"),
			address = $("#address"),
			postcode = $("#postcode"),
			updateDate = $("#updateDate"),
			allFields = $([]).add(name).add(sex).add(mobile).add(qq).add(company).add(address).add(postcode).add(updateDate),
			tips = $(".validateTips");
		
		function updateTips( t ) {
			tips.text( t ).addClass("ui-state-highlight");
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
				o.addClass( "ui-state-error" );
				updateTips( n );
				return false;
			} else {
				return true;
			}
		}

		$('#dialog-form').dialog({
			autoOpen: false,
			height: '100%',
			width: '60%',
			modal: false,
			buttons: {
				"提交": function() {
					var bValid = true;
					allFields.removeClass("ui-state-error");

					bValid = bValid && checkLength( name, "username", 3, 16 );
					bValid = bValid && checkLength( email, "email", 6, 80 );
					//bValid = bValid && checkLength( password, "password", 5, 16 );

					bValid = bValid && checkRegexp( name, /^[a-z]([0-9a-z_])+$/i, "Username may consist of a-z, 0-9, underscores, begin with a letter." );
					// From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
					bValid = bValid && checkRegexp( email, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i, "eg. ui@jquery.com" );
					//bValid = bValid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );
					alert($('#addressForm').formSerialize());
					if ( bValid ) {  
			       		$.ajax({  
						    url : url_action.url_insert,
						    type: 'post',
						    dataType: 'text',
						    data: $('#addressForm').formSerialize(),
						    success:function(text){
						    	if (text == 'success'){
							    	//加载表格,此处区分于默认的表格加载,需要传递当前页,以定位用户当前的编辑操作
                   					bigPage.trigger("update",{ajaxData:{url:url_action.url_list,curentPageKey:$("#curentPageKey").val(),params:{keyword:""},batch:true}});
						    		//$(':input','#addressForm').not(':button, :submit, :reset, :hidden').val('').removeAttr('checked').removeAttr('selected');
						    		//$('#addressForm')[0].reset();
						    	}else{
						    		alert(text.substring(10000));
						    		$("#error").html(text);	
						    		return false;
						    	}
						    }
						});

						$( this ).dialog("close");
					}
				},
				"取消": function() {
					$( this ).dialog("close");
				}
			},
			close: function() {
				allFields.val("").removeClass("ui-state-error");
			}
	   });

	   $("#create-dialog").click(function() {
			//clearInput();
			$('#addressForm')[0].reset();
			$("#dialog-form").dialog("open");
	   });

	   $("#updateDate").datepicker({
			showOn: "button",
			buttonImage: "images/calendar.gif",
			buttonImageOnly: true
	   });*/
});
