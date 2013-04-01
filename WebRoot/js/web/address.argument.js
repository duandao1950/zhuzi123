var formInput = new Array("id","name","sexLabel","mobile","email","qq","company","address","postcode","filepathPreview","updateDate","bbs","bbsqq");
var formHiddenInput = new Array("sex","filepath");
var formExpandInput = {operator:"id",dowloadTips:"filepath",dowloadFileName:"filepathPreview"};
var url_action = {url_list:"address_list_ajax",url_insert:"address_insert_ajax.action",
                  url_del:"address_delete_ajax.action",url_edit:"address_edit_ajax.action",
                  url_dowload:"address_dowload_ajax.action"};

jQuery.GetHtmlPlugin = {
//jquery.bigpage.js在此处接收参数
returnHTMLObject:function(cellVaues){
    var trStr = "";
    //var formInput = new Array("id","name","sexLabel","mobile","email","qq","company","address","postcode","filepathPreview","updateDate","bbs","bbsqq");
    //var formHiddenInput = new Array("sex","filepath");
    //var formExpandInput = {operator:"id",dowloadTips:"filepath",dowloadFileName:"filepathPreview"};
	if(cellVaues.length==1){
		return "1";
	}
    
    for(var j=0;j<cellVaues.length;j++){
	    trStr += "<tr>";
	    tdStr = "";
	    for (var i = 0; i< formInput.length; i++){
	        if (formInput[i] == formExpandInput.dowloadFileName){
	            if (isNull(cellVaues[j][formInput[i]])){
	            	trStr += " <td> &nbsp;</td>";
	            }else{
	        		trStr += " <td>&nbsp;"+isNullToString(cellVaues[j][formInput[i]]);
	        		trStr += " <a id='info_"+j+"' href=javascript:downLoadFile('"+this.isNullToString(cellVaues[j][formInput[i]])+"'); onMouseOver=showTipDiv("+j+");>下载";
	        		trStr += " <ul style='display:none;position:absolute;border:#ccc 1px solid;width:80px; padding:5px; line-height:20px; background:#f1f1f1; margin:-1px 0 0 0;'>";
	        		trStr += " <li style='border-bottom:#ccc 1px dashed;'>"+this.isNullToString(cellVaues[j][formExpandInput.dowloadTips])+"</li>";
	        		trStr += " </ul>";
	        		trStr += " </a>";
	        		trStr += "  &nbsp;</td>";
	        	}
	        }else{
				trStr += "<td>&nbsp; " + isNullToString(cellVaues[j][formInput[i]]) + " &nbsp;</td>";
			}
			tdStr += "<TD></TD>";
		}

		for (var i = 0; i< formHiddenInput.length; i++){
			trStr += "<td style='display: none'>&nbsp; " + isNullToString(cellVaues[j][formHiddenInput[i]]) + " &nbsp;</td>";
		}

		trStr += "<td>"
		trStr += "<img src='images/icons/edit.gif' style='cursor: hand;' alt='Edit' onclick='editAjax("+cellVaues[j][formExpandInput.operator]+");'>"
		trStr += "<img src='images/icons/delete.gif' style='cursor: hand;' alt='Delete' onclick='deleteAjax("+cellVaues[j][formExpandInput.operator]+");'>"
		trStr += "</td>"
		trStr += "</tr>";
		trStr += "<TR class='listtablebody'>";
		trStr += tdStr;
		trStr += "</TR>"
    }

	return trStr;
},
foo:function() {        
alert('This is a test. This is only a test.');        
},        
bar:function(param) {        
alert('This function takes a parameter, which is "' + param + '".');  
}
};
