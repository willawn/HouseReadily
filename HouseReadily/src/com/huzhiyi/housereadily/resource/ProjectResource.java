package com.huzhiyi.housereadily.resource;

import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;

import com.huzhiyi.housereadily.request.ProjectCommand;
import com.huzhiyi.utils.JsonHelper;
import com.tastysoft.swct.db.table.TableParam;
import com.tastysoft.swct.db.table.TableSet;

public class ProjectResource extends ListResource{
	public String projectId =""; 
	public String projectName = ""; 
	
	@Override
    protected void doInit() throws ResourceException {
		command = new ProjectCommand();
        super.doInit();
    }
	
	public ProjectCommand getCommand(){
		return (ProjectCommand)command;
	}
	
	@Override
	public void initQueryForm(){
		this.getCommand().setAreaId(queryForm.getFirstValue("areaId"));
		this.getCommand().setSubAreaId( queryForm.getFirstValue("subAreaId")) ; 
		this.getCommand().setBuildType( queryForm.getFirstValue("buildType")); 
		this.getCommand().setLngs(queryForm.getFirstValue("lons"));//纬度
		this.getCommand().setLats(queryForm.getFirstValue("lats"));//经度
		this.getCommand().setCity(queryForm.getFirstValue("city")); //sz bj 
		projectId = queryForm.getFirstValue("id"); 
		projectName = queryForm.getFirstValue("name");
	}
	
	
	/* 
	 * 
	 * (non-Javadoc)
	 * @see org.restlet.resource.ServerResource#get()
	 */
	@Override
	@Get
	public Representation get() {
		TableParam tableParam = processHouseRequest();
		TableSet tableSet = this.getTastyService().findExtjs("CProject", tableParam);
		//tableSet =  this.filterTableSet(tableSet, "id,name,area,subArea,areaId,subAreaId,lat,lng,address,price,description");
		this.getListResult().setTableSet(tableSet);
		return JsonHelper.getJson(getListResult());
	}
	
	@Override
	@Put
	public Representation put(Representation representation, Variant variant)
			throws ResourceException {
		
		return JsonHelper.getJson(getListResult());
	}
	
	@Override
	@Post
	public Representation post(Representation entity) {
		return null;
	}

	
	/**
	 * 
	 * buildType 1 住宅 2 别墅 6 商铺 7写字楼
	 * @return
	 */
	protected TableParam processHouseRequest(){
		
		TableParam tableParam = this.getTableParamByUserId();
		if(!"".equals(projectId) && projectId !=null){
			tableParam = this.getTastyConfigAction().numericEqFilter(tableParam,"id",projectId);
		}else {
			tableParam = this.getTastyConfigAction().numericEqFilter(tableParam,"buildType",this.getCommand().getBuildType());
			tableParam = this.getTastyConfigAction().numericEqFilter(tableParam, "areaId", this.getCommand().getAreaId());
			tableParam = this.getTastyConfigAction().numericEqFilter(tableParam, "subAreaId", this.getCommand().getSubAreaId());
			tableParam = this.getTastyConfigAction().numericRangeFilter(tableParam, "lng", this.getCommand().getLngs()); 
			tableParam = this.getTastyConfigAction().numericRangeFilter(tableParam, "lat", this.getCommand().getLats()); 
			tableParam = this.getTastyConfigAction().stringLikeFilter(tableParam, "city",this.getCommand().getCity());
			
			tableParam = this.getTastyConfigAction().stringLikeFilter(tableParam, "name",projectName);
		}
		return tableParam;
	}
	

}
