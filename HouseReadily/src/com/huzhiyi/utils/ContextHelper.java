package com.huzhiyi.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.tastysoft.swct.db.model.TastyEntity;
import com.tastysoft.swct.util.DateHelper;

public class ContextHelper {
	
	public static List<TastyEntity> citys = new ArrayList<TastyEntity>();
	public static HashMap<String,List<TastyEntity>> areas = new HashMap();
	public static HashMap<Integer,Integer> CityToProvincesMap = new HashMap();
	public static HashMap<Integer,String> cityEnNames = new HashMap();
	public static HashMap<String,Integer> enCityCodes = new HashMap();
	public static Map<Integer,String> groups = new TreeMap();
	public static Map<Integer,String> status = new TreeMap();
	
	public static HashMap<Integer,String> allareas = new HashMap();
	public static HashMap<Integer,Integer> allareasToCityCodesMap = new HashMap();
	
    public static HashSet<String> smsKeywords = new HashSet<String>();
    public static Map<Integer,String> ctype = new TreeMap();
	public static HashSet<String> houseKeywords = new HashSet<String>();
	public static String md5Key="CopyRight 2010 Huzhiyi";
	public static Map<Integer,String> buildTypes = new HashMap<Integer, String>();
	
	public static String getAreaName(int id){
		return allareas.get(id);
	}
	
	public static String getCtypeName(Integer id){
		return ctype.get(id);
	}
	
	public static String getGroupName(Integer gid){
		return groups.get(gid);
	}
	
	public static String getStatusName(Integer id){
		return status.get(id);
	}
	
	public static String getBuildTypeName(Integer buildType) {
		return buildTypes.get(buildType);
	}
	
	/* sana */
	//缓存模板 key:stype+proType+bulidType
	public static HashMap<String, List<TastyEntity>> template=new HashMap<String, List<TastyEntity>>();
	public static boolean runShare = true;
	public static String splitSpecialStr="#@#";
	
	public static List<TastyEntity> getTemplate(String key){
		return ContextHelper.template.get(key);
	}
	
	public static void bulidTemplates(String key,List<TastyEntity> listValue){
		ContextHelper.template.put(key, listValue);
	}
	public static String getUserDefine(){
		Date dt = new Date();
		String userDefine =DateHelper.dateToString(dt, "HHmmss")+
		(int)((Math.random()*9+1)*10);
		return userDefine;
	}
	
	public static List<TastyEntity> getArea(String id){
		return areas.get(id);
	}
	
	public static String buildIds(String[] ids){
		String idvalues = "";
		for(int i=0;i<ids.length;i++){
			if(i<ids.length-1)
				idvalues+=ids[i]+",";
			else
				idvalues+=ids[i];
		}
		return idvalues;
	}

	
	public static void init(){
		//ContextHelper.areas = getArea();
	/*	buildSites();
		buildProvinces();
		Configuration.init();
		buildGroups();
		buildUserCfg();
		buildRanks();
		buildHouseErrorMsgs();
		buildSystemCfg();
		buildSmsKeywords();
		buildHouseKeywords();
		buildCustomersGroup();*/
	}
	
	/*public HashMap<String,List<TastyEntity>> getArea() {
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
		System.out.println("0:"+t.get("0").size());
		System.out.println("900001:"+t.get("900001").size());
		System.out.println("1:"+t.get("1").size());
		
		return t;
	}
	
	public ArrayList<TastyEntity> buildCitys(){
		String hql="select CCity_ from CCity CCity_ ";
		ArrayList<TastyEntity> citys = (ArrayList<TastyEntity>)this.getTastyServiceUtil().getHibernateUtil().get(hql);
		ArrayList<TastyEntity> areas =new ArrayList<TastyEntity>();
		for(int i=0;i<citys.size();i++){
			CCity city = (CCity)citys.get(i);
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
	
	public void buildProvinces(){
		String hql="select CProvince_ from CProvince CProvince_ ";
		ArrayList<TastyEntity> provinces = (ArrayList<TastyEntity>)this.getTastyServiceUtil().getHibernateUtil().get(hql);
		for(int i=0;i<provinces.size();i++){
			CProvince province = (CProvince)provinces.get(i);
			ContextHelper.allareas.put(province.getProvinceCode(),province.getProvinceName());
		}
	}
	
	public ArrayList<TastyEntity> buildAreas(){
		String hql="select CArea_ from CArea CArea_ ";
		ArrayList<TastyEntity> areas = (ArrayList<TastyEntity>)this.getTastyServiceUtil().getHibernateUtil().get(hql);
		for(int i=0;i<areas.size();i++){
			CArea area = (CArea)areas.get(i);
			ContextHelper.allareas.put(area.getId(),area.getName());
		}
		return areas;
	}
	
	
	public void buildGroups(){
		//ArrayList<TastyEntity> dd = (ArrayList<TastyEntity>)this.getTastyServiceUtil().getHibernateUtil().excuteSql(ContextHelper.sqlWebsitesRank,CHouseWebsites.class);
		String hql="select CHouseCfg_ from CHouseCfg CHouseCfg_ ";
		ArrayList<TastyEntity> groups = (ArrayList<TastyEntity>)this.getTastyServiceUtil().getHibernateUtil().get(hql);
		TastyConfigHelper.buildGroups(groups);
	}*/
}
