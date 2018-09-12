package com.huzhiyi.utils;

import java.security.Security;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.huzhiyi.housereadily.model.CHouseSell;
import com.huzhiyi.housereadily.model.CUser;

/**
 * 使用Gmail发送邮件
 * 
 */
public class GmailSender {
	public static void main(String[] args) throws AddressException,
			MessagingException {
		String subject="房源楼书";
		String content ="<style type='text/css'>body, div, dl, dt, dd, ul, ol, li,h1, h2, h3, h4,h5,form, fieldset,input, button,textarea, p, th, td{margin: 0;padding: 0;}fieldset, img ,a img{border: 0;}em,th{font-style: normal;font-weight: normal;}strong{font-style: normal;font-weight: bold;}h1, h2, h3, h4,h5{font-size: 100%;font-weight: normal;}input, button, textarea,select,option {font-family: inherit;font-size: inherit;font-style: inherit;font-weight: inherit;}input, button, textarea, select {*font-size: 100%;}body {line-height: 1.5;}ul,ol{list-style: none;}.flatimg{height:300px;width:400px;padding:4px;border:1px solid #ddd;margin:0px 0px 10px;}table{border-collapse: collapse;border-spacing:0px;}caption, th {text-align: left;}sup, sub {font-size: 100%;vertical-align: baseline;}:link, :visited{text-decoration: none;}blockquote,q {quotes: none;}blockquote:before, blockquote:after,q:before, q:after {content: '';content: none;}.clearfix:after {content: '.';display: block;height: 0;clear: both;visibility: hidden;font-size:0;line-height:0}.clearfix {display: inline-block;}* html .clearfix {height: 1%;}.clearfix {display: block;}body.FlatReport,body{font:normal 12px/1.8em Arial,'宋体';background:#f5f6f7;font-size:12px;color:#333;text-align:center}a,a:visited{color:#555;text-decoration:none }a:active{text-decoration:none !important}a:hover{color:#000;text-decoration:underline;}body .f_l{float:left !important}body .f_r{float:right !important}.clear{clear:both;background:none;}.texthide{text-indent:-999px;overflow:hidden}.p-relative{position:relative;}.bg{clear:both;border-top:1px solid #ccc;margin:5px 0;background:none;}.bg2{clear:both;border-top:1px solid #eee;margin:5px 0;background:none;}.date{font: normal 12px Georgia, '微软雅黑','Microsoft YaHei','黑体';color:#999;margin-right:5px;}p{font:normal 12px Helvetica, '宋体';color:#aaa;line-height:1.8em;}.thumb ,.thumb img{cursor:pointer}.f-s14{font-size:14px}.f-f60{color:#f60 !important}.f-green{color:#02AE16 !important}.f-red{color:#f20 !important}.f-777{color:#777 !important}.f-07f{color:#07f !important}.num-special{ color: #F60; font-family: Georgia; font-size: 30px;}.resize{width:960px;margin:0 auto;position:relative;z-index:2}.hr{margin:1px;height:1px;border:0;background:#ddd;}.hide-opinion,.hide{display:none}.noborder{border:none !important}.nbgnbd span{background-color:#fff !important;border:none !important}.warp{width:750px;margin:0 auto;text-align:left;position:relative;zindex:5;}.main{margin:10px 0;;}.logo{background:url(logo.gif) no-repeat;width:200px;height:40px;margin:10px 0;text-indent:-999em;}.content{border:1px solid #cdcdcd;border-top:none;padding:10px 20px 20px;overflow:hidden;font:normal 14px/1.8em Arial,'宋体';}.flatinfo h1{font:bold 16px/1.8em Arial;text-align:center;margin:5px 0 20px 0;color:#d00;}.baseinfo{width:230px}.tableinfo td{font-size:12px;padding:3px;border-bottom:1px solid #ddd;text-align:left;vertical-align:top;}.baseinfo td{padding:5px;border-bottom:1px solid #ddd;text-align:left;color:#777}.tableinfo td.infotitle{font-weight:bold;color:#333;vertical-align:top;}#pics img{display:block;padding:4px ;border:1px solid #ddd;text-align:center;margin:0 auto}#pics p{font:normal 14px/1.8em Arial;margin:5px 0;color:#333}#construction table span{margin:2px 10px 2px 0}.flatmanager{border:1px solid #cdcdcd;border-top:none;padding:10px 20px 20px;}.flatmanager p.head{float:left;text-align:center;}.manhead{width:90px;height:120px;display:block;}.tel{float:right;width:200px;text-align:left;margin:10px;}.phone{height:50px;padding-left:60px;background: url(tel.png) 0 0 no-repeat;}.telname{font:bold 14px/1.5em Arial;color:#333;}.telnum{font:bold 18px/1.5em Arial;color:#000}.teltips{color:#aaa}#construction .tableinfo td.infotitle,.flatmanager .tableinfo td.infotitle{text-align:right;}#ptext,#ptext p{color:#333;font:normal 14px/1.5em Arial;} </style><div class='warp'>	<h2 class='logo'>租售365</h2>	<div class='content' style='border-top:1px solid #cdcdcd'>	<div class='flatinfo'>	<h1>地王信兴广场ABCD</h1>	<div class='clear'></div>	<div class='f_r'>	<table class='tableinfo baseinfo'>	<tr><td class='infotitle' width='40'>售价：</td>	<td style='vertical-align:baseline;'><span class='num-special' >322.0</span>万元(税费自理)</td></tr>	<tr><td class='infotitle'>单价：</td><td><strong style='font-size:14px'>2.6178861788617884</strong>元/平方米</td></tr>	<tr><td class='infotitle'>楼层：</td> <td>第15层，共22层</td></tr>	<tr><td class='infotitle'>房型：</td><td>2房2厅1厨1卫</td></tr>	<tr><td class='infotitle'>面积：</td><td>123平方米</td></tr>	<tr><td class='infotitle'>装修：</td><td>豪华装修</td></tr>	<tr><td class='infotitle'>朝向：</td><td>西北</td></tr><tr>	<tr><td class='infotitle'>小区：</td><td>地王信兴广场</td></tr></table> </div> <img src='http://s1.zushou365.com/house_imgs/fx_pics/20110730/1549/154936881793467_b.jpeg' alt='地王信兴广场ABCD' class='flatimg'/></div> </div><div class='flatmanager'>	<div class='tel'> <p class='phone'><span class='telnum'>18666476198</span><br/><span class='telname'>蓝超强</span></p><span class='teltips'>打电话时请告知是在<strong class='f-f60'>租售365上</strong>看到的，谢谢。</span> </div><p class='head'><img src='http://s1.zushou365.com/house_imgs/credit_pics/20110510/127_2_9119d8108e4aefefee230dfe4cdb7931_s.jpeg' alt='地王信兴广场ABCD' class='manhead'/></p><div class='f_l' style='margin-left:10px;width:320px;'>	<table class='tableinfo' style='width:320px;margin:0'>	<tr><td class='infotitle' width='60' >姓名：</td><td width='250'>蓝超强</td></tr>	<tr><td class='infotitle' width='60' >就职于：</td><td >KG</td></tr>	<tr><td class='infotitle' style='text-align:left' colspan='2'>最熟悉小区：</td></tr>	<tr><td colspan='2' style='padding-left:2em'>地王信兴广场</td></tr></table></div><div class='clear'><img src='flatreport/ts.gif' style='display:none'/></div> </div><div id='about' class='content'> <h2 class='itemTitle'>房源介绍</h2><div id='ptext'></div></div><div id='pics' class='content'> <h2 class='itemTitle'>房源图片</h2><p align='center'><img src='http://s1.zushou365.com/house_imgs/fx_pics/20110730/1549/154936881793467_b.jpeg'/></p><p align='center'><img src='http://s1.zushou365.com/house_imgs/fx_pics/20110805/1701/170148784616251_b.jpeg'/></p><p align='center'><img src='http://s1.zushou365.com/house_imgs/sn_pics/20110817/1253/125345268052818_b.jpeg'/></p></div><div id='maps' class='content'>	<h2 class='itemTitle'>交通指南</h2> 公交83路-公交1路-公交333路-公交310路</div><div id='construction' class='content'><h2 class='itemTitle'>周边配套</h2> 中小学：罗湖中学、桂园中学、罗湖小学</div></div></div>"; 
		String email="chao145@163.com";
		mail("417707389@qq.com",email,subject,content);
		System.out.println("pictrue");
	}
	
