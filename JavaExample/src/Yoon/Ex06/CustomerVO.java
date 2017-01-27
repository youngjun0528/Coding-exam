package Yoon.Ex06;

import java.util.Date;

public class CustomerVO {

	private String name;
	private String phoneNumber;
	private int loanMoney; // ������
	private String dambo; // �㺸
	private Date loanTime; //��¿� �ð�
	private long millisTime; // ���� �ð�
	private int repayMoney;//������
	
	public long getMillisTime() {
		return millisTime;
	}
	public void setMillisTime(long millisTime) {
		this.millisTime = millisTime;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getLoanTime() {
		return loanTime;
	}
	public void setLoanTime(Date loanTime) {
		this.loanTime = loanTime;
	}
	public int getLoanMoney() {
		return loanMoney;
	}
	public void setLoanMoney(int loanMoney) {
		this.loanMoney = loanMoney;
	}
	public String getDambo() {
		return dambo;
	}
	public void setDambo(String dambo) {
		this.dambo = dambo;
	}
	public int getRepayMoney() {
		return repayMoney;
	}
	public void setRepayMoney(int repayMoney) {
		this.repayMoney = this.repayMoney + repayMoney; // ������ ���� �׾ư���.
	}

}
