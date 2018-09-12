/** 
  * @see 清除字符串开始和结束位置空格
  * @return 返回清除空格后的字符串
  */
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

function cellNormal(v, m, r, row, col, s) {
	m.attr = 'style="white-space:normal;"';
	return v;
}

function renderRegSource(value, p, record) {
	if(value == "2"){
		return "随手房";
	}else if(value == "" || value == "1"){
		return "租售365";
	}else{
		return value;
	}
}

function renderTypeSystemLog(value, p, record) {
	//return String.format('<b><a href="javascript:isClose=true;void(0);" onclick="dataGrid_dbClick(\'{0}\');isClose=false;">{1}</a></b>', record.data.roomId, record.data.roomNumber);
	if(value == "1"){
		return "登录";
	}else if(value == "2"){
		return "注册";
	}else if(value == "3"){
		return "注销";
	}else{
		return value;
	}
}

function renderIpAddress(value, p, record) {
	//var sURL = "http://www.youdao.com/smartresult-xml/search.s?type=ip&q="+record.data.ip+"";//youdao的URL
	var sURL = "http://www.youdao.com/smartresult-xml/search.s?jsFlag=true&keyfrom=163.com&event=fYodaoCallBack&type=ip&q=" + record.data.ip;
	var location = "";
    /*$.get(sURL, function(xml){
		$(xml).find('smartresult').each(function(index, ele){
			location = $(ele).find('location').text();
			return location;
		});
 	});*/
    
	alert(sURL);
    $.get(sURL, {}, function(data){
    	alert('=====333======='+data);
    });
	
    $.ajax({   
        url:sURL,   
        type: 'GET',   
        dataType: 'html',
        async: false,
        timeout: 1000,   
        error: function(json){
            alert('=====111======='+json);   
        },   
        success: function(json){   
            alert('=====222======='+json);
        	/*$(json).find("smartresult").each(function(i){   
                var location=$(this).children("location").text();
                alert(location);//这里就是ID的值了。   
            });*/   
        }   
    });
    
    /*$.getJSON(sURL, function (data) {  
    	alert(data.ip);  
    }).error(function () {
    	alert("获取IP失败请联网查询"); 
    }) ;*/ 
}

function renderTypeOperateLog(value, p, record) {
	//return String.format('<b><a href="javascript:isClose=true;void(0);" onclick="dataGrid_dbClick(\'{0}\');isClose=false;">{1}</a></b>', record.data.roomId, record.data.roomNumber);
	if(value == "1"){
		return "新增房源";
	}else if(value == "2"){
		return "修改房源";
	}else if(value == "3"){
		return "删除房源";
	}if(value == "4"){
		return "新增客源";
	}else if(value == "5"){
		return "修改客源";
	}else if(value == "6"){
		return "删除客源";
	}else if(value == "7"){
		return "创建群";
	}else if(value == "8"){
		return "修改群公告";
	}else if(value == "9"){
		return "删除群";
	}else if(value == "10"){
		return "群主添加群成员";
	}else if(value == "11"){
		return "群主移除群成员";
	}else if(value == "12"){
		return "群成员退出群";
	}else if(value == "13"){
		return "群分享房源";
	}else if(value == "14"){
		return "群删除房源";
	}else if(value == "15"){
		return "群分享客源";
	}else if(value == "16"){
		return "群删除客源";
	}else if(value == "17"){
		return "群新增留言";
	}else if(value == "18"){
		return "群删除留言";
	}else{
		return value;
	}
}

function renderStype(value, p, record) {
	if(value == "1"){
		return "出售";
	}else if(value == "2"){
		return "出租";
	}else{
		return value;
	}
}

function renderBuildType(value, p, record) {
	if(value == "1"){
		return "住宅";
	}else if(value == "2"){
		return "别墅";
	}else if(value == "3"){
		return "写字楼";
	}if(value == "4"){
		return "商铺";
	}else{
		return value;
	}
}

function renderCtype(value, p, record) {
	if(value == "1"){
		return "业主";
	}else if(value == "2"){
		return "求租";
	}else if(value == "3"){
		return "求购";
	}else{
		return value;
	}
}

function renderGender(value, p, record) {
	if(value == "1"){
		return "男";
	}else if(value == "2"){
		return "女";
	}else{
		return value;
	}
}

function renderIsDelete(value, p, record) {
	if(value == "0"){
		return "是";
	}else if(value == "1"){
		return "否";
	}else{
		return value;
	}
}

function renderMode(value, p, record) {
	if(value == "1"){
		return "电联";
	}else if(value == "2"){
		return "短信";
	}else{
		return value;
	}
}

