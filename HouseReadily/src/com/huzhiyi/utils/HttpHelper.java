package com.huzhiyi.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;





public class HttpHelper {
	/**
     * 执行 POST请求，返回请求响应的HTML
     *
     * @param url        
     * @param params    
     * @param charset 
     * @param pretty    
     * @return 返回请求响应的HTML
     */
    public static String doPost(String url, Map params, String charset, boolean pretty) {
        StringBuffer response = new StringBuffer();
        HttpClient client = new HttpClient();
        client.getParams().setParameter("http.protocol.content-charset", charset); 
        //创建Post法的实例
        PostMethod method = new PostMethod(url);
        //使用系统提供的默认的恢复策略
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
        //设置Http Post数据
        if (params != null) {
            NameValuePair[] data = null;
            
            Set sets = params.keySet();
            Object[] arr = sets.toArray();
            int mxsets = sets.size();
            if(mxsets>0){
                data=new NameValuePair[mxsets];
            }
            for (int i = 0; i < mxsets; i++) {
                String key = (String) arr[i];
                String val = (String) params.get(key);
                data[i]=new NameValuePair(key, val);
            }
            // 将表单的值放入postMethod�?
            method.setRequestBody(data);
                        
        }
        try {
            //执行getMethod
            int statusCode =client.executeMethod(method);
            if (statusCode == HttpStatus.SC_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (pretty) {
                        response.append(line).append("\n");
                    } else {
                        response.append(line);
                    }
                }
                reader.close();
            }
        } catch(HttpException e){
            System.out.println("Http错误原因" +e.getMessage());
        } catch (IOException e) {
            System.out.println("IO错误原因" +e.getMessage());
        }
        finally {
            method.releaseConnection();
        }
        return response.toString();
    }

    /**
     * GET请求，返回请求响应的HTML
     *
     * @param url        
     * @param params    请求的查询参可以为null
     * @param charset 字符
     * @param pretty    是否美化
     * @return 返回请求响应的HTML
     */
    public static String doGet(String url, Map params, String charset, boolean pretty) {
        StringBuffer response = new StringBuffer();
        //构HttpClient的实
        HttpClient client = new HttpClient();
        client.getParams().setParameter("http.protocol.content-charset", charset); 
        //创建Get法的实例
        GetMethod method = new GetMethod(url);
        //使用系统提供的默认的恢复策略
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());

        //设置Http Get数据
        if (params != null) {
            // 填入各个表单域的
            NameValuePair[] data = null;

            Set sets = params.keySet();
            Object[] arr = sets.toArray();
            int mxsets = sets.size();
            if(mxsets>0){
                data=new NameValuePair[mxsets];
            }
            for (int i = 0; i < mxsets; i++) {
                String key = (String) arr[i];
                String val = (String) params.get(key);
                data[i]=new NameValuePair(key, val);
            }
            // 将表单的值放入postMethod?
            if (null != data) {
            	method.setQueryString(data);
			}
        }
        try {
            //执行getMethod
            int statusCode =client.executeMethod(method);
            if (statusCode == HttpStatus.SC_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (pretty) {
                        response.append(line).append("\n");
                    } else {
                        response.append(line);
                    }
                }
                reader.close();
            }
        } catch(HttpException e){
        	e.printStackTrace();
            System.out.println("Http错误原因" +e.getMessage());
        } catch (IOException e) {
            System.out.println("IO错误原因" +e.getMessage());
        }
        finally {
            method.releaseConnection();
        }
        return response.toString();
    }
    
    
    public static void main(String[] args) {
    	Map mp = new HashMap<String, String>();
    	System.out.println(doGet("http://www.baidu.com", mp, "utf-8", false));
	}

}
