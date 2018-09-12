package com.huzhiyi.housereadily.entity.base;

import java.sql.Timestamp;

import com.tastysoft.swct.db.model.TastyEntity;


/**
 * AbstractHouseOwner entity provides the base persistence definition of the HouseOwner entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractHouseOwner extends TastyEntity  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer isMain;
     private Integer houseReadilyId;
     private Integer customerId;
     private Integer creater;
     private Timestamp createTime;


    // Constructors

    /** default constructor */
    public AbstractHouseOwner() {
    }

    
    /** full constructor */
    public AbstractHouseOwner(Integer isMain, Integer houseReadilyId, Integer customerId, Integer creater, Timestamp createTime) {
        this.isMain = isMain;
        this.houseReadilyId = houseReadilyId;
        this.customerId = customerId;
        this.creater = creater;
        this.createTime = createTime;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsMain() {
        return this.isMain;
    }
    
    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
    }

    public Integer getHouseReadilyId() {
        return this.houseReadilyId;
    }
    
    public void setHouseReadilyId(Integer houseReadilyId) {
        this.houseReadilyId = houseReadilyId;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCreater() {
        return this.creater;
    }
    
    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
   








}