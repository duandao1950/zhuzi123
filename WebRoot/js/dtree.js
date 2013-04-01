
function Node(id, pid, name, url, title, target, icon, iconOpen, open) {

	this.id = id;

	this.pid = pid;

	this.name = name;

	this.url = url;

	this.title = title;

	this.target = target;

	this.icon = icon;

	this.iconOpen = iconOpen;

	this._io = open || false;

	this._is = false;

	this._ls = false;

	this._hc = false;

	this._ai = 0;

	this._p;

};


function dTree(objName) {

	this.config = {

		target					: 'main',

		folderLinks				: true,

		useSelection			: true,

		useCookies				: true,

		useLines				: true,

		useIcons				: true,

		useStatusText			: true,

		closeSameLevel			: false,

		inOrder					: true

	}

	this.icon = {

		root				: '/EMG/images/common/folder.png',

		folder				: '/EMG/images/common/folder.png',

		folderOpen			: '/EMG/images/common/openfolder.png',

		node				: '/EMG/images/common/file.png',

		empty				: '/EMG/images/common/empty.gif',

		line				: '/EMG/images/common/I.png',

		join				: '/EMG/images/common/T.png',

		joinBottom			: '/EMG/images/common/L.png',

		plus				: '/EMG/images/common/Tplus.png',

		plusBottom			: '/EMG/images/common/Lplus.png',

		minus				: '/EMG/images/common/Tminus.png',

		minusBottom			: '/EMG/images/common/Lminus.png',

		nlPlus				: '/EMG/img/nolines_plus.gif',

		nlMinus				: '/EMG/img/nolines_minus.gif'

	};

	this.obj = objName;

	this.aNodes = [];

	this.aIndent = [];

	this.root = new Node(-1);

	this.selectedNode = null;

	this.selectedFound = false;

	this.completed = false;

};



dTree.prototype.add = function(idF, p_id, nameF, urlF, titleF, targetF, iconF, icon_Open, openF) {

	this.aNodes[this.aNodes.length] = new Node(idF, p_id, nameF, urlF, titleF, targetF, iconF, icon_Open, openF);

};


dTree.prototype.openAll = function() {
	var tmpTrue = true;
	this.oAll(tmpTrue);
};

dTree.prototype.closeAll = function() {
	var tmpFalse= false;
	this.oAll(tmpFalse);
};


dTree.prototype.toString = function() {

  var strr = '<table border="0" width="100%" cellspacing="0" cellpadding="0" height="100%">\n';
  	strr = strr + '<tr valign="top">\n';
  	strr = strr + '<td nowrap>\n';
	strr = strr + '<div class="dtree">\n';

	if (!document.getElementById) {
	
		strr += 'Browser not supported.';

	} else {

		if (this.config.useCookies)
		{
		 	this.selectedNode = this.getSelected();
		}
		strr += this.addNode(this.root);
	}

	strr = strr + '</div>';
	strr = strr + '</td>\n';
	strr = strr + '</tr>\n';
	strr = strr + '</table>\n';

	if (!this.selectedFound) {
		this.selectedNode = null;
	}

	this.completed = true;

	return strr;

};


dTree.prototype.addNode = function(pNodeF) {

	var idx=0;
	var strr = '';

	if (this.config.inOrder) idx = pNodeF._ai;

	for (idx; idx<this.aNodes.length; idx++) {

		if (pNodeF.id == this.aNodes[idx].pid) {

			var cnod = this.aNodes[idx];

			cnod._p = pNodeF;

			cnod._ai = idx;

			this.setCS(cnod);

			if (!cnod.target && this.config.target) {
				cnod.target = this.config.target;
			}

			if (cnod._hc && !cnod._io && this.config.useCookies) {
				cnod._io = this.isOpen(cnod.id);
			}

			if (!this.config.folderLinks && cnod._hc) {
				cnod.url = null;
			}

			if (this.config.useSelection) {
				if (cnod.id == this.selectedNode)
				{
					if (!this.selectedFound)
					{
						cnod._is = true;
						this.selectedFound = true;
						this.selectedNode = idx;
					}
				}	
			}

			strr = strr + this.node(cnod, idx);

			if (cnod._ls) break;

		}

	}

	return strr;

};


