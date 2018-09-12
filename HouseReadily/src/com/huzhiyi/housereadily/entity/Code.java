package com.huzhiyi.housereadily.entity;

import java.sql.Timestamp;

import com.huzhiyi.housereadily.entity.base.AbstractCode;


/**
 * Code entity. @author MyEclipse Persistence Tools
 */
public class Code extends AbstractCode implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Code() {
    }

    
    /** full constructor */
    public Code(Integer userId, String userName, String mobile, String code, String description, Timestamp createTime) {
        super(userId, userName, mobile, code, description, createTime);        
    }
   
}
