package com.huzhiyi.housereadily.resource;

import java.io.File;

import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.representation.FileRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

import com.huzhiyi.housereadily.request.ImageCommand;
import com.huzhiyi.utils.JsonHelper;

public class ImageResoue extends BaseResource {

	@Override
	protected void initQueryForm() {
		System.out.println("IMG");
	}
		
	@Override
	protected void doInit() throws ResourceException {
		this.command = new ImageCommand(); 
		
		super.doInit();
	}
	
	@Override
	public Representation put(Representation entity)
			throws ResourceException {
			try {
				Form form = new Form(entity);
				String filepath = this.getTastyConfigAction().requestPropertyValue(form, "filepath"); 
				FileRepresentation filereprese = new FileRepresentation(filepath,MediaType.IMAGE_ALL); 
			    File uploadFile = filereprese.getFile();
			    File file = new File(filepath); 
			   
			    System.out.println("文件名称："+uploadFile.getName());
			    System.out.println("文件路径："+uploadFile.getPath());
			    System.out.println("文件大小："+uploadFile.length()+"\t"+ file.getFreeSpace());
			    //InputStreamReader out = new InputStreamReader( entity.getStream());
			    
			    return JsonHelper.getJson(this.getStatusResult(1, uploadFile.getName()));
			} catch (Exception e) {
				e.printStackTrace(); 
			}
		//TastyImage.saveImage(request, response, AppFolder, field, userId); 
			return JsonHelper.getJson(this.getStatusResult(1, ""));
	}

	@Override
	public Representation get() throws ResourceException {
		// TODO Auto-generated method stub
		System.out.println("GET:--->");
		return super.get();
	}
	
	@Override
	public Representation delete() throws ResourceException {
		// TODO Auto-generated method stub
		System.out.println("DEL:");
		return super.delete();
	}
	
	@Override
	@Post
	public Representation post(Representation entity)
			throws ResourceException {
		System.out.println("POST");
		//return super.post(entity);
		return null;
	}
	

	
}