dTree.prototype.node = function(node, nodeId) {

	var strHt = '<div class="dTreeNode">' + this.indent(node, nodeId);

	if (this.config.useIcons) {

		if (!node.icon) 
		{
			node.icon = (this.root.id == node.pid) ? this.icon.root : ((node._hc) ? this.icon.folder : this.icon.node);
		}

		if (!node.iconOpen) node.iconOpen = (node._hc) ? this.icon.folderOpen : this.icon.node;

//		if (this.root.id == node.pid) {
//
//			node.icon = this.icon.root;
//
//			node.iconOpen = this.icon.root;
//
//		}

		strHt += '<img id="i' + this.obj + nodeId + '" src="' + ((node._io) ? node.iconOpen : node.icon) + '" alt="" />';

	}

	if (node.url) {

		strHt = strHt + '<a id="s' + this.obj + nodeId + '" class="' + ((this.config.useSelection) ? ((node._is ? 'nodeSel' : 'node')) : 'node') + '" href="' + node.url + '"' + "style=' color:000099;'";

		if (node.title)
		{
		 	strHt = strHt + ' title="' + node.title + '"';
		}

		if (node.target)
		{
		 	strHt = strHt + ' target="';
		 	strHt = strHt + node.target + '"';
		}

		if (this.config.useStatusText)
		{
		 	strHt = strHt + ' onmouseout="window.status=\'\';return true;"  onmouseover="window.status=\'' + node.name + '\';return true;" ';
		}

		if (this.config.useSelection)
		{
			if (((this.config.folderLinks && node._hc) || !node._hc))
			{
				strHt = strHt + ' onclick="javascript: ' + this.obj + '.s(' + nodeId + ');"';
			}
		}

		strHt = strHt + '>';

	}

	else if (!this.config.folderLinks || !node.url) {
		if (node._hc && node.pid != this.root.id)
		{
			strHt += '<a href="javascript: ' + this.obj + '.o(' + nodeId + ');" class="node" style="color:000099;">';
		}
	}

	strHt += node.name;

	if (node.url || ((!this.config.folderLinks || !node.url) && node._hc)) 
	{
		strHt = strHt + '</a>';
	}

	strHt = strHt + '</div>';

	if (node._hc) {

		strHt = strHt + '<div id="d' + this.obj + nodeId + '" class="clip" style="display:' + ((this.root.id == node.pid || node._io) ? 'block' : 'none') + ';">';

		strHt = strHt + this.addNode(node);

		strHt = strHt + '</div>';

	}
	this.aIndent.pop();

	return strHt;

};



dTree.prototype.indent = function(node, nodeId) {

	var strHt = '';

	if (this.root.id != node.pid) {

		for (var n=0; n<this.aIndent.length; n++)
		{
			strHt += '<img src="' + ( (this.aIndent[n] == 1 && this.config.useLines) ? this.icon.line : this.icon.empty ) + '" alt="" />';
		}

		(node._ls) ? this.aIndent.push(0) : this.aIndent.push(1);

		if (node._hc) {

			strHt += '<a href="javascript: ' + this.obj + '.o(' + nodeId + ');"><img id="j' + this.obj + nodeId + '" src="';

			if (this.config.useLines) {
				strHt += ( (node._io) ? ((node._ls && this.config.useLines) ? this.icon.minusBottom : this.icon.minus) : ((node._ls && this.config.useLines) ? this.icon.plusBottom : this.icon.plus ) );
			} else {
				strHt += (node._io) ? this.icon.nlMinus : this.icon.nlPlus;
			}

			strHt += '" alt="" /></a>';

		} else {
			strHt += '<img src="' + ( (this.config.useLines) ? ((node._ls) ? this.icon.joinBottom : this.icon.join ) : this.icon.empty) + '" alt="" />';
		}

	}

	return strHt;

};


dTree.prototype.setCS = function(node) {

	var lastIdNo;

	for (var idx=0; idx<this.aNodes.length; idx++) {

		if (node.id == this.aNodes[idx].pid)
		{
			node._hc = true;
		}

		if (node.pid == this.aNodes[idx].pid)
		{
		 	lastIdNo = this.aNodes[idx].id;
		}

	}

	if (node.id == lastIdNo)
	{
		node._ls = true;
	}

};


dTree.prototype.getSelected = function() {

	var sn = this.getCookie('cs' + this.obj);

	return (sn) ? sn : null;

};


dTree.prototype.s = function(id) {

	if (!this.config.useSelection) return;

	var cnod = this.aNodes[id];

	if (cnod._hc && !this.config.folderLinks) return;

	if (id != this.selectedNode) {

		if (this.selectedNode || this.selectedNode==0) {

			eOld = document.getElementById("s" + this.obj + this.selectedNode);

			if(eOld != null)
			{
				eOld.className = "node";
			}

		}

		eNew = document.getElementById("s" + this.obj + id);

		eNew.className = "nodeSel";

		this.selectedNode = id;

		if (this.config.useCookies) 
		{
			this.setCookie('cs' + this.obj, cnod.id);
		}

	}

};


dTree.prototype.o = function(id) {

	var cnod = this.aNodes[id];

	this.nodeStatus(!cnod._io, id, cnod._ls);

	cnod._io = !cnod._io;

	if (this.config.closeSameLevel) 
	{
		this.closeLevel(cnod);
	}

	if (this.config.useCookies) 
	{
		this.updateCookie();
	}

};

dTree.prototype.oAll = function(statusF) {

	for (var idx=0; idx<this.aNodes.length; idx++) {

		if (this.aNodes[idx]._hc) {
			if (this.root.id != this.aNodes[idx].pid)
			{
				this.nodeStatus(statusF, idx, this.aNodes[idx]._ls)
	
				this.aNodes[idx]._io = statusF;
			}
		}
	}

	if (this.config.useCookies) this.updateCookie();

};