function renderAttachmentType(value, p, record) {
	if(value == "bt"){
		return "标题图";
	}else if(value == "sn"){
		return "室内图";
	}else if(value == "fx"){
		return "房型图";
	}else if(value == "xq"){
		return "小区图";
	}else{
		return value;
	}
}

function renderRoomNum2(roomNum, hallNum) {
	var value = "";
	if(roomNum != ""){
		value += roomNum + "室";
	}
	if(hallNum != ""){
		value += hallNum + "厅";
	}
	return value;
}

function renderRoomNum(value, p, record) {
	/*value = "";
	if(record.data.roomNum != ""){
		value += record.data.roomNum + "室";
	}
	if(record.data.hallNum != ""){
		value += record.data.hallNum + "厅";
	}
	return value;*/
	return renderRoomNum2(record.data.roomNum, record.data.hallNum);
}

function renderArea2(beginArea, endArea) {
	var value = "";
	if(beginArea != "" && endArea == ""){
		value = beginArea + "㎡以上";
	}else if(beginArea == "" && endArea != ""){
		value = endArea + "㎡以下";
	}else if(beginArea != "" && endArea != ""){
		value = parseInt(beginArea) + "—" + parseInt(endArea) + "㎡";
	}
	return value;
}

function renderArea(value, p, record) {
	/*value = "";
	if(record.data.beginArea != "" && record.data.endArea == ""){
		value = record.data.beginArea + "㎡以上";
	}else if(record.data.beginArea == "" && record.data.endArea != ""){
		value = record.data.endArea + "㎡以下";
	}else if(record.data.beginArea != "" && record.data.endArea != ""){
		value = parseInt(record.data.beginArea) + "—" + parseInt(record.data.endArea) + "㎡";
	}
	return value;*/
	return renderArea2(record.data.beginArea, record.data.endArea);
}

function renderPrice2(ctype, beginPrice, endPrice) {
	var value = "";
	if(ctype == 2){ // 求租
		if(beginPrice != "" && endPrice == ""){
			value = beginPrice + "元以上";
		}else if(beginPrice == "" && endPrice != ""){
			value = endPrice + "元以下";
		}else if(beginPrice != "" && endPrice != ""){
			value = parseInt(beginPrice) + "—" + parseInt(endPrice) + "元";
		}
	}else if(ctype == 3){ // 求购
		if(beginPrice != "" && endPrice == ""){
			value = beginPrice + "万以上";
		}else if(beginPrice == "" && endPrice != ""){
			value = endPrice + "万以下";
		}else if(beginPrice != "" && endPrice != ""){
			value = parseInt(beginPrice)/10000 + "—" + parseInt(endPrice)/10000 + "万";
		}
	}
	return value;
}

function renderPrice(value, p, record) {
	return renderPrice2(record.data.ctype, record.data.beginUnitPrice, record.data.endUnitPrice);
}

function rendercheckInDate2(year, month) {
	var value = "";
	if(year != ""){
		value += year + "年";
	}
	if(month != ""){
		value += month + "月";
	}
	return value;
}

function rendercheckInDate(value, p, record) {
	return rendercheckInDate2(record.data.year, record.data.month);
}

function renderYesNo(value, p, record) {
	if(value == "1"){
		return "是";
	}else if(value == "0"){
		return "否";
	}else{
		return value;
	}
}

function renderAttachmentPath(value, p, record) {
	return String.format('<b><a href="{0}" target="_blank">{1}</a></b>', record.data.path, value);
}

function getSubValue(value, num) {
	num = num || 8;
	if(value != "" && value.length > num) {
		return value.substr(0, num) + '...';
	}else{
		return value;
	}
}

function openTab(id, title, url, height) {
	var tabPanel = window.tabPanel || window.parent.tabPanel;
	var height = height || '100%';
	var n = tabPanel.getComponent(id);
	if (!n) { 
		var n = tabPanel.add({ 
			id : id,
			title : title,
			height : height - 58,
			closable : true,
			html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="'+url+'"></iframe>'    
		}); 
	} 
	tabPanel.setActiveTab(n);
}

function detailHouseReadily(record) {
	var id = 'houseReadily' + record.data.id;
	var title = getSubValue(record.data.projectName);
	var url = basePath + 'houseReadily/houseReadilyEdit.do' + '?id=' + record.data.id;
	openTab(id, title, url, window.parent.Ext.get('menuPanel').getHeight());
}

function detailCuser(record) {
	var id = 'user' + record.data.id;
	var title = getSubValue(record.data.name);
	var url = basePath + 'user/userEdit.do' + '?id=' + record.data.id;
	openTab(id, title, url, window.parent.Ext.get('menuPanel').getHeight());
}

