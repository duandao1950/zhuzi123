function findRolePrivilegesList(){
	var pList= document.getElementsByName("privilegeList");
	if (pList != null){
	 	for (var i=0; i<pList.length; i++){
	 		if (pList[i].checked){
	 			baseSpringBo.getPartPrivilegesByParentId('TR_0_1',rolePrivilegesReturn);
	 		}
	 	}
 	}
}

//callback
function rolePrivilegesReturn(data) {
	var pList= document.getElementsByName("privilegeList");
	var selectedValue;
	var arrayObj = new Array();
	if (pList != null){
		for (var n=0; n<pList.length; n++){
			if (pList[n].checked){
				selectedValue = pList[n].value;
				arrayObj.push(pList[n].value);
			}
		}
	}
	
	var parentValue;	
    for(var pIndex in data){
    	if(data[pIndex].privilegeLevel == 0){
    	    parentValue = data[pIndex].privilegeId;
    	}
	}
	
	if (pList != null){
	    if (arrayObj.length == 1){
	    	for (var m=0; m<pList.length; m++){
				if (selectedValue == parentValue){
					for(var pIndex1 in data){
	    				if(data[pIndex1].privilegeLevel !=0){
	    				    if (pList[m].value == data[pIndex1].privilegeId){
	    				    	pList[m].checked = true;
	    				    }
	    				}
	    			}
				}
			}
	    }else{
	    	for(var k=0;k<arrayObj.length;k++){
				for(var pIndex2 in data){
    				if(data[pIndex2].privilegeLevel == 0){
    				   if (arrayObj[k] == data[pIndex2].privilegeId){
    				   	  alert(arrayObj[k]);
    				   	  for (var m=0; m<pList.length; m++){
    				   	  	pList[m].checked = false;
    				   	  }
    				   	  break;
    				   }
    				}
    			}
			}
	    }
	}
}