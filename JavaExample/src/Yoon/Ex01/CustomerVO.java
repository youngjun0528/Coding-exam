package Yoon.Ex01;

public class CustomerVO {

	private String name; // �̸�
	private String what; // ������Ÿ� ���ȴ���
	private long rentTime; // �����ð�

	private int money;
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return what;
	}
	public void setType(String what) {
		this.what = what;
	}

	public long getRentTime() {
		return rentTime;
	}
	public void setRentTime(long rentTime) {
		this.rentTime = rentTime;
	}
	


}