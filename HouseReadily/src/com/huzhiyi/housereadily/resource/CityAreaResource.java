package com.huzhiyi.housereadily.resource;

import java.util.ArrayList;
import java.util.List;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;

import com.huzhiyi.housereadily.model.CArea;
import com.huzhiyi.housereadily.model.CCity;
import com.huzhiyi.housereadily.request.CityAreaCommand;
import com.huzhiyi.housereadily.response.ListResult;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.ContextHelper;
import com.huzhiyi.utils.HzSpell;
import com.huzhiyi.utils.JsonHelper;
import com.huzhiyi.utils.RequestUtils;
import com.tastysoft.swct.db.model.TastyEntity;
import com.tastysoft.swct.db.table.TableSet;

public class CityAreaResource extends BaseResource {
	
	private static final String CITYLIST = "citylist";
	private static final String AREALIST = "arealist";
	
	@Override
	protected void doInit() throws ResourceException {
		command = new CityAreaCommand();
		super.doInit();
	}

	@Override
	protected void initQueryForm() {
		initData(queryForm);
	}

	private void initData(Form form) {
		getCommand().setCityCode(RequestUtils.requestPropertyIntValue(form, "cityCode"));
	}
	
	public CityAreaCommand getCommand() {
		return (CityAreaCommand) command;
	}
	
	private Representation cityList() {
		List<TastyEntity> citys = ContextHelper.citys;
		CCity city = null;
		for (TastyEntity entity : citys) {
			city = (CCity) entity;
			if (StringUtils.isEmpty(city.getCityEnName())) {
				city.setCityEnName(HzSpell.getFirstSpell(city.getCityName()).toLowerCase());
			}
		}
		
		TableSet tableSet = new TableSet();
		tableSet.setList(citys);
		tableSet.setTotal(citys.size());
		ListResult listResult = new ListResult();
		listResult.setTableSet(tableSet);
		
		return JsonHelper.getJson(listResult);
	}
	
	private Representation areaList() {
		Integer cityCode = getCommand().getCityCode();
		List<TastyEntity> areas = ContextHelper.areas.get(String.valueOf(cityCode));
		List<TastyEntity> subAreas = new ArrayList<TastyEntity>();
		for (TastyEntity area : areas) {
			List<TastyEntity> subAreas$ = ContextHelper.areas.get(String.valueOf(((CArea)area).getId()));
			subAreas.addAll(subAreas$);
		}
		
		TableSet areaTableSet = new TableSet();
		areaTableSet.setList(areas);
		areaTableSet.setTotal(areas.size());
		TableSet subAreaTableSet = new TableSet();
		subAreaTableSet.setList(subAreas);
		subAreaTableSet.setTotal(subAreas.size());
		ListResult listResult = new ListResult();
		listResult.setTableSet(areaTableSet);
		listResult.setTableSetTwo(subAreaTableSet);
		
		return JsonHelper.getJson(listResult);
	}
	
	@Get
	@Override
	public Representation get() throws ResourceException {
		Representation representation = null;

		if (CITYLIST.equals(command.getAction())) {
			representation = cityList();
		} else if (AREALIST.equals(command.getAction())) {
			representation = areaList();
		}

		return representation;
	}
}