dTree.prototype.openTo = function(nId, bSelect, bFirst) {

	if (!bFirst) {
		for (var idx=0; idx<this.aNodes.length; idx++) {

			if (this.aNodes[idx].id == nId) {

				nId=idx;

				break;
			}
		}
	}

	var cnod=this.aNodes[nId];

	if (cnod.pid==this.root.id || !cnod._p) return;

	cnod._io = true;

	cnod._is = bSelect;

	if (this.completed && cnod._hc) this.nodeStatus(true, cnod._ai, cnod._ls);

	if (this.completed && bSelect) 
	{
		this.s(cnod._ai);
	} 
	else if (bSelect)
	{
		this._sn=cnod._ai;
	}

	this.openTo(cnod._p._ai, false, true);

};



dTree.prototype.closeLevel = function(node) {

	for (var idx=0; idx<this.aNodes.length; idx++) {

		if (this.aNodes[idx].pid == node.pid) {
			if (this.aNodes[idx].id != node.id)
			{
				if (this.aNodes[idx]._hc)
				{
					this.nodeStatus(false, idx, this.aNodes[idx]._ls);
					this.aNodes[idx]._io = false;
					this.closeAllChildren(this.aNodes[idx]);
				}
			}
		}
	}

}

dTree.prototype.closeAllChildren = function(node) {

	for (var idx=0; idx<this.aNodes.length; idx++) {

		if (node.id == this.aNodes[idx].pid) {
			if (this.aNodes[idx]._hc)
			{
				if (this.aNodes[idx]._io) this.nodeStatus(false, idx, this.aNodes[idx]._ls);
	
				this.aNodes[idx]._io = false;
	
				this.closeAllChildren(this.aNodes[idx]);
			}

		}
	}
}


dTree.prototype.nodeStatus = function(status, idx, bottom) {

	eDiv	= document.getElementById('d' + this.obj + idx);

	eJoin	= document.getElementById('j' + this.obj + idx);

	if (this.config.useIcons) {

		eIcon	= document.getElementById('i' + this.obj + idx);

		eIcon.src = (status) ? this.aNodes[idx].iconOpen : this.aNodes[idx].icon;

	}

	eJoin.src = (this.config.useLines)?

	((status)?((bottom)?this.icon.minusBottom:this.icon.minus):((bottom)?this.icon.plusBottom:this.icon.plus)):

	((status)?this.icon.nlMinus:this.icon.nlPlus);

	eDiv.style.display = (status) ? 'block': 'none';

};


dTree.prototype.clearCookie = function() {

	var now = new Date();

	var yday = new Date(now.getTime() - 1000 * 60 * 60 * 24);

	this.setCookie('co'+this.obj, 'cookieValue', yday);

	this.setCookie('cs'+this.obj, 'cookieValue', yday);

};


dTree.prototype.setCookie = function(coName, coValue, exps, path, dom, sece) {

	document.cookie =

		escape(coName) + '=' + escape(coValue)

		+ (exps ? '; expires=' + exps.toGMTString() : '')

		+ (path ? '; path=' + path : '')

		+ (dom ? '; domain=' + dom : '')

		+ (sece ? '; secure' : '');

};



dTree.prototype.getCookie = function(cookName) {

	var cookValue = '';

	var posiName = document.cookie.indexOf(escape(cookName) + '=');

	if (posiName != -1) {

		var posiValue = posiName + (escape(cookName) + '=').length;

		var endPosi = document.cookie.indexOf(';', posiValue);

		if (endPosi == -1)
		{
			cookValue = unescape(document.cookie.substring(posiValue));
		} else {
		 	cookValue = unescape(document.cookie.substring(posiValue, endPosi));
		}

	}

	return (cookValue);

};


dTree.prototype.updateCookie = function() {

	var strFl = '';

	for (var idx=0; idx<this.aNodes.length; idx++) {

		if (this.aNodes[idx]._io) {
			if (this.aNodes[idx].pid != this.root.id)
			{
				if (strFl) strFl += '.';
	
				strFl += this.aNodes[idx].id;
			}
		}
	}

	this.setCookie('co' + this.obj, strFl);

};

dTree.prototype.isOpen = function(id) {

	var aOp = this.getCookie('co' + this.obj).split('.');

	for (var idx=0; idx<aOp.length; idx++)

		if (aOp[idx] == id) return true;

	return false;

};


if (!Array.prototype.push) {

	Array.prototype.push = function array_push() {

		for(var idx =0;idx<arguments.length;idx++)

			this[this.length]=arguments[idx];

		return this.length;

	}

};

if (!Array.prototype.pop) {

	Array.prototype.pop = function array_pop() {

		lastElement = this[this.length-1];

		this.length = Math.max(this.length-1,0);

		return lastElement;

	}

};
