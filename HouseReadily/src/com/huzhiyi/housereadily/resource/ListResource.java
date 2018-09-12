package com.huzhiyi.housereadily.resource;

import org.restlet.resource.ResourceException;

import com.tastysoft.swct.db.table.TableParam;
import com.tastysoft.swct.db.table.TableSet;
import com.huzhiyi.housereadily.request.IListCommand;
import com.huzhiyi.housereadily.response.ListResult;

public abstract class ListResource extends BaseResource{
	protected ListResult listResult;
	
	@Override
    protected void doInit() throws ResourceException {
		listResult = null;
		super.doInit();
		String pn = queryForm.getFirstValue("pageNo");
        ((IListCommand)command).setPageNo(Integer.valueOf(queryForm.getFirstValue("pageNo",(null == pn || "".equals(pn))?"1":pn)));
        String lm = queryForm.getFirstValue("limit");
        ((IListCommand)command).setLimit(Integer.valueOf(queryForm.getFirstValue("limit",(null == lm || "".equals(lm))?"20":lm)));
    }

	protected ListResult getListResult(){
		if(listResult==null){
			listResult = new ListResult();
			listResult.setCommand(command);
		}
		return listResult;
	}
	
	protected TableParam getTableParam(){
		TableParam tableParam = new TableParam();
		int pageNo = ((IListCommand)command).getPageNo();
		int limit = ((IListCommand)command).getLimit();
		int start = (pageNo-1)*limit;
		tableParam.setStart(start);
		tableParam.setLimit(limit);
		return tableParam;
	}
	
	protected TableParam getTableParamByUserId(){
		TableParam tableParam =getTableParam();
		tableParam = processUserIdRequest(tableParam);
		return tableParam;
	}
	
	protected TableParam processUserIdRequest(TableParam tableParam){
		//tableParam = this.getTastyConfigAction().numericEqFilter(tableParam, "userId", String.valueOf(command.getUserId()));
		return tableParam;
	}
	
	public TableSet filterTableSet(TableSet tableSet,String jsonPropsFilter){
		if(tableSet==null)
			return tableSet;
		for(int i=0;i<tableSet.getList().size();i++){
			tableSet.getList().get(i).setJsonPropsFilter(jsonPropsFilter);
		}
		return tableSet;
	}
	
}
