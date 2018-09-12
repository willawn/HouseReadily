package com.huzhiyi.spring;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.huzhiyi.utils.ContextHelper;
import com.huzhiyi.housereadily.model.CArea;
import com.huzhiyi.housereadily.model.CCity;
import com.tastysoft.swct.db.model.TastyEntity;
import com.tastysoft.swct.db.services.TastyService;
import com.tastysoft.yeapoo.dbmanager.DBRunner;
import com.huzhiyi.housereadily.model.CHouseCfg;
import com.huzhiyi.utils.Configuration;


public class SchedulerInitializingBean implements FactoryBean, InitializingBean, DisposableBean, BeanNameAware {
	
	private String name;
	
	private TastyService tastyService;

	public Object getObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Class getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

	public void afterPropertiesSet() throws Exception {
		ContextHelper.areas = getArea();
		//bulidTemplates();
		//buildSmsKeywords();
		//buildHouseKeywords();
		/*buildSites();
		buildProvinces();*/
		Configuration.init();
		//buildGroups();
		buildBuildTypes();
		/*buildUserCfg();
		buildRanks();
		buildHouseErrorMsgs();
		buildSystemCfg();
		buildSmsKeywords();
		buildHouseKeywords();
		buildCustomersGroup();
		System.out.println(TastySmartUpload.ImageAppPath);*/
		//System.out.println("dddd");
		
	}
	

	public HashMap<String,List<TastyEntity>> getArea() {
		HashMap<String,List<TastyEntity>> t = new HashMap();
		List<TastyEntity> areas = buildCitys();
		List<TastyEntity> areas2 = buildAreas();
		
		List<TastyEntity> newareas2 =new ArrayList();
		int parentId = 0;
		ArrayList alllevel2id =new ArrayList();
		t.put("0",areas);
		for (Iterator iter = areas.iterator(); iter.hasNext();) {
			List<TastyEntity> tmp =new ArrayList();
			CArea carea = (CArea)iter.next();
			parentId = carea.getId();
			for(Iterator iter_ = areas2.iterator(); iter_.hasNext();){
				CArea carea_ = (CArea)iter_.next();
				if(carea_.getParentId()==parentId){
					tmp.add(carea_);
					alllevel2id.add(carea_.getId());
				}else{
					newareas2.add(carea_);
				}
			}

			t.put(String.valueOf(parentId),tmp);
			areas2 = newareas2;
			newareas2 =new ArrayList();
		}
		
		//level2 to level3
		for(int i=0;i<alllevel2id.size();i++){
			List<TastyEntity> tmp =new ArrayList();
			parentId =(Integer)alllevel2id.get(i);
			for(Iterator<TastyEntity> iter_ = areas2.iterator(); iter_.hasNext();){
				CArea carea_ = (CArea)iter_.next();
				if(carea_.getParentId()==parentId){
					tmp.add(carea_);
				}else{
					newareas2.add(carea_);
				}
			}
			t.put(String.valueOf(parentId),tmp);
			tmp = new ArrayList(); 
			areas2 = newareas2;
			newareas2 =new ArrayList();
		}
//		System.out.println("0:"+t.get("0").size());
//		System.out.println("900001:"+t.get("900001").size());
//		System.out.println("1:"+t.get("1").size());
		
		return t;
	}
	
	/*
	public void buildSites(){
		String hql="select CHouseWebsites_ from CHouseWebsites CHouseWebsites_ ";
		ArrayList<TastyEntity> sites = (ArrayList<TastyEntity>)this.getTastyServiceUtil().getHibernateUtil().get(hql);
		for(int i=0;i<sites.size();i++){
			CHouseWebsites site = (CHouseWebsites)sites.get(i);
			ContextHelper.sitesMap.put(site.getSerialNo(), site.getSiteName());
		}
	}*/
	
	public ArrayList<TastyEntity> buildCitys(){
		String hql="select CCity_ from com.huzhiyi.housereadily.model.CCity CCity_";
		ContextHelper.citys = (ArrayList<TastyEntity>)this.getTastyService().getValue(hql);
		ArrayList<TastyEntity> areas =new ArrayList<TastyEntity>();
		for(int i=0;i<ContextHelper.citys.size();i++){
			CCity city = (CCity)ContextHelper.citys.get(i);
			ContextHelper.allareas.put(city.getCityCode(),city.getCityName());
			ContextHelper.cityEnNames.put(city.getCityCode(), city.getCityEnName());
			ContextHelper.enCityCodes.put(city.getCityEnName(),city.getCityCode());
			ContextHelper.CityToProvincesMap.put(city.getCityCode(),city.getProvinceId());
			
		
			CArea area = new CArea();
			area.setId(city.getCityCode());
			area.setName(city.getCityName());
			area.setParentId(0);
			areas.add(area);
		}
		return areas;
	}

