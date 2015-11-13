package com.vanvalt.entity;

import java.io.Serializable;

/** 
 * @author xy.li@vanvalt.com 
 * @version Created By：2015年11月12日 上午9:35:42 
 * 
 */
public class AlarmInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5510136394959504888L;
	
	private String alertId;
	private String alertPid;
	private String province;
	private String city;
	private String stationName;
	private String stationId;
	private String signalType;
	private String signalLevel;
	private String issueTime;
	private String issueContent;
	private String recoveryChannel;
	private String dStandardTune;
	private String relieveTime;
	private String distinctionLevel;
	private String dffectValuate;
	private String docietyBenefit;
	private String tNumber;
	private String underwriter;
	private int change;
	
	public String getAlertId() {
		return alertId;
	}
	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}
	public String getAlertPid() {
		return alertPid;
	}
	public void setAlertPid(String alertPid) {
		this.alertPid = alertPid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getSignalType() {
		return signalType;
	}
	public void setSignalType(String signalType) {
		this.signalType = signalType;
	}
	public String getSignalLevel() {
		return signalLevel;
	}
	public void setSignalLevel(String signalLevel) {
		this.signalLevel = signalLevel;
	}
	public String getIssueTime() {
		return issueTime;
	}
	public void setIssueTime(String issueTime) {
		this.issueTime = issueTime;
	}
	public String getIssueContent() {
		return issueContent;
	}
	public void setIssueContent(String issueContent) {
		this.issueContent = issueContent;
	}
	public String getRecoveryChannel() {
		return recoveryChannel;
	}
	public void setRecoveryChannel(String recoveryChannel) {
		this.recoveryChannel = recoveryChannel;
	}
	public String getdStandardTune() {
		return dStandardTune;
	}
	public void setdStandardTune(String dStandardTune) {
		this.dStandardTune = dStandardTune;
	}
	public String getRelieveTime() {
		return relieveTime;
	}
	public void setRelieveTime(String relieveTime) {
		this.relieveTime = relieveTime;
	}
	public String getDistinctionLevel() {
		return distinctionLevel;
	}
	public void setDistinctionLevel(String distinctionLevel) {
		this.distinctionLevel = distinctionLevel;
	}
	public String getDffectValuate() {
		return dffectValuate;
	}
	public void setDffectValuate(String dffectValuate) {
		this.dffectValuate = dffectValuate;
	}
	public String getDocietyBenefit() {
		return docietyBenefit;
	}
	public void setDocietyBenefit(String docietyBenefit) {
		this.docietyBenefit = docietyBenefit;
	}
	public String gettNumber() {
		return tNumber;
	}
	public void settNumber(String tNumber) {
		this.tNumber = tNumber;
	}
	public String getUnderwriter() {
		return underwriter;
	}
	public void setUnderwriter(String underwriter) {
		this.underwriter = underwriter;
	}
	public int getChange() {
		return change;
	}
	public void setChange(int change) {
		this.change = change;
	}
	
	
}