	public static void mail(String sendEmail, String toEmail,String subject,String content) {
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.transport.protocol", "smtp"); //发送协议
		//props.put("mail.store.protocol", "IMAP");  //接收协议
	    //props.put("mail.smtp.class", "com.sun.mail.smtp.SMTPTransport");
	    //props.put("mail.imap.class", "com.sun.mail.imap.IMAPStore");
		props.setProperty("mail.smtp.host", "61.129.81.90");//
		//props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "25");
		props.setProperty("mail.smtp.socketFactory.port", "25");
		
		final String username = "help";
		final String password = "zushou36567^&";
		Session session = Session.getDefaultInstance(props,new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
		//Session session =Session.getInstance(props); 
		session.setDebug(false); 
		MimeMessage msg = new MimeMessage(session); 
		//Message msg = new MimeMessage(session);
		
		// -- Set the FROM and TO fields --
		//msg.setFrom(new InternetAddress(username + "@zushou365.com"));
		try {
			msg.setFrom(new InternetAddress(sendEmail));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			msg.setSubject(subject);
			msg.setContent(content, "text/html;charset=UTF-8");
			msg.setSentDate(new Date());
			Transport.send(msg);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Message sent.");
		//System.out.println(content);
	}
	
	public static String pingHTML(CHouseSell house, CUser user, String haedPrictrue,int headServer){
		StringBuffer htmls = new StringBuffer(); 
		htmls.append("<style type='text/css'>"); 
		htmls.append("body, div, dl, dt, dd, ul, ol, li,h1, h2, h3, h4,h5,form, fieldset,input, button,textarea, p, th, td{margin: 0;padding: 0;}");
		htmls.append("fieldset, img ,a img{border: 0;}"); 
		htmls.append("em,th{font-style: normal;font-weight: normal;}"); 
		htmls.append("strong{font-style: normal;font-weight: bold;}"); 
		htmls.append("h1, h2, h3, h4,h5{font-size: 100%;font-weight: normal;}"); 
		htmls.append("input, button, textarea,select,option {font-family: inherit;font-size: inherit;font-style: inherit;font-weight: inherit;}"); 
		htmls.append("input, button, textarea, select {*font-size: 100%;}"); 
		htmls.append("body {line-height: 1.5;}"); 
		htmls.append("ul,ol{list-style: none;}"); 
		htmls.append(".flatimg{height:300px;width:400px;padding:4px;border:1px solid #ddd;margin:0px 0px 10px;}"); 
		htmls.append("table{border-collapse: collapse;border-spacing:0px;}"); 
		htmls.append("caption, th {text-align: left;}"); 
		htmls.append("sup, sub {font-size: 100%;vertical-align: baseline;}"); 
		htmls.append(":link, :visited{text-decoration: none;}"); 
		htmls.append("blockquote,q {quotes: none;}"); 
		htmls.append("blockquote:before, blockquote:after,q:before, q:after {content: '';content: none;}"); 
		htmls.append(".clearfix:after {content: '.';display: block;height: 0;clear: both;visibility: hidden;font-size:0;line-height:0}"); 
		htmls.append(".clearfix {display: inline-block;}"); 
		htmls.append("* html .clearfix {height: 1%;}"); 
		htmls.append(".clearfix {display: block;}"); 
		htmls.append("body.FlatReport,body{font:normal 12px/1.8em Arial,'宋体';background:#f5f6f7;font-size:12px;color:#333;text-align:center}"); 
		htmls.append("a,a:visited{color:#555;text-decoration:none }"); 
		htmls.append("a:active{text-decoration:none !important}"); 
		htmls.append("a:hover{color:#000;text-decoration:underline;}"); 
		htmls.append("body .f_l{float:left !important}body .f_r{float:right !important}.clear{clear:both;background:none;}"); 
		htmls.append(".texthide{text-indent:-999px;overflow:hidden}"); 
		htmls.append(".p-relative{position:relative;}"); 
		htmls.append(".bg{clear:both;border-top:1px solid #ccc;margin:5px 0;background:none;}"); 
		htmls.append(".bg2{clear:both;border-top:1px solid #eee;margin:5px 0;background:none;}");
		htmls.append(".date{font: normal 12px Georgia, '微软雅黑','Microsoft YaHei','黑体';color:#999;margin-right:5px;}"); 
		htmls.append("p{font:normal 12px Helvetica, '宋体';color:#aaa;line-height:1.8em;}"); 
		htmls.append(".thumb ,.thumb img{cursor:pointer}"); 
		htmls.append(".f-s14{font-size:14px}"); 
		htmls.append(".f-f60{color:#f60 !important}.f-green{color:#02AE16 !important}.f-red{color:#f20 !important}.f-777{color:#777 !important}.f-07f{color:#07f !important}"); 
		htmls.append(".num-special{ color: #F60; font-family: Georgia; font-size: 30px;}"); 
		htmls.append(".resize{width:960px;margin:0 auto;position:relative;z-index:2}"); 
		htmls.append(".hr{margin:1px;height:1px;border:0;background:#ddd;}"); 
		htmls.append(".hide-opinion,.hide{display:none}"); 
		htmls.append(".noborder{border:none !important}"); 
		htmls.append(".nbgnbd span{background-color:#fff !important;border:none !important}"); 
		htmls.append(".warp{width:750px;margin:0 auto;text-align:left;position:relative;zindex:5;}"); 
		htmls.append(".main{margin:10px 0;;}"); 
		htmls.append(".logo{background:url(logo.gif) no-repeat;width:200px;height:40px;margin:10px 0;text-indent:-999em;}"); 
		htmls.append(".content{border:1px solid #cdcdcd;border-top:none;padding:10px 20px 20px;overflow:hidden;font:normal 14px/1.8em Arial,'宋体';}"); 
		htmls.append(".flatinfo h1{font:bold 16px/1.8em Arial;text-align:center;margin:5px 0 20px 0;color:#d00;}"); 
		htmls.append(".baseinfo{width:230px}"); 
		htmls.append(".tableinfo td{font-size:12px;padding:3px;border-bottom:1px solid #ddd;text-align:left;vertical-align:top;}"); 
		htmls.append(".baseinfo td{padding:5px;border-bottom:1px solid #ddd;text-align:left;color:#777}"); 
		htmls.append(".tableinfo td.infotitle{font-weight:bold;color:#333;vertical-align:top;}"); 
		htmls.append("#pics img{display:block;padding:4px ;border:1px solid #ddd;text-align:center;margin:0 auto}"); 
		htmls.append("#pics p{font:normal 14px/1.8em Arial;margin:5px 0;color:#333}"); 
		htmls.append("#construction table span{margin:2px 10px 2px 0}"); 
		htmls.append(".flatmanager{border:1px solid #cdcdcd;border-top:none;padding:10px 20px 20px;}"); 
		htmls.append(".flatmanager p.head{float:left;text-align:center;}"); 
		htmls.append(".manhead{width:90px;height:120px;display:block;}"); 
		htmls.append(".tel{float:right;width:200px;text-align:left;margin:10px;}"); 
		htmls.append(".phone{height:50px;padding-left:60px;background: url(tel.png) 0 0 no-repeat;}"); 
		htmls.append(".telname{font:bold 14px/1.5em Arial;color:#333;}"); 
		htmls.append(".telnum{font:bold 18px/1.5em Arial;color:#000}"); 
		htmls.append(".teltips{color:#aaa}"); 
		htmls.append("#construction .tableinfo td.infotitle,.flatmanager .tableinfo td.infotitle{text-align:right;}"); 
		htmls.append("#ptext,#ptext p{color:#333;font:normal 14px/1.5em Arial;} </style>"); 
		htmls.append("<div class='warp'>"); 
		htmls.append("	<h2 class='logo'>租售365</h2>"); 
		htmls.append("	<div class='content' style='border-top:1px solid #cdcdcd'>"); 
		htmls.append("	<div class='flatinfo'>"); 
		htmls.append("	<h1>"+house.getProName()+"</h1>"); 
		htmls.append("	<div class='clear'></div>"); 
		htmls.append("	<div class='f_r'>"); 
		htmls.append("	<table class='tableinfo baseinfo'>"); 
		if(house!=null && house.getStype()==1){
			htmls.append("	<tr><td class='infotitle' width='40'>售价：</td>"); 
			htmls.append("	<td style='vertical-align:baseline;'><span class='num-special' >"+house.getHousePrice()+"</span>万元(税费自理)</td></tr>");
			double prices= house.getHousePrice()/Double.parseDouble(house.getAreaNum()); 
			htmls.append("	<tr><td class='infotitle'>单价：</td><td><strong style='font-size:14px'>"+prices+"</strong>元/平方米</td></tr>"); 
		}else {
			htmls.append("	<tr><td class='infotitle' width='40'>租金：</td>"); 
			htmls.append("	<td style='vertical-align:baseline;'><span class='num-special' >"+house.getRentPrice()+"</span>万元(税费自理)</td></tr>"); 
		}
		
		htmls.append("	<tr><td class='infotitle'>楼层：</td> <td>第"+house.getProFloor()+"层，共"+house.getFloorNum()+"层</td></tr>"); 
		htmls.append("	<tr><td class='infotitle'>房型：</td><td>"+house.getRoomNum()+"房"+house.getHallNum()+"厅"+house.getKitchenNum()+"厨"+house.getBalconyNum()+"卫</td></tr>"); 
		htmls.append("	<tr><td class='infotitle'>面积：</td><td>"+house.getAreaNum()+"平方米</td></tr>");
		String fitmentType = house.getFilterType().equals("1")?"毛坯"
							:house.getFilterType().equals("2")?"简单装修"
							:house.getFilterType().equals("3")?"中等装修"
							:house.getFilterType().equals("4")?"精装修":"豪华装修"; 
							
		htmls.append("	<tr><td class='infotitle'>装修：</td><td>"+fitmentType+"</td></tr>"); 
		String houseOri=house.getHouseOri().equals("1")?"东"
						:house.getHouseOri().equals("2")?"南"
						:house.getHouseOri().equals("3")?"西"
						:house.getHouseOri().equals("4")?"北"
						:house.getHouseOri().equals("5")?"东西"
						:house.getHouseOri().equals("6")?"南北"
						:house.getHouseOri().equals("7")?"东南"
						:house.getHouseOri().equals("8")?"西南"
						:house.getHouseOri().equals("9")?"东北":"西北"; 
		htmls.append("	<tr><td class='infotitle'>朝向：</td><td>"+houseOri+"</td></tr><tr>");
		htmls.append("	<tr><td class='infotitle'>小区：</td><td>"+house.getCommName()+"</td></tr>"); 
		
		htmls.append("</table> </div> <img src='"+getConverImages(house)+"' alt='"+house.getProName()+"' class='flatimg'/>");
		htmls.append("</div> </div>"); 
		
		htmls.append("<div class='flatmanager'>");
		htmls.append("	<div class='tel'> " +
					"<p class='phone'><span class='telnum'>"+user.getMobile()+"</span><br/><span class='telname'>"+user.getRealname()+"</span></p>" +
					"<span class='teltips'>打电话时请告知是在<strong class='f-f60'>租售365上</strong>看到的，谢谢。</span> </div>"); 
		htmls.append("<p class='head'><img src='"+getHaedPictrue(haedPrictrue,headServer)+"' alt='"+house.getProName()+"' class='manhead'/></p>");
		htmls.append("<div class='f_l' style='margin-left:10px;width:320px;'>"); 
		htmls.append("	<table class='tableinfo' style='width:320px;margin:0'>");
		htmls.append("	<tr><td class='infotitle' width='60' >姓名：</td><td width='250'>"+user.getRealname()+"</td></tr>"); 
		htmls.append("	<tr><td class='infotitle' width='60' >就职于：</td><td >"+user.getAddress()+"</td></tr>");
		htmls.append("	<tr><td class='infotitle' style='text-align:left' colspan='2'>最熟悉小区：</td></tr>"); 
		htmls.append("	<tr><td colspan='2' style='padding-left:2em'>"+house.getCommName()+"</td></tr>");
		htmls.append("</table></div>"); 
		htmls.append("<div class='clear'><img src='flatreport/ts.gif' style='display:none'/></div> </div>");
		htmls.append("<div id='about' class='content'> <h2 class='itemTitle'>房源介绍</h2>"); 
		htmls.append("<div id='ptext'>"+house.getDetail()+"</div>");
		
		htmls.append("</div>");
		htmls.append("<div id='pics' class='content'> "); //pictrue
		//htmls.append("<p align='center'><img src='flat1.jpg' alt='"+house.getProName()+"' />文字描述文字描述文字描述文字描述</p>");
		
		htmls.append("<h2 class='itemTitle'>房源图片</h2>");
		htmls.append(""+getHousePictrues(house)+"</div>");
		
		htmls.append("<div id='maps' class='content'>");
		htmls.append("	<h2 class='itemTitle'>交通指南</h2>"); 
		htmls.append(" "+house.getTrafficInfo()+"</div>");
		htmls.append("<div id='construction' class='content'><h2 class='itemTitle'>周边配套</h2>"); 
		htmls.append(" "+house.getAroundCondition()+"</div>");
		htmls.append("</div>"); 
		htmls.append("</div>");		
		return htmls.toString(); 
	}
	
	public static String getConverImages(CHouseSell house){
		if(house.getCoverImage()!=null){
			String temp = house.getCoverImage().replace("_s", "_b");
			if(temp.startsWith("http://")){
				return temp; 
			}else{
				return imageHost(house.getImageServer())+""+temp; 
			}
		}else{
			return null;	
		}
	}
	
	public static String getHaedPictrue(String haedPrictrue,int server){
		if(haedPrictrue.startsWith("http://")){
			return haedPrictrue; 
		}else {
			return imageHost(server)+""+haedPrictrue; 
		}
	}
	
	
	public static String getHousePictrues(CHouseSell house){
		StringBuffer imageBuffer = new StringBuffer();
		if(house!=null){

			String temp = house.getUploadcommodelfile()+","+house.getUploadcommpicfile()+","+house.getUploadpropertypicfile();
			String [] images = temp.split(",");
			for(int i =0; i<images.length; i++){
				if(images[i].startsWith("http://")){
					imageBuffer.append("<p align='center'><img src='"+images[i].replace("_s", "_b")+"'/></p>"); 
				}else{
					imageBuffer.append("<p align='center'><img src='"+imageHost(house.getImageServer())+""+images[i].replace("_s", "_b")+"'/></p>") ; 
				}
			}
		}
		return imageBuffer!=null ?imageBuffer.toString():"";
	}
	
	public static String imageHost(int server){
		if(server==1){
			return "http://image.zushou365.com/house_imgs/"; 
		}else {
			return "http://s2.zushou365.com/house_imgs/"; 
		}
	}
}