	/*
	public void buildProvinces(){
		String hql="select CProvince_ from CProvince CProvince_ ";
		ArrayList<TastyEntity> provinces = (ArrayList<TastyEntity>)this.getTastyServiceUtil().getHibernateUtil().get(hql);
		for(int i=0;i<provinces.size();i++){
			CProvince province = (CProvince)provinces.get(i);
			ContextHelper.allareas.put(province.getProvinceCode(),province.getProvinceName());
		}
	}
	*/
	
	public ArrayList<TastyEntity> buildAreas(){
		String hql="select CArea_ from com.huzhiyi.housereadily.model.CArea CArea_ ";
		ArrayList<TastyEntity> areas = (ArrayList<TastyEntity>)this.getTastyService().getValue(hql);
		for(int i=0;i<areas.size();i++){
			CArea area = (CArea)areas.get(i);
			ContextHelper.allareas.put(area.getId(),area.getName());
			ContextHelper.allareasToCityCodesMap.put(area.getId(), area.getParentId());
		}
		return areas;
	}
	
	public void bulidTemplates(){
		String db="house_db";
		Connection connection =DBRunner.getConnection(db);
		String sqlStype="SELECT DISTINCT Stypes from house_pro_template";
		List<String> listStype=DBRunner.dataSql(db, connection, sqlStype, ",");
		for(int i=0;i<listStype.size();i++){
			String stype=listStype.get(i);
			String sqlProType="SELECT DISTINCT ProType from house_pro_template where Stypes="+stype;
			List<String> listProType=DBRunner.dataSql(db, connection, sqlProType, ",");
			for(int j=0;j<listProType.size();j++){
				String proType=listProType.get(j);
				String sqlBulidType="SELECT DISTINCT BuildType from house_pro_template where Stypes="+stype+" AND ProType="+proType;
				List<String> listBulidType=DBRunner.dataSql(db, connection, sqlBulidType, ",");
				for(int k=0;k<listBulidType.size();k++){
					String bulidType=listBulidType.get(k);
					String key=stype+proType+bulidType;
					String hql="SELECT CHouseProTemplate_ from com.huzhiyi.housereadily.model.CHouseProTemplate CHouseProTemplate_ where deleted=0 and enable=1 and stype="+stype+" and proType="+proType+" and bulidType="+bulidType;
					List<TastyEntity> templates=(ArrayList<TastyEntity>)this.getTastyService().getValue(hql);
					ContextHelper.bulidTemplates(key,templates);
				}
			}
		}
	}
	
	public void buildSmsKeywords(){
		String db = "house_db";
		Connection connection =DBRunner.getConnection(db);
		String sql="select keywords from customers_sms_keywords";
		ArrayList<String> keywords = DBRunner.dataSql(db,connection, sql,",");
		for(int i=0;i<keywords.size();i++){
			ContextHelper.smsKeywords.add(keywords.get(i));
		}
	}
	
	public void buildHouseKeywords(){
		String db = "house_db";
		Connection connection =DBRunner.getConnection(db);
		String sql="select keywords from customers_house_keywords";
		ArrayList<String> keywords = DBRunner.dataSql(db,connection, sql,",");
		for(int i=0;i<keywords.size();i++){
			ContextHelper.houseKeywords.add(keywords.get(i));
		}
	}
	public void buildGroups(){
		//ArrayList<TastyEntity> dd = (ArrayList<TastyEntity>)this.getTastyServiceUtil().getHibernateUtil().excuteSql(ContextHelper.sqlWebsitesRank,CHouseWebsites.class);
		String hql="select CHouseCfg_ from com.huzhiyi.housereadily.model.CHouseCfg CHouseCfg_ ";
		ArrayList<TastyEntity> groups = (ArrayList<TastyEntity>)this.getTastyService().getValue(hql);
		//ArrayList<TastyEntity> groups = (ArrayList<TastyEntity>)this.getTastyServiceUtil().getHibernateUtil().get(hql);
		//TastyConfigHelper.buildGroups(groups);
		ContextHelper.groups = new HashMap();
		for(int i=0;i<groups.size();i++){
			CHouseCfg group = (CHouseCfg)groups.get(i);
			if(group.getCtype()==1){
				ContextHelper.groups.put(group.getCid(), group.getName());
			}
		}
	}
	
	public void buildBuildTypes() {
		ContextHelper.buildTypes = new HashMap<Integer, String>();
		ContextHelper.buildTypes.put(1, "住宅");
		ContextHelper.buildTypes.put(2, "别墅");
		ContextHelper.buildTypes.put(3, "写字楼");
		ContextHelper.buildTypes.put(4, "商铺");
		ContextHelper.buildTypes.put(5, "小产权");
		ContextHelper.buildTypes.put(6, "厂房");
		ContextHelper.buildTypes.put(7, "其他");
	}
	
