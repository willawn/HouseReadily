package com.tastysoft.yeapoo.dbmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.mysql.jdbc.CommunicationsException;
import com.tastysoft.swct.util.DateHelper;

public class DBRunner{
	
	public final static String db="house_project_db";
	
	public static HashMap<String,Connection> connections =new HashMap<String,Connection>();
	
	public static void main(String[] args){
		DBRunner DBRunner = new DBRunner();
		String Category="本地新闻"; 
		String lastnewtime="2011-08-23 17:49:00"; 
		
		String sql="SELECT HouseNews.refindKey, HouseNews.`Subject`,left(HouseNews.Digest,45),HouseNews.PublishDate,HouseNews.ImageUrl FROM HouseNews WHERE" +
				"  HouseNews.Category ='"+Category+"' and HouseNews.PublishDate >'"+lastnewtime+"'  order by HouseNews.PublishDate desc  LIMIT 20";
		System.out.println(sql);
		ArrayList<String> houseNews=dataProjectSql(sql,"@#@"); 
		for(int i=0; i<houseNews.size();i++){
			System.out.println(houseNews.get(i));
		}
	}
	
	public static Connection getConnection(String db){
		Connection connection = connections.get(db);
		if(connection!=null){
			try {
				if(connection.isClosed()){
					resetConnection(db);
				}
			} catch (Exception e) {
				JdbcUtils.closeConnection(connection);
				resetConnection(db);
			}
		}else{
			resetConnection(db);
		}
		connection = connections.get(db);
		return connection;
	}
	
	public static void resetConnection(String db){
		Connection connection = null;
		try {
			connection = DBConnectionManager.getInstance().getConnection(db);
			connections.put(db, connection);
		} catch (SQLException e) {
			JdbcUtils.closeConnection(connection);
			connection = null;
		}
	}
	
	public static ArrayList<String> dataSql(String sql,String splitStr){
		Connection connection = DBRunner.getConnection("house_db");
		return dataSql("house_db",connection,sql,splitStr);
	}
	
	public static ArrayList<String> dataProjectSql(String sql,String splitStr){
		Connection connection = DBRunner.getConnection("house_project2_db");
		return dataSql("house_project2_db",connection,sql,splitStr);
	}
	
	public static ArrayList<String> dataSql(String db,Connection connection,String sql,String splitStr){
		ArrayList<String> arr = new ArrayList<String>();
		if(splitStr==null||splitStr.length()==0){
			splitStr=",";
		}
		String text1 = sql.toLowerCase().trim();
        int index = text1.indexOf("select ");
        if (index == -1)
        {
            return arr;
        }
        text1 = text1.substring(index + 7);
        index = text1.indexOf(" from");
        if (index == -1)
        {
            return arr;
        }
        text1 = text1.substring(0, index).trim();

        int len = text1.split(",").length;
        
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			try{
				ps = connection.prepareStatement(sql);
				rs = ps.executeQuery();
			}catch(CommunicationsException e){
				connection =DBRunner.getConnection(db);
				ps = connection.prepareStatement(sql);
				rs = ps.executeQuery();
			}
			while (rs.next()) {
				String line = "";
                for (int i = 0; i < len; i++)
                {
                    try
                    {
                        Object obj = rs.getObject(i+1);
                        if (obj == null)
                            line += "";
                        else
                        {
                            if (obj instanceof Date)
                            {
                                line += DateHelper.dateToString((Date)obj);
                            }
                            else
                            {
                                line += obj.toString();
                            }
                        }
                        
                    }
                    catch (Exception ex)
                    {
                        line += "";
                    }
                    if (i < len - 1)
                        line += splitStr;
                }
                arr.add(line);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeResultSet(rs);
			JdbcUtils.closeStatement(ps);
		}

		return arr;
	}
	
	public static int excuteSql(String db,ArrayList<String> sqls){
		//db
		int result = 1 ;
		Connection connection =DBRunner.getConnection(db);
		Statement stmt = null;
		String sql = null;
		int i=0;
		try {
			stmt = connection.createStatement();
			for(i=0;i<sqls.size();i++){
				sql = sqls.get(i);
				//System.out.println(sql);
				stmt.execute(sql);
			}
		} catch (Exception e) {
			if(e instanceof CommunicationsException){
				connection =DBRunner.getConnection(db);
				try {
					stmt = connection.createStatement();
					for(int j = i;j<sqls.size();j++){
						sql = sqls.get(j);
						stmt.execute(sql);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}/*finally {
					JdbcUtils.closeStatement(stmt);
				}*/
				
			}else
				e.printStackTrace();
			result =  -1;
		}finally {
			JdbcUtils.closeStatement(stmt);
		}
		return result;
	}
	
	public static int excuteSql(ArrayList<String> sqls){
		return excuteSql("house_db",sqls);
	}
	
	public static int excuteSql(String sql){
		ArrayList<String> sqls = new ArrayList<String>();
		sqls.add(sql);
		return excuteSql("house_db",sqls);
	}
}
