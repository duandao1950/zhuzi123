/**
 * jquery插件
 * 实现功能：
 * 公共校验
 */

this.escapeHtml = function (str) { 	
	if(this.isNull(str)){
		return   "";
	} 
	return str.replace(/\'/g,'&acute;').replace(/\"/g,'&quot;');
}

this.isNull = function (obj){
	if(obj == null || $.trim(obj) == "" || typeof(obj) == "undefined"){
		return true;
	}
	return false;
}

this.isNullToString = function (obj){
	if(obj == null || $.trim(obj) == "" || typeof(obj) == "undefined"){
		return " ";
	}
	return obj;
}

this.isArray = function (obj){
	if(Object.prototype.toString.call(obj) == "[object Array]"){
		return true;
	}
	return false;
}
this.isObject = function (obj){
	if(Object.prototype.toString.call(obj) == "[object Object]"){
		return true;
	}
	return false;
}

this.toJSON = function (text) {
    try {
   		return eval('(' + text + ')');
    } catch (e) {
   		return false;
    }
}