	/*public void buildCompanys(){
		String hql="select CCompany_ from CCompany CCompany_ ";
		ArrayList<TastyEntity> companys = (ArrayList<TastyEntity>)this.getTastyServiceUtil().getHibernateUtil().get(hql);
		TastyConfigHelper.buildCompanys(companys);
	}
	
	public void buildUserCfg(){
		String hql="select CUserCfg_ from CUserCfg CUserCfg_ ";
		ArrayList<TastyEntity> userCfgs = (ArrayList<TastyEntity>)this.getTastyServiceUtil().getHibernateUtil().get(hql);
		TastyConfigHelper.buildUserCfg(userCfgs);
	}
	
	public void buildSystemCfg(){
		String hql="select CSystemCfg_ from CSystemCfg CSystemCfg_ ";
		ArrayList<TastyEntity> systemCfgs = (ArrayList<TastyEntity>)this.getTastyServiceUtil().getHibernateUtil().get(hql);
		TastyConfigHelper.buildSystemCfg(systemCfgs);
		System.out.println(ContextHelper.getSystemCfg(1,"freeDaysOn"));
	}
	
	public void buildHouseErrorMsgs(){
		String hql="select CHouseErrorMsgs_ from CHouseErrorMsgs CHouseErrorMsgs_ ";
		ArrayList<TastyEntity> errorMsgs = (ArrayList<TastyEntity>)this.getTastyServiceUtil().getHibernateUtil().get(hql);
		TastyConfigHelper.buildHouseErrorMsgs(errorMsgs);
	}
	
	
	public void buildCustomersGroup(){
		String hql="select CCustomersGroup_ from CCustomersGroup CCustomersGroup_ where id = 1";
		ArrayList<TastyEntity> groups = (ArrayList<TastyEntity>)this.getTastyServiceUtil().getHibernateUtil().get(hql);
		ContextHelper.defaultCustomersGroupName = ((CCustomersGroup)groups.get(0)).getName();
	}
	
	public void buildSmsKeywords(){
		String db = "house_db";
		Connection connection =DBRunner.getConnection(db);
		String sql="select keywords from customers_sms_keywords";
		ArrayList<String> keywords = DBRunner.dataSql(db,connection, sql,",");
		for(int i=0;i<keywords.size();i++){
			ContextHelper.smsKeywords.add(keywords.get(i));
		}
	}
	
	public void buildHouseKeywords(){
		String db = "house_db";
		Connection connection =DBRunner.getConnection(db);
		String sql="select keywords from customers_house_keywords";
		ArrayList<String> keywords = DBRunner.dataSql(db,connection, sql,",");
		for(int i=0;i<keywords.size();i++){
			ContextHelper.houseKeywords.add(keywords.get(i));
		}
	}
	
	public void buildRanks(){
		String db = "house_db";
		Connection connection =DBRunner.getConnection(db);
		
		

        Connection con =null;   
        try{   
                Class.forName("com.mysql.jdbc.Driver");   
                connection = DriverManager.getConnection("jdbc:mysql://localhost/house?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true", "house", "house");     
        }catch(Exception e){   
            e.printStackTrace();   
        }    
        
		//get ranks city
		String sql="select distinct CityCode from house_websites_citys_mapping";
		ArrayList<String> rankCitys = DBRunner.dataSql(db,connection, sql,",");
		ArrayList<Integer> needRankCitys = new ArrayList<Integer>();
		
		Iterator<Integer> it = ContextHelper.websiteRanks.iterator();
		while(it.hasNext()){
			int key = it.next();
			if(!rankCitys.contains(String.valueOf(key))){
				needRankCitys.add(key);
			}
		}
		if(needRankCitys.size()>0){
			//websites
			sql="select SerialNo from house_websites";
			ArrayList<String> nos = DBRunner.dataSql(db,connection, sql,",");
			int serialNo = 0 ;
			int city= 0 ;
			Statement stmt = null;
			try {
				stmt = connection.createStatement();
				for(int i=0;i<nos.size();i++){
					serialNo = Integer.valueOf(nos.get(i));
					for(int j=0;j<needRankCitys.size();j++){
						city = needRankCitys.get(j);
						sql="insert into house_websites_citys_mapping(CityCode,SerialNo,Rank,Status,esfUrl,bsUrl,spUrl,xzlUrl,cfckUrl,citySiteRemark) values("+city+","+serialNo+",10000,1,'','','','','','');";
						stmt.execute(sql);
					}
				}
				stmt.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
	
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TastyService getTastyService() {
		return tastyService;
	}

	public void setTastyService(TastyService tastyService) {
		this.tastyService = tastyService;
	}
}