function renderCuser(value, p, record) {
	var id = 'user' + record.data.id;
	var title = getSubValue(record.data.name);
	var url = basePath + 'user/userEdit.do' + '?id=' + record.data.id;
	return String.format('<b><a href="javascript:void(0);" onclick="openTab(\'{0}\', \'{1}\', \'{2}\', {3});">{4}</a></b>', id, title, url, window.parent.Ext.get('menuPanel').getHeight(), value);
}

function renderHouseReadily2(value, p, record) {
	var id = 'houseReadily' + record.data.houseReadilyId;
	var title = getSubValue(value);
	var url = basePath + 'houseReadily/houseReadilyEdit.do' + '?id=' + record.data.houseReadilyId;
	return String.format('<b><a href="javascript:void(0);" onclick="openTab(\'{0}\', \'{1}\', \'{2}\', {3});">{4}</a></b>', id, title, url, window.parent.parent.Ext.get('menuPanel').getHeight(), value);
}

function renderHouseReadily3(value, p, record) {
	var id = 'houseReadily' + record.data.id;
	var title = getSubValue(value);
	var url = basePath + 'houseReadily/houseReadilyEdit.do' + '?id=' + record.data.id;
	return String.format('<b><a href="javascript:void(0);" onclick="openTab(\'{0}\', \'{1}\', \'{2}\', {3});">{4}</a></b>', id, title, url, window.parent.parent.Ext.get('menuPanel').getHeight(), value);
}

function renderHouseReadily(value, p, record) {
	var id = 'houseReadily' + record.data.id;
	var title = getSubValue(record.data.projectName);
	var url = basePath + 'houseReadily/houseReadilyEdit.do' + '?id=' + record.data.id;
	return String.format('<b><a href="javascript:void(0);" onclick="openTab(\'{0}\', \'{1}\', \'{2}\', {3});">{4}</a></b>', id, title, url, window.parent.Ext.get('menuPanel').getHeight(), value);
}

function detailCustomer(record) {
	var id = 'customer' + record.data.id;
	var title = getSubValue(record.data.name);
	var url = basePath + 'customer/customerEdit.do' + '?id=' + record.data.id;
	openTab(id, title, url, window.parent.Ext.get('menuPanel').getHeight());
}

function renderCustomer2(value, p, record) {
	var id = 'customer' + record.data.customerId;
	var title = getSubValue(value);
	var url = basePath + 'customer/customerEdit.do' + '?id=' + record.data.customerId;
	return String.format('<b><a href="javascript:void(0);" onclick="openTab(\'{0}\', \'{1}\', \'{2}\', {3});">{4}</a></b>', id, title, url, window.parent.parent.Ext.get('menuPanel').getHeight(), value);
}

function renderCustomer3(value, p, record) {
	var id = 'customer' + record.data.id;
	var title = getSubValue(value);
	var url = basePath + 'customer/customerEdit.do' + '?id=' + record.data.id;
	return String.format('<b><a href="javascript:void(0);" onclick="openTab(\'{0}\', \'{1}\', \'{2}\', {3});">{4}</a></b>', id, title, url, window.parent.parent.Ext.get('menuPanel').getHeight(), value);
}

function renderCustomer(value, p, record) {
	var id = 'customer' + record.data.id;
	var title = getSubValue(record.data.name);
	var url = basePath + 'customer/customerEdit.do' + '?id=' + record.data.id;
	return String.format('<b><a href="javascript:void(0);" onclick="openTab(\'{0}\', \'{1}\', \'{2}\', {3});">{4}</a></b>', id, title, url, window.parent.Ext.get('menuPanel').getHeight(), value);
}

function detailBaseGroup(record) {
	var id = 'baseGroup' + record.data.id;
	var title = getSubValue(record.data.groupName);
	var url = basePath + 'baseGroup/baseGroupEdit.do' + '?id=' + record.data.id;
	openTab(id, title, url, window.parent.Ext.get('menuPanel').getHeight());
}

function renderBaseGroup(value, p, record) {
	var id = 'baseGroup' + record.data.id;
	var title = getSubValue(record.data.groupName);
	var url = basePath + 'baseGroup/baseGroupEdit.do' + '?id=' + record.data.id;
	return String.format('<b><a href="javascript:void(0);" onclick="openTab(\'{0}\', \'{1}\', \'{2}\', {3});">{4}</a></b>', id, title, url, window.parent.Ext.get('menuPanel').getHeight(), value);
}
