package com.gt.welcom.prd.alvert.domain;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * @author 효성
 *
 */
@Entity
public class Store{

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long storeId;

	private String storeType;
	private String storeCategory;
	private String storeName;
	private String storeDesc;
	private String certifiedNumber;
	private String certifiedPaper;
	private String storeCode;
	private String workTime;
	private String hollayDay;
	private String tel;
	private String poi;
	private String alliance;
	private String allianceCondition;
	private String storeScope;
	private int levelPoint;
	private Long saveUser;
	private Date saveTime = new Date();
	private Long updateUser;
	private Date updateTime;
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public String getStoreType() {
		return storeType;
	}
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	public String getStoreCategory() {
		return storeCategory;
	}
	public void setStoreCategory(String storeCategory) {
		this.storeCategory = storeCategory;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreDesc() {
		return storeDesc;
	}
	public void setStoreDesc(String storeDesc) {
		this.storeDesc = storeDesc;
	}
	public String getCertifiedNumber() {
		return certifiedNumber;
	}
	public void setCertifiedNumber(String certifiedNumber) {
		this.certifiedNumber = certifiedNumber;
	}
	public String getCertifiedPaper() {
		return certifiedPaper;
	}
	public void setCertifiedPaper(String certifiedPaper) {
		this.certifiedPaper = certifiedPaper;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public String getHollayDay() {
		return hollayDay;
	}
	public void setHollayDay(String hollayDay) {
		this.hollayDay = hollayDay;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPoi() {
		return poi;
	}
	public void setPoi(String poi) {
		this.poi = poi;
	}
	public String getAlliance() {
		return alliance;
	}
	public void setAlliance(String alliance) {
		this.alliance = alliance;
	}
	public String getAllianceCondition() {
		return allianceCondition;
	}
	public void setAllianceCondition(String allianceCondition) {
		this.allianceCondition = allianceCondition;
	}
	public String getStoreScope() {
		return storeScope;
	}
	public void setStoreScope(String storeScope) {
		this.storeScope = storeScope;
	}
	public int getLevelPoint() {
		return levelPoint;
	}
	public void setLevelPoint(int levelPoint) {
		this.levelPoint = levelPoint;
	}
	public Long getSaveUser() {
		return saveUser;
	}
	public void setSaveUser(Long saveUser) {
		this.saveUser = saveUser;
	}
	public Date getSaveTime() {
		return saveTime;
	}
	public void setSaveTime(Date saveTime) {
		this.saveTime = saveTime;
	}
	public Long getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeType=" + storeType + ", storeCategory=" + storeCategory
				+ ", storeName=" + storeName + ", storeDesc=" + storeDesc + ", certifiedNumber=" + certifiedNumber
				+ ", certifiedPaper=" + certifiedPaper + ", storeCode=" + storeCode + ", workTime=" + workTime
				+ ", hollayDay=" + hollayDay + ", tel=" + tel + ", poi=" + poi + ", alliance=" + alliance
				+ ", allianceCondition=" + allianceCondition + ", storeScope=" + storeScope + ", levelPoint="
				+ levelPoint + "]";
	}
}
